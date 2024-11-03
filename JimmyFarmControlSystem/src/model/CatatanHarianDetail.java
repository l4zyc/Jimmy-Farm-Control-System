package model;

import java.sql.*;

public class CatatanHarianDetail {

	private String KodeCatatan; 
	private Date TanggalCatatan; 
	private Integer KematianJantan; 
	private Integer KematianBetina; 
	private String KodePakan; 
	private Integer JumlahPakan; 
	private String KodeObat;
	private Integer JumlahObat; 
	private Integer ProduksiTelur; 
	private Integer BiayaVariabel; 
	private String KomentarKematian;
	
	public CatatanHarianDetail(String kodeCatatan, Date tanggalCatatan, Integer kematianJantan, Integer kematianBetina,
			String kodePakan, Integer jumlahPakan, String kodeObat, Integer jumlahObat, Integer produksiTelur,
			Integer biayaVariabel, String komentarKematian) {
		KodeCatatan = kodeCatatan;
		TanggalCatatan = tanggalCatatan;
		KematianJantan = kematianJantan;
		KematianBetina = kematianBetina;
		KodePakan = kodePakan;
		JumlahPakan = jumlahPakan;
		KodeObat = kodeObat;
		JumlahObat = jumlahObat;
		ProduksiTelur = produksiTelur;
		BiayaVariabel = biayaVariabel;
		KomentarKematian = komentarKematian;
	}

	public String getKodeCatatan() {
		return KodeCatatan;
	}

	public Date getTanggalCatatan() {
		return TanggalCatatan;
	}

	public Integer getKematianJantan() {
		return KematianJantan;
	}

	public Integer getKematianBetina() {
		return KematianBetina;
	}

	public String getKodePakan() {
		return KodePakan;
	}

	public Integer getJumlahPakan() {
		return JumlahPakan;
	}

	public String getKodeObat() {
		return KodeObat;
	}

	public Integer getJumlahObat() {
		return JumlahObat;
	}

	public Integer getProduksiTelur() {
		return ProduksiTelur;
	}

	public Integer getBiayaVariabel() {
		return BiayaVariabel;
	}

	public String getKomentarKematian() {
		return KomentarKematian;
	}

	public void setKodeCatatan(String kodeCatatan) {
		KodeCatatan = kodeCatatan;
	}

	public void setTanggalCatatan(Date tanggalCatatan) {
		TanggalCatatan = tanggalCatatan;
	}

	public void setKematianJantan(Integer kematianJantan) {
		KematianJantan = kematianJantan;
	}

	public void setKematianBetina(Integer kematianBetina) {
		KematianBetina = kematianBetina;
	}

	public void setKodePakan(String kodePakan) {
		KodePakan = kodePakan;
	}

	public void setJumlahPakan(Integer jumlahPakan) {
		JumlahPakan = jumlahPakan;
	}

	public void setKodeObat(String kodeObat) {
		KodeObat = kodeObat;
	}

	public void setJumlahObat(Integer jumlahObat) {
		JumlahObat = jumlahObat;
	}

	public void setProduksiTelur(Integer produksiTelur) {
		ProduksiTelur = produksiTelur;
	}

	public void setBiayaVariabel(Integer biayaVariabel) {
		BiayaVariabel = biayaVariabel;
	}

	public void setKomentarKematian(String komentarKematian) {
		KomentarKematian = komentarKematian;
	}
	
	
	
}
