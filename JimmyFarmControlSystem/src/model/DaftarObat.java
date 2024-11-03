package model;

import java.sql.*;

public class DaftarObat{

	private String KodeObat; 
	private String NamaObat; 
	private String JenisObat; 
	private Integer Dosis; 
	private String Satuan; 
	private String Penyakit; 
	private Integer JumlahPerPack; 
	private Integer HargaPerPack;  
	private Integer HargaPerSatuan;
	
	public DaftarObat(String kodeObat, String namaObat, String jenisObat, Integer dosis, String satuan, String penyakit,
			Integer jumlahPerPack, Integer hargaPerPack, Integer hargaPerSatuan) {
		KodeObat = kodeObat;
		NamaObat = namaObat;
		JenisObat = jenisObat;
		Dosis = dosis;
		Satuan = satuan;
		Penyakit = penyakit;
		JumlahPerPack = jumlahPerPack;
		HargaPerPack = hargaPerPack;
		HargaPerSatuan = hargaPerSatuan;
	}

	public String getKodeObat() {
		return KodeObat;
	}

	public String getNamaObat() {
		return NamaObat;
	}

	public String getJenisObat() {
		return JenisObat;
	}

	public Integer getDosis() {
		return Dosis;
	}

	public String getSatuan() {
		return Satuan;
	}

	public String getPenyakit() {
		return Penyakit;
	}

	public Integer getJumlahPerPack() {
		return JumlahPerPack;
	}

	public Integer getHargaPerPack() {
		return HargaPerPack;
	}

	public Integer getHargaPerSatuan() {
		return HargaPerSatuan;
	}

	public void setKodeObat(String kodeObat) {
		KodeObat = kodeObat;
	}

	public void setNamaObat(String namaObat) {
		NamaObat = namaObat;
	}

	public void setJenisObat(String jenisObat) {
		JenisObat = jenisObat;
	}

	public void setDosis(Integer dosis) {
		Dosis = dosis;
	}

	public void setSatuan(String satuan) {
		Satuan = satuan;
	}

	public void setPenyakit(String penyakit) {
		Penyakit = penyakit;
	}

	public void setJumlahPerPack(Integer jumlahPerPack) {
		JumlahPerPack = jumlahPerPack;
	}

	public void setHargaPerPack(Integer hargaPerPack) {
		HargaPerPack = hargaPerPack;
	}

	public void setHargaPerSatuan(Integer hargaPerSatuan) {
		HargaPerSatuan = hargaPerSatuan;
	}
	
	
	
}
