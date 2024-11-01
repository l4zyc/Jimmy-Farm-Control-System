package model;

import java.sql.*;

public class CatatanHarianUtama {
	public CatatanHarianUtama(String kodeKandang, String lokasi, Date tanggalMasuk, String keteranganJenis,
			Integer jumlahAwalJantan, Integer jumlahAwalBetina, String komentar) {
		super();
		Lokasi = lokasi;
		KodeKandang = kodeKandang;
		TanggalMasuk = tanggalMasuk;
		KeteranganJenis = keteranganJenis;
		JumlahAwalJantan = jumlahAwalJantan;
		JumlahAwalBetina = jumlahAwalBetina;
		Komentar = komentar;
	}
	public String getLokasi() {
		return Lokasi;
	}
	public void setLokasi(String lokasi) {
		Lokasi = lokasi;
	}
	public String getKodeKandang() {
		return KodeKandang;
	}
	public void setKodeKandang(String kodeKandang) {
		KodeKandang = kodeKandang;
	}
	public Date getTanggalMasuk() {
		return TanggalMasuk;
	}
	public void setTanggalMasuk(Date tanggalMasuk) {
		TanggalMasuk = tanggalMasuk;
	}
	public String getKeteranganJenis() {
		return KeteranganJenis;
	}
	public void setKeteranganJenis(String keteranganJenis) {
		KeteranganJenis = keteranganJenis;
	}
	public Integer getJumlahAwalJantan() {
		return JumlahAwalJantan;
	}
	public void setJumlahAwalJantan(Integer jumlahAwalJantan) {
		JumlahAwalJantan = jumlahAwalJantan;
	}
	public Integer getJumlahAwalBetina() {
		return JumlahAwalBetina;
	}
	public void setJumlahAwalBetina(Integer jumlahAwalBetina) {
		JumlahAwalBetina = jumlahAwalBetina;
	}
	public String getKomentar() {
		return Komentar;
	}
	public void setKomentar(String komentar) {
		Komentar = komentar;
	}
	private String Lokasi; 
	private String KodeKandang; 
	private Date TanggalMasuk; 
	private String KeteranganJenis; 
	private Integer JumlahAwalJantan; 
	private Integer JumlahAwalBetina; 
	private String Komentar;
}
