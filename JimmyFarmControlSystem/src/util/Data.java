package util;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;

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
		String query = String.format("INSERT INTO MsUser (USERID, NAME, USERNAME, PASSWORD) VALUES ('%s', '%s', '%s', '%s')"
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
	
	public CatatanHarianUtama getSpecificCatatanHarian(String KODE_CATATAN) {
		String query = String.format("SELECT * FROM CatatanHarianUtama WHERE KODE_CATATAN = '%s'",
				KODE_CATATAN, KODE_CATATAN);
		connect.rs = connect.execQuery(query);
		
		CatatanHarianUtama catatan = null;
		
		try {
			while(connect.rs.next()) {
				String kodeKandang = connect.rs.getString("KODE_KANDANG");
				String kodeCatatan = connect.rs.getString("KODE_CATATAN"); 
				String KeteranganJenis = connect.rs.getString("KETERANGAN_JENIS");
				Date TanggalMasuk = connect.rs.getDate("TANGGAL_MASUK");
				Integer jumlahAwalJantan = connect.rs.getInt("JUMLAH_AWAL_JANTAN"); 
				Integer jumlajAwalBetina = connect.rs.getInt("JUMLAH_AWAL_BETINA");
				String Komentar = connect.rs.getString("KOMENTAR");
				
				catatan = new CatatanHarianUtama(kodeCatatan, TanggalMasuk, kodeKandang, KeteranganJenis, jumlahAwalJantan,
						jumlajAwalBetina, Komentar);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return catatan;
	}
	
	//=================================
	public CatatanHarianDetail getSpecificCatatanHarianDetail(String KODE_CATATAN, Date TANGGAL_CATATAN) {
	    // Query SQL untuk mendapatkan data spesifik
	    String query = String.format(
	        "SELECT * FROM CatatanHarianDetail WHERE KODE_CATATAN = '%s' AND TANGGAL_CATATAN = '%s'",
	        KODE_CATATAN, TANGGAL_CATATAN.toString()
	    );
	    connect.rs = connect.execQuery(query);

	    // Objek CatatanHarianDetail yang akan dikembalikan
	    CatatanHarianDetail catatanDetail = null;

	    try {
	        // Jika ada hasil query
	        if (connect.rs.next()) {
	            // Ambil data dari ResultSet
	            String kodeCatatan = connect.rs.getString("KODE_CATATAN");
	            Date tanggalCatatan = connect.rs.getDate("TANGGAL_CATATAN");
	            Integer kematianJantan = connect.rs.getInt("KEMATIAN_JANTAN");
	            Integer kematianBetina = connect.rs.getInt("KEMATIAN_BETINA");
	            String kodePakan = connect.rs.getString("KODE_PAKAN");
	            Integer jumlahPakan = connect.rs.getInt("JUMLAH_PAKAN");
	            String kodeObat = connect.rs.getString("KODE_OBAT");
	            Integer jumlahObat = connect.rs.getInt("JUMLAH_OBAT");
	            Integer produksiTelur = connect.rs.getInt("PRODUKSI_TELUR");
	            Integer biayaVariabel = connect.rs.getInt("BIAYA_VARIABEL");
	            String komentarKematian = connect.rs.getString("KOMENTAR_KEMATIAN");
	            Integer penjualanJantan = connect.rs.getInt("PENJUALAN_JANTAN");
	            Integer afkirJantan = connect.rs.getInt("AFKIR_JANTAN");
	            Integer pindahJantan = connect.rs.getInt("PINDAH_JANTAN");
	            Integer penjualanBetina = connect.rs.getInt("PENJUALAN_BETINA");
	            Integer afkirBetina = connect.rs.getInt("AFKIR_BETINA");
	            Integer pindahBetina = connect.rs.getInt("PINDAH_BETINA");

	            // Buat objek CatatanHarianDetail dengan data yang diperoleh
	            catatanDetail = new CatatanHarianDetail(
	                kodeCatatan,
	                tanggalCatatan,
	                kematianJantan,
	                kematianBetina,
	                kodePakan,
	                jumlahPakan.toString(),
	                kodeObat,
	                jumlahObat.toString(),
	                produksiTelur.toString(),
	                biayaVariabel.toString(),
	                komentarKematian,
	                penjualanJantan,
	                afkirJantan,
	                pindahJantan,
	                penjualanBetina,
	                afkirBetina,
	                pindahBetina
	            );
	        }
	    } catch (SQLException e) {
	        // Tangani kesalahan SQL
	        System.err.println("Error fetching data for KODE_CATATAN: " + KODE_CATATAN + " and TANGGAL_CATATAN: " + TANGGAL_CATATAN);
	        e.printStackTrace();
	    } finally {
	        // Pastikan ResultSet ditutup untuk menghindari kebocoran sumber daya
	        try {
	            if (connect.rs != null) {
	                connect.rs.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return catatanDetail;
	}
	//=================================
	
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
	
	  public static ObservableList<String> getKodeKandangData() {
	        ObservableList<String> dataList = FXCollections.observableArrayList();
	        Connect connect = Connect.getInstance();

	        String query = "SELECT KODE_KANDANG FROM mskandang"; // Query to fetch KODE_KANDANG from mskandang

	        try {
	            ResultSet resultSet = connect.execQuery(query);
	            while (resultSet.next()) {
	                String kodeKandang = resultSet.getString("KODE_KANDANG");
	                dataList.add(kodeKandang);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return dataList;
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
				String KodeSupplier = connect.rs.getString("KODE_SUPPLIER"); 
				
				obat_list.add(new DaftarObat(KodeObat, 
						NamaObat, 
						JenisObat, 
						Dosis, 
						Satuan, 
						Penyakit, 
						JumlahPerPack, 
						HargaPerPack, 
						HargaPerSatuan, 
						KodeSupplier));
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obat_list;	
	} 
	
	public void insertMasterObat(DaftarObat daftarobat) {
	    String query = String.format("INSERT INTO msobat VALUES ('%s', '%s', '%s', '%d', '%s', '%s', '%d', '%d', '%d', '%s')",
	            daftarobat.getKodeObat(), 
	            daftarobat.getNamaObat(), 
	            daftarobat.getJenisObat(), 
	            daftarobat.getDosis(), 
	            daftarobat.getSatuan(), 
	            daftarobat.getPenyakit(), 
	            daftarobat.getJumlahPerPack(), 
	            daftarobat.getHargaPerPack(), 
	            daftarobat.getHargaPerSatuan(), 
	            daftarobat.getKodeSupplier());
		connect.execUpdate(query);	
		reusableMethod.showAlert(AlertType.INFORMATION, "Master Obat", "New Data Obat Added Succesfully!");
	}
	
	public void updateMasterObat(DaftarObat Obat) {
		
		String query = String.format("UPDATE msobat "
                + "SET KODE_OBAT = '%s', NAMA_OBAT = '%s', "
                + "JENIS_OBAT = '%s', DOSIS = %d, "
                + "SATUAN = '%s', PENYAKIT = '%s', "
                + "JUMLAH_PER_PACK = %d, HARGA_PER_PACK = %d, "  
                + "HARGA_PER_SATUAN = %d, KODE_SUPPLIER = '%s' "
                + "WHERE KODE_OBAT = '%s'",
                Obat.getKodeObat(), Obat.getNamaObat(), Obat.getJenisObat(), 
                Obat.getDosis(), Obat.getSatuan(), Obat.getPenyakit(), 
                Obat.getJumlahPerPack(), Obat.getHargaPerPack(), 
                Obat.getHargaPerSatuan(), Obat.getKodeSupplier(), Obat.getKodeObat()
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

	public ObservableList<DaftarObat> searchMasterObatData(String keyword, Integer keywordN) {
	    ObservableList<DaftarObat> searchResults = FXCollections.observableArrayList();

	    // Assuming you have a method to get the complete list of kandang data
	    ObservableList<DaftarObat> allobat = getObatData();

	    for (DaftarObat obat : allobat) {
	    	if (keyword != null && !keyword.isEmpty()) {
	            if (obat.getKodeObat().toLowerCase().contains(keyword.toLowerCase()) ||
	                obat.getNamaObat().toLowerCase().contains(keyword.toLowerCase()) ||  
	                obat.getJenisObat().toLowerCase().contains(keyword.toLowerCase()) || 
	                obat.getSatuan().toLowerCase().contains(keyword.toLowerCase()) || 
	                obat.getPenyakit().toLowerCase().contains(keyword.toLowerCase()) || 
	                obat.getKodeSupplier().toLowerCase().contains(keyword.toLowerCase()) ) {
	                searchResults.add(obat);
	                continue; // Skip integer checks if already matched
	            }
	        }

	        // Check integer fields
	        if (keywordN != null) {
	            if (obat.getDosis() == keywordN || 
	                obat.getJumlahPerPack() == keywordN || 
	                obat.getHargaPerPack() == keywordN || 
	                obat.getHargaPerSatuan() == keywordN) {
	                searchResults.add(obat);
	            }
	        }
	    }

	    return searchResults; 
	}
	
	public static ObservableList<String> getKodeSupplierData() {
        ObservableList<String> dataList = FXCollections.observableArrayList();
        Connect connect = Connect.getInstance();

        String query = "SELECT KODE_SUPPLIER FROM mssupplier"; // Query to fetch KODE_SUPPLIER from msobat

        try {
            ResultSet resultSet = connect.execQuery(query);
            while (resultSet.next()) {
                String kodeSupplier = resultSet.getString("KODE_SUPPLIER");
                dataList.add(kodeSupplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataList;
    }

	
	//===================================================================================================== 
	//===================================================================================================== 
	//===================================================================================================== 
	//===================================================================================================== 


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
				String KODE_SUPPLIER = connect.rs.getString("KODE_SUPPLIER");
				
				lists.add(new DaftarPakan(KODE_PAKAN, NAMA_PAKAN, JENIS_PAKAN, HARGA, KODE_SUPPLIER));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lists;
	}
	
	public void insertMasterPakan(DaftarPakan pakan) {
		String query = String.format("INSERT INTO MsPakan VALUES ("
				+ " '%s', '%s', '%s', %d, '%s'"
				+ ")", pakan.getKodePakan(),
				pakan.getNamaPakan(),
				pakan.getJenisPakan(),
				pakan.getHarga(), 
				pakan.getKodeSupplier());
		
		connect.execUpdate(query);
		reusableMethod.showAlert(AlertType.INFORMATION, "Data", "Data Added!");
	}
	
	public void updateMasterPakan(DaftarPakan pakan) {
		
		String query = String.format("UPDATE mspakan "
				+ "SET KODE_PAKAN = '%s', NAMA_PAKAN = '%s', "
				+ "JENIS_PAKAN = '%s', HARGA = %d, KODE_SUPPLIER = '%s'"
				+ "WHERE KODE_PAKAN = '%s'", pakan.getKodePakan(), 
				pakan.getNamaPakan(), pakan.getJenisPakan(),
				pakan.getHarga(), pakan.getKodeSupplier(), pakan.getKodePakan());
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
	//=====search====
	public ObservableList<DaftarPakan> searchMasterPakanData(String keyword) {
	    ObservableList<DaftarPakan> searchResults = FXCollections.observableArrayList();

	    // Assuming you have a method to get the complete list of kandang data
	    ObservableList<DaftarPakan> allpakan = getMasterPakanData();

	    for (DaftarPakan pakan : allpakan) {
	        if (pakan.getKodePakan().toLowerCase().contains(keyword.toLowerCase()) ||
	            pakan.getNamaPakan().toLowerCase().contains(keyword.toLowerCase()) ||  
	            pakan.getJenisPakan().toLowerCase().contains(keyword.toLowerCase()) || 
	            pakan.getKodeSupplier().toLowerCase().contains(keyword.toLowerCase())) {
	            searchResults.add(pakan);
	        }
	    }

	    return searchResults;
	}
	//==================
//===================================================================================================== 
//Bagian Kandang 
	
	public String getNewkodeKandang() {
		String query = "SELECT KODE_KANDANG from mskandang "
				+ "ORDER BY KODE_KANDANG DESC LIMIT 1";
		
		String lastKode = "";
		connect.rs = connect.execQuery(query);
		try {
			if(!(connect.rs.next())) {
				return "KK001";
			}
			
			lastKode = connect.rs.getString("KODE_KANDANG");
			String num = lastKode.substring(3);
			Integer incr = Integer.parseInt(num) + 1;
			
			lastKode = String.format("KK%03d", incr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastKode;
	}

	
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
	//=====Test Search=====
	public ObservableList<MsKandang> searchMasterKandangData(String keyword) {
	    ObservableList<MsKandang> searchResults = FXCollections.observableArrayList();

	    // Assuming you have a method to get the complete list of kandang data
	    ObservableList<MsKandang> allKandang = getMasterKandangData();

	    for (MsKandang kandang : allKandang) {
	        if (kandang.getKodeKandang().toLowerCase().contains(keyword.toLowerCase()) ||
	            kandang.getLokasi().toLowerCase().contains(keyword.toLowerCase())) {
	            searchResults.add(kandang);
	        }
	    }

	    return searchResults;
	}
	//=====Search=====
	
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

	public ObservableList<DaftarSupplier> searchMasterSupplierData(String keyword) {
	    ObservableList<DaftarSupplier> searchResults = FXCollections.observableArrayList();
	    String query = String.format(
	        "SELECT * FROM mssupplier WHERE KODE_SUPPLIER LIKE '%%%s%%' OR NAMA_SUPPLIER LIKE '%%%s%%'", 
	        keyword, keyword
	    );

	    connect.rs = connect.execQuery(query);

	    try {
	        while (connect.rs.next()) {
	            String KodeSupplier = connect.rs.getString("KODE_SUPPLIER");
	            String NamaSupplier = connect.rs.getString("NAMA_SUPPLIER");

	            searchResults.add(new DaftarSupplier(KodeSupplier, NamaSupplier));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return searchResults;
	}
	
	
//========================================================================================	
//Catatan Harian Detail
	public Integer calculateAge(Date Date) {//untuk kalkulasi umur
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
	
	public Integer calculateWeeks(Date Date) {//untuk kalkulasi week atau minggu
		LocalDate currDate = LocalDate.now();
		LocalDate startDate = Date.toLocalDate();
		
	    long daysDifference = currDate.toEpochDay() - startDate.toEpochDay();

	    int weeks = (int) (daysDifference / 7);

	    return weeks;
	}
	
	public Integer getJumlahJantan(String KODE_CATATAN) {//untuk kalkulasi sisa jantan
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
	
	public Integer getJumlahBetina(String KODE_CATATAN) {// untuk kalkulasi jumlah betina
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
	
	public static ObservableList<String> getKodePakanData(){
		ObservableList<String> dataList = FXCollections.observableArrayList();
        Connect connect = Connect.getInstance();

        String query = "SELECT KODE_PAKAN FROM mspakan"; // Query to fetch KODE_KANDANG from mskandang

        try {
            ResultSet resultSet = connect.execQuery(query);
            while (resultSet.next()) {
                String KodePakan = resultSet.getString("KODE_PAKAN");
                dataList.add(KodePakan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataList;
	} 
	
	public static ObservableList<String> getKodeObatData(){
		ObservableList<String> dataList = FXCollections.observableArrayList();
        Connect connect = Connect.getInstance();

        String query = "SELECT KODE_OBAT FROM msobat"; // Query to fetch KODE_KANDANG from mskandang

        try {
            ResultSet resultSet = connect.execQuery(query);
            while (resultSet.next()) {
                String KodeObat = resultSet.getString("KODE_OBAT");
                dataList.add(KodeObat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
	} 
	
	public ObservableList<CatatanHarianDetail> getSpecificCatatanHarianDetail(String KodeCatatan) {
		String query = 
				String.format("SELECT * FROM viewcatatanhariandetail WHERE KODE_CATATAN = '%s'", 
						KodeCatatan);
		
		connect.rs = connect.execQuery(query);
		ObservableList<CatatanHarianDetail> lists = FXCollections.observableArrayList();
		
		try {
			while(connect.rs.next()) {
				
				String KODE_CATATAN = connect.rs.getString("KODE_CATATAN");
				Date TANGGAL_CATATAN = connect.rs.getDate("TANGGAL_CATATAN"); 
				String UMUR = connect.rs.getString("UMUR");
				Integer MINGGU = connect.rs.getInt("MINGGU");
				Integer KEMATIAN_JANTAN = connect.rs.getInt("KEMATIAN_JANTAN"); 
				Integer SISA_JANTAN = connect.rs.getInt("SISA_JANTAN"); 
				Integer KEMATIAN_BETINA = connect.rs.getInt("KEMATIAN_BETINA");
				Integer SISA_BETINA = connect.rs.getInt("SISA_BETINA");
				Integer TOTAL_SISA = connect.rs.getInt("TOTAL_SISA");
				String PERBANDINGAN = connect.rs.getString("PERBANDINGAN_JANTAN_BETINA");
				String KODE_PAKAN = connect.rs.getString("KODE_PAKAN");
				String JUMLAH_PAKAN = connect.rs.getString("JUMLAH_PAKAN");
				String PAKAN_PER_EKOR = connect.rs.getString("PAKAN_PER_EKOR");
				String KODE_OBAT = connect.rs.getString("KODE_OBAT");
				String JUMLAH_OBAT = connect.rs.getString("JUMLAH_OBAT");
				String PRODUKSI_TELUR = connect.rs.getString("PRODUKSI_TELUR");
				String PERSENTASE_PRODUKSI = connect.rs.getString("PERSENTASE_PRODUKSI");
				String BIAYA_VARIABEL = connect.rs.getString("BIAYA_VARIABEL");
				String KOMENTAR_KEMATIAN = connect.rs.getString("KOMENTAR_KEMATIAN");
				Integer PENJUALAN_JANTAN = connect.rs.getInt("PENJUALAN_JANTAN"); 
				Integer AFKIR_JANTAN = connect.rs.getInt("AFKIR_JANTAN"); 
				Integer PINDAH_JANTAN = connect.rs.getInt("PINDAH_JANTAN");
				Integer PENJUALAN_BETINA = connect.rs.getInt("PENJUALAN_BETINA"); 
				Integer AFKIR_BETINA = connect.rs.getInt("AFKIR_BETINA"); 
				Integer PINDAH_BETINA = connect.rs.getInt("PINDAH_BETINA");
				//Perbandingan Jantan dan Betina
				 String[] perbandingan = PERBANDINGAN.split(":");
					
				 double PerbandinganJantan = 0.0;
		         double PerbandinganBetina = 0.0;
				
				 PerbandinganJantan = Double.parseDouble(perbandingan[0]);
                 PerbandinganBetina = Double.parseDouble(perbandingan[1]);

                 // Ensure PerbandinganBetina has 2 decimal places
                 PerbandinganBetina = Math.round(PerbandinganBetina * 100.0) / 100.0;
				//====================================================================
				
				lists.add(
							new CatatanHarianDetail(
									KODE_CATATAN,
									TANGGAL_CATATAN,
									UMUR,
									MINGGU,
									KEMATIAN_JANTAN, 
									SISA_JANTAN,
									KEMATIAN_BETINA, 
									SISA_BETINA,
									TOTAL_SISA,
									PerbandinganJantan,
									PerbandinganBetina,
									KODE_PAKAN,
									JUMLAH_PAKAN,
									PAKAN_PER_EKOR,
									KODE_OBAT,
									JUMLAH_OBAT,
									PRODUKSI_TELUR,
									PERSENTASE_PRODUKSI,
									BIAYA_VARIABEL,
									KOMENTAR_KEMATIAN, 
									PENJUALAN_JANTAN, 
									AFKIR_JANTAN, 
									PINDAH_JANTAN, 
									PENJUALAN_BETINA, 
									AFKIR_BETINA, 
									PINDAH_BETINA
									)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lists;
	} 
	
	public void insertCatatanHarianDetail(CatatanHarianDetail catatanhariandetail) {
	    String query = String.format("INSERT INTO catatanhariandetail VALUES ("
	    		+ " '%s', '%s', %d, %d, '%s', %d, '%s', %d, %d, %d, '%s', %d, %d, %d, %d, %d, %d)",
	    		catatanhariandetail.getKodeCatatan(),
	    		catatanhariandetail.getTanggalCatatan().toString(),
	    		catatanhariandetail.getKematianJantan(),
	    		catatanhariandetail.getKematianBetina(), 
	    		catatanhariandetail.getKodePakan(),
	    		Integer.parseInt(catatanhariandetail.getJumlahPakan()),
	    		catatanhariandetail.getKodeObat(),
	    		Integer.parseInt(catatanhariandetail.getJumlahObat()),
	    		Integer.parseInt(catatanhariandetail.getProduksiTelur()),
	    		Integer.parseInt(catatanhariandetail.getBiayaVariabel()),
	    		catatanhariandetail.getKomentarKematian(), 
	    		catatanhariandetail.getPenjualanJantan(), 
	    		catatanhariandetail.getAfkirJantan(), 
	    		catatanhariandetail.getPindahJantan(), 
	    		catatanhariandetail.getPenjualanBetina(), 
	    		catatanhariandetail.getAfkirBetina(), 
	    		catatanhariandetail.getPindahBetina()
	    		);
		connect.execUpdate(query);	
		reusableMethod.showAlert(AlertType.INFORMATION, "Catatan Harian Detail", "New Data Detail Added Succesfully!");
	}
	
	public void updateCatatanHarianDetail(CatatanHarianDetail CHD) { 
		String query = String.format("UPDATE catatanhariandetail" 
				+ " SET KEMATIAN_JANTAN = %d, PENJUALAN_JANTAN = %d," 
				+ " AFKIR_JANTAN = %d, PINDAH_JANTAN = %d, " 
				+ " KEMATIAN_BETINA = %d, PENJUALAN_BETINA = %d,"  
				+ " AFKIR_BETINA = %d, PINDAH_BETINA = %d, "
				+ " KODE_PAKAN = '%s', JUMLAH_PAKAN = %d," 
				+ " KODE_OBAT = '%s', JUMLAH_OBAT =%d," 
				+ " PRODUKSI_TELUR = %d, BIAYA_VARIABEL = %d," 
				+ " KOMENTAR_KEMATIAN = '%s' WHERE KODE_CATATAN = '%s' AND TANGGAL_CATATAN = '%s'"
				,  CHD.getKematianJantan(), CHD.getPenjualanJantan(), 
				CHD.getAfkirJantan(), CHD.getPindahJantan(),
				CHD.getKematianBetina(), CHD.getPenjualanBetina(), 
				CHD.getAfkirBetina(), CHD.getPindahBetina(),
				CHD.getKodePakan(), 
				Integer.parseInt(CHD.getJumlahPakan()), 
				CHD.getKodeObat(), 
				Integer.parseInt(CHD.getJumlahObat()), 
				Integer.parseInt(CHD.getProduksiTelur()), 
				Integer.parseInt(CHD.getBiayaVariabel()), 
				CHD.getKomentarKematian(), CHD.getKodeCatatan(), CHD.getTanggalCatatan().toString()); 
				
		connect.execUpdate(query);
	}
	
	public void deleteCatatanHarianDetail(CatatanHarianDetail catatan) {
		String query = String.format("DELETE FROM catatanhariandetail "
				+ "WHERE KODE_CATATAN = '%s' AND TANGGAL_CATATAN = '%s'", 
				catatan.getKodeCatatan(), catatan.getTanggalCatatan());
		
		connect.execUpdate(query);
	}
	
	public void refreshTableCatatanHarianDetail(TableView<CatatanHarianDetail> table, String KodeCatatan) {
		ObservableList<CatatanHarianDetail> items = getSpecificCatatanHarianDetail(KodeCatatan); 
		table.setItems(items); 
	}
	
	public void ValidateDate(CatatanHarianDetail catatanhariandetail) { 
		 if (catatanhariandetail.getTanggalCatatan() == null) {
		        catatanhariandetail.setTanggalCatatan(LocalDate.now()); // Set to current date if null
		    } 
		 insertCatatanHarianDetail(catatanhariandetail);
	}
	
	public ObservableList<CatatanHarianDetail> searchCatatanHarianDetailAllColumns(String KodeCatatan, String keyword) {
	    // Get all data for the specified KodeCatatan
	    ObservableList<CatatanHarianDetail> allDetails = getSpecificCatatanHarianDetail(KodeCatatan);
	    ObservableList<CatatanHarianDetail> searchResults = FXCollections.observableArrayList();

	    // If the keyword is null or empty, return the full list
	    if (keyword == null || keyword.trim().isEmpty()) {
	        return allDetails;
	    }

	    String searchKey = keyword.toLowerCase();

	    // Iterate through all details and search across all columns
	    for (CatatanHarianDetail detail : allDetails) {
	        if (detail.getKodeCatatan().toLowerCase().contains(searchKey) ||
	            detail.getTanggalCatatan().toString().toLowerCase().contains(searchKey) || // Date to String
	            detail.getUmur().toLowerCase().contains(searchKey) ||
	            detail.getMinggu().toString().toLowerCase().contains(searchKey) ||
	            detail.getKematianJantan().toString().toLowerCase().contains(searchKey) || 
	            detail.getPenjualanJantan().toString().toLowerCase().contains(searchKey) || 
	            detail.getAfkirJantan().toString().toLowerCase().contains(searchKey) || 
	            detail.getPindahJantan().toString().toLowerCase().contains(searchKey) || 
	            detail.getSisaJantan().toString().toLowerCase().contains(searchKey) ||
	            detail.getKematianBetina().toString().toLowerCase().contains(searchKey) ||
	            detail.getAfkirBetina().toString().toLowerCase().contains(searchKey) || 
	            detail.getPindahBetina().toString().toLowerCase().contains(searchKey) ||
	            detail.getSisaBetina().toString().toLowerCase().contains(searchKey) ||
	            detail.getTotalSisa().toString().toLowerCase().contains(searchKey) ||
	            detail.getPerbandinganJantan().toString().toLowerCase().contains(searchKey) ||
	            detail.getPerbandinganBetina().toString().toLowerCase().contains(searchKey) ||
	            detail.getKodePakan().toLowerCase().contains(searchKey) ||
	            detail.getJumlahPakan().toLowerCase().contains(searchKey) ||
	            detail.getPakanPerEkor().toLowerCase().contains(searchKey) ||
	            detail.getKodeObat().toLowerCase().contains(searchKey) ||
	            detail.getJumlahObat().toLowerCase().contains(searchKey) ||
	            detail.getProduksiTelur().toLowerCase().contains(searchKey) ||
	            detail.getPersentaseProduksi().toLowerCase().contains(searchKey) ||
	            detail.getBiayaVariabel().toLowerCase().contains(searchKey) ||
	            detail.getKomentarKematian().toLowerCase().contains(searchKey)) {
	            // Add to results if any field matches the keyword
	            searchResults.add(detail);
	        }
	    }

	    return searchResults;
	}
} 
