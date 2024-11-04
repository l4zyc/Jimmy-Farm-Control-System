package util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import model.CatatanHarianUtama;
import model.DaftarObat;
import model.User;

public class Data {
	public final Connect connect = Connect.getInstance();
//Urusin bagian Login dan Register	
	public void insertUser(User user) {
		String query = String.format("INSERT INTO MsUser (UserID, Name, Username, passwd) VALUES ('%s', '%s', '%s', '%s')"
				, user.getID(), user.getName(), user.getUsername(), user.getPassword());
		
		connect.execUpdate(query);
		reusableMethod.showAlert(AlertType.INFORMATION, "User","User Created!");
	}
	
	//Set User ID
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
//===================================================================================
//Bagian CatatanHarianUtama
	public String getNewkodeCatatan() {
		String query = "SELECT KODE_CATATAN from CatatanHarianUtama "
				+ "ORDER BY KODE_CATATAN DESC LIMIT 1";
		
		String lastKode = "";
		connect.rs = connect.execQuery(query);
		try {
			if(!(connect.rs.next())) {
				return "KCT00001";
			}
			
			lastKode = connect.rs.getString("KODE_CATATAN");
			String num = lastKode.substring(3);
			Integer incr = Integer.parseInt(num) + 1;
			
			lastKode = String.format("KCT%05d", incr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastKode;
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
	    String deleteDetailsQuery = String.format(
	        "DELETE FROM catatanhariandetail "
	        + "WHERE KODE_CATATAN = '%s'", 
	        catatan.getKodeCatatan()
	    );
	    connect.execUpdate(deleteDetailsQuery);

	    String deleteMainQuery = String.format(
	        "DELETE FROM catatanharianutama "
	        + "WHERE KODE_CATATAN = '%s'", 
	        catatan.getKodeCatatan()
	    );
	    connect.execUpdate(deleteMainQuery);
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
//===================================================================================================== 

	public String getNewkodeObat() {
		String query = "SELECT KODE_OBAT from msobat "
				+ "ORDER BY KODE_OBAT DESC LIMIT 1";
		
		String lastKode = "";
		connect.rs = connect.execQuery(query);
		try {
			if(!(connect.rs.next())) {
				return "OBT00001";
			}
			
			lastKode = connect.rs.getString("KODE_OBAT");
			String num = lastKode.substring(3);
			Integer incr = Integer.parseInt(num) + 1;
			
			lastKode = String.format("OBT%05d", incr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastKode;
	}

	
	
	public ObservableList<DaftarObat> getObatData(){
		connect.rs = connect.execQuery("SELECT * FROM MsObat");
		
		ObservableList<DaftarObat> obat_list = FXCollections.observableArrayList();
		
		try {
			while(connect.rs.next()) { 
				String KodeObat = connect.rs.getString("KODE_OBAT");
				String NamaObat = connect.rs.getString("NAMA_OBAT");
				String JenisObat = connect.rs.getString("JENIS_OBAT");
				Integer Dosis = connect.rs.getInt("DOSIS");
				String Satuan = connect.rs.getString("SATUAN");
				String Penyakit = connect.rs.getString("PENYAKIT");
				Integer JumlahPerPack = connect.rs.getInt("JUMLAH_PER_PACK");
				Integer HargaPerPack = connect.rs.getInt("HARGA_PER_PACK");
				Integer HargaPerSatuan = connect.rs.getInt("HARGA_PER_SATUAN");
			
				obat_list.add(new DaftarObat(KodeObat, 
						NamaObat, 
						JenisObat, 
						Dosis, 
						Satuan, 
						Penyakit, 
						JumlahPerPack, 
						HargaPerPack, 
						HargaPerSatuan));
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obat_list;	
	} 
	
	public void insertMasterObat(DaftarObat daftarobat) {
	    String query = String.format("INSERT INTO msobat VALUES ('%s', '%s', '%s', '%d', '%s', '%s', '%d', '%d', '%d')",
	            daftarobat.getKodeObat(), 
	            daftarobat.getNamaObat(), 
	            daftarobat.getJenisObat(), 
	            daftarobat.getDosis(), 
	            daftarobat.getSatuan(), 
	            daftarobat.getPenyakit(), 
	            daftarobat.getJumlahPerPack(), 
	            daftarobat.getHargaPerPack(), 
	            daftarobat.getHargaPerSatuan());
		connect.execUpdate(query);	
		reusableMethod.showAlert(AlertType.INFORMATION, "Master Obat", "New Data Obat Added Succesfully!");
	}
	
	public void updateMasterObat(DaftarObat Obat) {
		
		String query = String.format("UPDATE msobat "
                + "SET KODE_OBAT = '%s', NAMA_OBAT = '%s', "
                + "JENIS_OBAT = '%s', DOSIS = %d, "
                + "SATUAN = '%s', PENYAKIT = '%s', "
                + "JUMLAH_PER_PACK = %d, HARGA_PER_PACK = %d, "  
                + "HARGA_PER_SATUAN = %d "
                + "WHERE KODE_OBAT = '%s'",
                Obat.getKodeObat(), Obat.getNamaObat(), Obat.getJenisObat(), 
                Obat.getDosis(), Obat.getSatuan(), Obat.getPenyakit(), 
                Obat.getJumlahPerPack(), Obat.getHargaPerPack(), 
                Obat.getHargaPerSatuan(), Obat.getKodeObat()
		);
		connect.execUpdate(query);
	}
	 
	public void deleteMasterObat(DaftarObat Obat) {
	    String deleteDetailsQuery = String.format(
	        "DELETE FROM msobat "
	        + "WHERE KODE_OBAT = '%s'", 
	        Obat.getKodeObat()
	    );
	    connect.execUpdate(deleteDetailsQuery);

	    String deleteMainQuery = String.format(
	        "DELETE FROM msobat "
	        + "WHERE KODE_OBAT = '%s'", 
	        Obat.getKodeObat()
	    );
	    connect.execUpdate(deleteMainQuery);
	}	
	
	public void refreshMasterObat(TableView<DaftarObat> Obat) {
		Obat.getItems().clear();
		Obat.setItems(getObatData());
	}



	
} 
