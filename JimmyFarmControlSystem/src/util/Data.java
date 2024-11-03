package util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import model.CatatanHarianUtama;
import model.User;

public class Data {
	public final Connect connect = Connect.getInstance();
	
	public void insertUser(User user) {
		String query = String.format("INSERT INTO MsUser (UserID, Name, Username, passwd) VALUES ('%s', '%s', '%s', '%s')"
				, user.getID(), user.getName(), user.getUsername(), user.getPassword());
		
		connect.execUpdate(query);
		reusableMethod.showAlert(AlertType.INFORMATION, "User","User Created!");
	}
	
	
	public String getNewUserID() {
		String query = "SELECT UserID from MsUser "
				+ "ORDER BY UserID "
				+ "DESC LIMIT 1";
		
		String lastID = "";
		connect.rs = connect.execQuery(query);
		try {
			if(!(connect.rs.next())) {
				return "US001";
			}
			
			lastID = connect.rs.getString("UserID");
			String num = lastID.substring(2);
			Integer incr = Integer.parseInt(num) + 1;
			
			lastID = String.format("US%03d", incr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastID;
	}
	
	public String getkodeCatatan() {
		String query = "SELECT KODE_CATATAN from catatanharianutama"
				+ "ORDER BY KODE_CATATAN "
				+ "DESC LIMIT 1";
		
		String lastKode = "";
		connect.rs = connect.execQuery(query);
		try {
			if(!(connect.rs.next())) {
				return "KCT00001";
			}
			
			lastKode = connect.rs.getString("KODE_CATATAN");
			String num = lastKode.substring(2);
			Integer incr = Integer.parseInt(num) + 1;
			
			lastKode = String.format("KCT%05d", incr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastKode;
	}

	public ArrayList<User> getUserData() {
		connect.rs = connect.execQuery("SELECT * FROM MsUser");
		
		ArrayList<User> user_list = new ArrayList<User>();
		
		try {
			while(connect.rs.next()) {
				String ID = connect.rs.getString("USERID");
				String name = connect.rs.getString("NAME");
				String username = connect.rs.getString("USERNAME");
				String passwd = connect.rs.getString("PASSWORD");
				
				user_list.add(new User(ID, name, username, passwd, passwd));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user_list;
	} 
	
	public ObservableList<CatatanHarianUtama> getCatatanHarian() {
		connect.rs = connect.execQuery("SELECT * FROM CatatanHarianUtama");
		
		ObservableList<CatatanHarianUtama> listCatatan = FXCollections.observableArrayList();
		
		try {
			while(connect.rs.next()) {
				String kodeKandang = connect.rs.getString("KODE_KANDANG");
				String kodeCatatan = connect.rs.getString("KODE_CATATAN"); 
				String KeteranganJenis = connect.rs.getString("KETERANGAN_JENIS");
				Date TanggalMasuk = connect.rs.getDate("TANGGAL_MASUK");
				Integer jumlahAwalJantan = connect.rs.getInt("JUMLAH_AWAL_JANTAN"); 
				Integer jumlajAwalBetina = connect.rs.getInt("JUMLAH_AWAL_BETINA");
				String Komentar = connect.rs.getString("KOMENTAR");
				
				listCatatan.add(new CatatanHarianUtama(kodeCatatan, TanggalMasuk, kodeKandang, KeteranganJenis, jumlahAwalJantan,
						jumlajAwalBetina, Komentar));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCatatan;
	}
	
	public void updateCatatanHarianData(CatatanHarianUtama catatan) {
		
		String query = String.format("UPDATE CatatanHarianUtama "
                + "SET KODE_CATATAN = '%s', KODE_KANDANG = '%s', "
                + "KETERANGAN_JENIS = '%s', TANGGAL_MASUK = '%s', "
                + "JUMLAH_AWAL_JANTAN = %d, JUMLAH_AWAL_BETINA = %d, "
                + "KOMENTAR = '%s' "
                + "WHERE KODE_CATATAN = '%s'",
                catatan.getKodeCatatan(), catatan.getKodeKandang(),
                catatan.getKeteranganJenis(), catatan.getTanggalMasuk().toString(),
                catatan.getJumlahAwalJantan(), catatan.getJumlahAwalBetina(),
                catatan.getKomentar(), catatan.getKodeCatatan()
		);
		connect.execUpdate(query);
	}
	
	public void deleteCatatanHarianData(CatatanHarianUtama catatan) {
		String query = String.format("DELETE FROM catatanharianutama"
				+ " WHERE KODE_KANDANG  = '%s'", catatan.getKodeKandang());
		connect.execUpdate(query);
	}
	
	public void insertCatatanHarianUtama(CatatanHarianUtama catatanharianutama) {
	    String query = String.format("INSERT INTO CatatanHarianUtama VALUES ('%s', '%s', '%s','%s', '%d', '%d', '%s')",
	            catatanharianutama.getKodeCatatan(), 
	            catatanharianutama.getTanggalMasuk().toString(), 
	            catatanharianutama.getKodeKandang(), 
	            catatanharianutama.getKeteranganJenis(), 
	            catatanharianutama.getJumlahAwalJantan(), 
	            catatanharianutama.getJumlahAwalBetina(), 
	            catatanharianutama.getKomentar());
		connect.execUpdate(query);	
		reusableMethod.showAlert(AlertType.INFORMATION, "CatatanHarianUtama", "CatatanHarianUtama Added Succesfully!");
	}
	
	public void refreshCatatanHarianUtamaTable(TableView<CatatanHarianUtama> catatan) {
		catatan.getItems().clear();
		catatan.setItems(getCatatanHarian());
	}
}
