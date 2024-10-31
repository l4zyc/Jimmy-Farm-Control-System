package util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

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

	
	public ArrayList<User> getData() {
		connect.rs = connect.execQuery("SELECT * FROM MsUser");
		
		ArrayList<User> user_list = new ArrayList<User>();
		
		try {
			while(connect.rs.next()) {
				String ID = connect.rs.getString("UserID");
				String name = connect.rs.getString("Name");
				String username = connect.rs.getString("Username");
				String passwd = connect.rs.getString("passwd");
				
				user_list.add(new User(ID, name, username, passwd, passwd));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user_list;
	}
	
	public ArrayList<CatatanHarianUtama> getCatatanHarian() {
		connect.rs = connect.execQuery("SELECT * FROM catatanharianutama");
		
		ArrayList<CatatanHarianUtama> listCatatan = new ArrayList<CatatanHarianUtama>();
		
		try {
			while(connect.rs.next()) {
				String kodeKandang = connect.rs.getString("KODE_KANDANG");
				String Lokasi = connect.rs.getString("LOKASI"); 
				String KeteranganJenis = connect.rs.getString("KETERANGAN_JENIS");
				Date TanggalMasuk = connect.rs.getDate("TANGGAL_MASUK");
				Integer jumlahAwalJantan = connect.rs.getInt("JUMLAH_AWAL_JANTAN"); 
				Integer jumlajAwalBetina = connect.rs.getInt("JUMLAH_AWAL_BETINA");
				String Komentar = connect.rs.getString("KOMENTAR");
				
				listCatatan.add(new CatatanHarianUtama(kodeKandang, Lokasi, TanggalMasuk, KeteranganJenis, jumlahAwalJantan,
						jumlajAwalBetina, Komentar));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCatatan;
	}
}
