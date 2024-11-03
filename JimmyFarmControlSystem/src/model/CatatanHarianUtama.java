package model;

import java.sql.*;

public class CatatanHarianUtama {
	private String KodeCatatan; 
	private Date TanggalMasuk;  
	private String KodeKandang;
	private String KeteranganJenis; 
	private Integer JumlahAwalJantan; 
	private Integer JumlahAwalBetina; 
	private String Komentar;
	
	public CatatanHarianUtama(String kodeCatatan, Date tanggalMasuk, String kodeKandang, String keteranganJenis,
			Integer jumlahAwalJantan, Integer jumlahAwalBetina, String komentar) {
	
		KodeCatatan = kodeCatatan;
		TanggalMasuk = tanggalMasuk;
		KodeKandang = kodeKandang;
		KeteranganJenis = keteranganJenis;
		JumlahAwalJantan = jumlahAwalJantan;
		JumlahAwalBetina = jumlahAwalBetina;
		Komentar = komentar;
	}

	public String getKodeCatatan() {
		return KodeCatatan;
	}

	public Date getTanggalMasuk() {
		return TanggalMasuk;
	}

	public String getKodeKandang() {
		return KodeKandang;
	}

	public String getKeteranganJenis() {
		return KeteranganJenis;
	}

	public Integer getJumlahAwalJantan() {
		return JumlahAwalJantan;
	}

	public Integer getJumlahAwalBetina() {
		return JumlahAwalBetina;
	}

	public String getKomentar() {
		return Komentar;
	}

	public void setKodeCatatan(String kodeCatatan) {
		KodeCatatan = kodeCatatan;
	}

	public void setTanggalMasuk(Date tanggalMasuk) {
		TanggalMasuk = tanggalMasuk;
	}

	public void setKodeKandang(String kodeKandang) {
		KodeKandang = kodeKandang;
	}

	public void setKeteranganJenis(String keteranganJenis) {
		KeteranganJenis = keteranganJenis;
	}

	public void setJumlahAwalJantan(Integer jumlahAwalJantan) {
		JumlahAwalJantan = jumlahAwalJantan;
	}

	public void setJumlahAwalBetina(Integer jumlahAwalBetina) {
		JumlahAwalBetina = jumlahAwalBetina;
	}

	public void setKomentar(String komentar) {
		Komentar = komentar;
	}
}
