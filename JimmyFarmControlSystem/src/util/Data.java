package util;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Alert.AlertType;
import model.CatatanHarianDetail;
import model.CatatanHarianUtama;
import model.DaftarObat;
import model.DaftarPakan;
import model.DaftarSupplier;
import model.MsKandang;
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
		Obat.setItems(getObatData());
	}

	//===================================================================================================== 
	//===================================================================================================== 
	//===================================================================================================== 
	//===================================================================================================== 

	public String getNewKodePakan() {
		String query = "SELECT KODE_PAKAN from MsPakan "
				+ "ORDER BY KODE_PAKAN DESC LIMIT 1";
		
		String lastKode = "";
		connect.rs = connect.execQuery(query);
		try {
			if(!(connect.rs.next())) {
				return "PKN00001";
			}
			
			lastKode = connect.rs.getString("KODE_PAKAN");
			String num = lastKode.substring(3);
			Integer incr = Integer.parseInt(num) + 1;
			
			lastKode = String.format("PKN%05d", incr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastKode;
	}
	
	public ObservableList<DaftarPakan> getMasterPakanData() {
		ObservableList<DaftarPakan> lists = FXCollections.observableArrayList();
		
		String query = "SELECT * FROM MsPakan";
		
		connect.rs = connect.execQuery(query);
		
		try {
			while(connect.rs.next()) {
				String KODE_PAKAN = connect.rs.getString("KODE_PAKAN");
				String NAMA_PAKAN = connect.rs.getString("NAMA_PAKAN");
				String JENIS_PAKAN = connect.rs.getString("JENIS_PAKAN");
				Integer HARGA = Integer.parseInt(connect.rs.getString("HARGA"));
				
				lists.add(new DaftarPakan(KODE_PAKAN, NAMA_PAKAN, JENIS_PAKAN, HARGA));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lists;
	}
	
	public void insertMasterPakan(DaftarPakan pakan) {
		String query = String.format("INSERT INTO MsPakan VALUES ("
				+ " '%s', '%s', '%s', %d"
				+ ")", pakan.getKodePakan(),
				pakan.getNamaPakan(),
				pakan.getJenisPakan(),
				pakan.getHarga());
		
		connect.execUpdate(query);
		reusableMethod.showAlert(AlertType.INFORMATION, "Data", "Data Added!");
	}
	
	public void updateMasterPakan(DaftarPakan pakan) {
		
		String query = String.format("UPDATE mspakan "
				+ "SET KODE_PAKAN = '%s', NAMA_PAKAN = '%s', "
				+ "JENIS_PAKAN = '%s', HARGA = %d WHERE "
				+ "KODE_PAKAN = '%s'", pakan.getKodePakan(), 
				pakan.getNamaPakan(), pakan.getJenisPakan(),
				pakan.getHarga(), pakan.getKodePakan());
		connect.execUpdate(query);
	}
	
	public void deleteMasterPakan(DaftarPakan pakan) {
		String deleteFromMasterPakan = String.format(
				"DELETE FROM mspakan WHERE KODE_PAKAN = '%s'", 
				pakan.getKodePakan());
		
		connect.execUpdate(deleteFromMasterPakan);
	}
	
	public void refreshTablePakan(TableView<DaftarPakan> pakan) {
		pakan.setItems(getMasterPakanData());
	}
	
//===================================================================================================== 
//Bagian Kandang
	public ObservableList<MsKandang> getMasterKandangData(){
		connect.rs = connect.execQuery("SELECT * FROM mskandang");
		
		ObservableList<MsKandang> kandang_list = FXCollections.observableArrayList();
		
		try {
			while(connect.rs.next()) { 
				String KodeKandang = connect.rs.getString("KODE_KANDANG");
				String Lokasi = connect.rs.getString("LOKASI");
			
				kandang_list.add(new MsKandang(KodeKandang, 
						Lokasi));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return kandang_list;	
	} 
	
	public void insertMasterKandang(MsKandang mskandang) {
	    String query = String.format("INSERT INTO mskandang VALUES ('%s', '%s')",
	    		mskandang.getKodeKandang(), 
	    		mskandang.getLokasi());
		connect.execUpdate(query);	
		reusableMethod.showAlert(AlertType.INFORMATION, "Master Kandang", "New Data Kandang Added Succesfully!");
	}	
	
	public void updateMasterKandang(MsKandang kandang) {
		
		String query = String.format("UPDATE mskandang "
                + "SET KODE_KANDANG = '%s', LOKASI = '%s' "
                + "WHERE KODE_KANDANG = '%s'", 
                kandang.getKodeKandang(), kandang.getLokasi(), 
                kandang.getKodeKandang()
                
		);
		connect.execUpdate(query);
	}
	
	public void deleteMasterKandang(MsKandang kandang) {
		 
	    String deleteMainQuery = String.format(
	        "DELETE FROM mskandang "
	        + "WHERE KODE_KANDANG = '%s'", 
	        kandang.getKodeKandang()
	    );
	    
	    String deleteFromCatatanHarianUtama = String.format(
		        "DELETE FROM from catatanharianutama "
		        + "WHERE KODE_KANDANG = '%s'", 
		        kandang.getKodeKandang()
		    );
	    
	    connect.execUpdate(deleteFromCatatanHarianUtama);
	    connect.execUpdate(deleteMainQuery);
	}	
	
	public void refreshMasterKandang(TableView<MsKandang> Kandang) {
		Kandang.setItems(getMasterKandangData());
	}
	
	
//=====================================================================================================
//Data Base Master Supplier	

	public String getNewkodeSupplier() {
		String query = "SELECT KODE_SUPPLIER from mssupplier "
				+ "ORDER BY KODE_SUPPLIER DESC LIMIT 1";
		
		String lastKode = "";
		connect.rs = connect.execQuery(query);
		try {
			if(!(connect.rs.next())) {
				return "SU001";
			}
			
			lastKode = connect.rs.getString("KODE_SUPPLIER");
			String num = lastKode.substring(2);
			Integer incr = Integer.parseInt(num) + 1;
			
			lastKode = String.format("SU%03d", incr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastKode;
	}

	
	
	public ObservableList<DaftarSupplier> getMasterSupplierData(){
		connect.rs = connect.execQuery("SELECT * FROM mssupplier");
		
		ObservableList<DaftarSupplier> supplier_list = FXCollections.observableArrayList();
		
		try {
			while(connect.rs.next()) { 
				String KodeSupplier = connect.rs.getString("KODE_SUPPLIER");
				String NamaSupplier = connect.rs.getString("NAMA_SUPPLIER");
			
			
				supplier_list.add(new DaftarSupplier(KodeSupplier, 
						NamaSupplier));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return supplier_list;	
	} 
	
	public void insertMasterSupplier(DaftarSupplier daftarsupplier) {
	    String query = String.format("INSERT INTO mssupplier VALUES ('%s', '%s')",
	    		daftarsupplier.getKodeSupplier(), 
	    		daftarsupplier.getNamaSupplier());
		connect.execUpdate(query);	
		reusableMethod.showAlert(AlertType.INFORMATION, "Master Supplier", "New Data Supplier Added Succesfully!");
	}
	
	public void updateMasterSupplier(DaftarSupplier supplier) {
		
		String query = String.format("UPDATE mssupplier "
                + "SET KODE_SUPPLIER = '%s', NAMA_SUPPLIER = '%s' "
                + "WHERE KODE_SUPPLIER = '%s'",
                supplier.getKodeSupplier(), supplier.getNamaSupplier(),
                supplier.getKodeSupplier()
		);
		connect.execUpdate(query);
	}
	 
	public void deleteMasterSupplier(DaftarSupplier supplier) {
		String deleteFromPakan = String.format(
				"DELETE FROM supplierobatpakan "
				+ "WHERE KODE_SUPPLIER = '%s'",
				supplier.getKodeSupplier());
		
	    String deleteMainQuery = String.format(
	        "DELETE FROM mssupplier "
	        + "WHERE KODE_SUPPLIER = '%s'", 
	        supplier.getKodeSupplier()
	    );
	    connect.execUpdate(deleteFromPakan);
	    connect.execUpdate(deleteMainQuery);
	}	
	
	public void refreshMasterSupplier(TableView<DaftarSupplier> Supplier) {
		Supplier.setItems(getMasterSupplierData());
	}
	
	public void refreshTableMasterPakan(TableView<DaftarPakan> table) {
		table.getItems().clear();
		table.setItems(null);
	}

//========================================================================================	
//Catatan Harian Detail
	public Integer calculateAge(Date Date) {
		LocalDate currDate = LocalDate.now();
		LocalDate startDate = Date.toLocalDate();
			
		Integer year = currDate.getYear() - startDate.getYear();
		
		if(currDate.getMonthValue() < startDate.getMonthValue()
				||
		        (currDate.getMonthValue() == startDate.getMonthValue() 
		        && currDate.getDayOfMonth() < startDate.getDayOfMonth())) {
			year--;
		}
		
		return year;
	}
	
	public Integer calculateWeeks(Date Date) {
		LocalDate currDate = LocalDate.now();
		LocalDate startDate = Date.toLocalDate();
		
	    long daysDifference = currDate.toEpochDay() - startDate.toEpochDay();

	    int weeks = (int) (daysDifference / 7);

	    return weeks;
	}
	
	public Integer getJumlahJantan(String KODE_CATATAN) {
		Integer JUMLAH_JANTAN = 0;
		
		
		String catatanUtamaQuery = String.format(
				"SELECT * FROM catatanharianutama "
				+ "WHERE KODE_CATATAN = '%s'", KODE_CATATAN);
		
		connect.rs = connect.execQuery(catatanUtamaQuery);
		
		try {
			if(connect.rs.next()) {
				JUMLAH_JANTAN = connect.rs.getInt("JUMLAH_AWAL_JANTAN");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return JUMLAH_JANTAN;
	}
	
	public Integer getJumlahBetina(String KODE_CATATAN) {
		Integer JUMLAH_BETINA = 0;
		
		String catatanUtamaQuery = String.format(
				"SELECT * FROM catatanharianutama "
				+ "WHERE KODE_CATATAN = '%s'", KODE_CATATAN);
		
		connect.rs = connect.execQuery(catatanUtamaQuery);
		try {
			if(connect.rs.next()) {
				JUMLAH_BETINA = connect.rs.getInt("JUMLAH_AWAL_JANTAN");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return JUMLAH_BETINA;
	}
	
	public ObservableList<CatatanHarianDetail> getCatatanHarianDetail() {
		String query = "SELECT * FROM viewcatatanhariandetail";
		
		connect.rs = connect.execQuery(query);
		ObservableList<CatatanHarianDetail> lists = FXCollections.observableArrayList();
		
		try {
			while(connect.rs.next()) {
				
				String KODE_CATATAN = connect.rs.getString("KODE_CATATAN");
				Date TANGGAL_CATATAN = connect.rs.getDate("TANGGAL_CATATAN"); 
				Integer KEMATIAN_JANTAN = connect.rs.getInt("KEMATIAN_JANTAN");
				Integer SISA_JANTAN = connect.rs.getInt("SISA_JANTAN");
				Integer KEMATIAN_BETINA = connect.rs.getInt("KEMATIAN_BETINA");
				Integer SISA_BETINA = connect.rs.getInt("SISA_BETINA");
				String TOTAL_SISA = connect.rs.getString("TOTAL_SISA");
				String KODE_PAKAN = connect.rs.getString("KODE_PAKAN");
				Integer JUMLAH_PAKAN = connect.rs.getInt("JUMLAH_PAKAN");
				String KODE_OBAT = connect.rs.getString("KODE_OBAT");
				Integer JUMLAH_OBAT = connect.rs.getInt("JUMLAH_OBAT");
				Integer PRODUKSI_TELUR = connect.rs.getInt("BIAYA_VARIABEL");
				String KOMENTAR_KEMATIAN = connect.rs.getString("KOMENTAR_KEMATIAN");
				
				
				lists.add(new CatatanHarianDetail(
						KODE_CATATAN,
						TANGGAL_CATATAN,
						calculateAge(TANGGAL_CATATAN),
						calculateWeeks(TANGGAL_CATATAN),
						KEMATIAN_JANTAN,
						SISA_JANTAN,
						KEMATIAN_BETINA,
						SISA_BETINA,
						TOTAL_SISA,
						KODE_PAKAN,
						JUMLAH_PAKAN
					));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lists;
	}
} 
