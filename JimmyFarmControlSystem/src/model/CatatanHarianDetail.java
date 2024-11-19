package model;

import java.sql.*;
import java.time.LocalDate;

public class CatatanHarianDetail {

	private String KodeCatatan; 
	private Date TanggalCatatan;
	private String Umur;
	private Integer Minggu;
	//============
	private Integer KematianJantan;  
	private Integer SisaJantan; 
	//============
	private Integer KematianBetina;  
	private Integer SisaBetina; 
	//============
	private Integer TotalSisa;
	private Double perbandinganJantan;
	private Double perbandinganBetina;
	private String KodePakan; 
	private String JumlahPakan; 
	private String PakanPerEkor;
	private String KodeObat;
	private String JumlahObat; 
	private String ProduksiTelur; 
	private String PersentaseProduksi;
	private String BiayaVariabel; 
	private String KomentarKematian;  
	//============
	private Integer PenjualanJantan; 
	private Integer AfkirJantan; 
	private Integer PindahJantan;
	//============ 
	private Integer PenjualanBetina; 
	private Integer AfkirBetina; 
	private Integer PindahBetina;
	//============
	public CatatanHarianDetail( String kodeCatatan, Date tanggalCatatan, String umur, Integer minggu,
			Integer kematianJantan, Integer sisaJantan, 
			Integer kematianBetina, Integer sisaBetina, Integer totalSisa,
			Double perbandinganJantan, Double perbandinganBetina, String kodePakan, String jumlahPakan,
			String pakanPerEkor, String kodeObat, String jumlahObat, String produksiTelur, String persentaseProduksi,
			String biayaVariabel, String komentarKematian, 
			Integer penjualanJantan, Integer afkirJantan, Integer pindahJantan, 
			Integer penjualanBetina, Integer afkirBetina, Integer pindahBetina ) {
		super();
		KodeCatatan = kodeCatatan;
		TanggalCatatan = tanggalCatatan;
		Umur = umur;
		Minggu = minggu;
		//=======
		KematianJantan = kematianJantan; 
		SisaJantan = sisaJantan; 
		//=======
		KematianBetina = kematianBetina; 
		SisaBetina = sisaBetina; 
		//=======
		TotalSisa = totalSisa;
		this.perbandinganJantan = perbandinganJantan;
		this.perbandinganBetina = perbandinganBetina;
		KodePakan = kodePakan;
		JumlahPakan = jumlahPakan;
		PakanPerEkor = pakanPerEkor;
		KodeObat = kodeObat;
		JumlahObat = jumlahObat;
		ProduksiTelur = produksiTelur;
		PersentaseProduksi = persentaseProduksi;
		BiayaVariabel = biayaVariabel;
		KomentarKematian = komentarKematian; 
		PenjualanJantan = penjualanJantan; 
		AfkirJantan = afkirJantan; 
		PindahJantan = pindahJantan; 
		PenjualanBetina = penjualanBetina; 
		AfkirBetina = afkirBetina; 
		PindahBetina = pindahBetina;
	} 
	//====================================


	public CatatanHarianDetail(String kodeCatatan, 
            Date tanggalCatatan, 
            Integer kematianJantan, 
            Integer kematianBetina, 
            String kodePakan, 
            String jumlahPakan, 
            String kodeObat, 
            String jumlahObat, 
            String produksiTelur, 
            String biayaVariabel, 
            String komentarKematian, 
            Integer penjualanJantan, 
            Integer afkirJantan, 
            Integer pindahJantan,
            Integer penjualanBetina, 
            Integer afkirBetina, 
            Integer pindahBetina) {
			this.KodeCatatan = kodeCatatan;
			this.TanggalCatatan = tanggalCatatan;
			this.KematianJantan = kematianJantan; 
			this.PenjualanJantan = penjualanJantan; 
			this.AfkirJantan = afkirJantan; 
			this.PindahJantan = pindahJantan;
			this.KematianBetina = kematianBetina; 
			this.PenjualanBetina = penjualanBetina; 
			this.AfkirBetina = afkirBetina; 
			this.PindahBetina = pindahBetina;
			this.KodePakan = kodePakan;
			this.JumlahPakan = jumlahPakan;
			this.KodeObat = kodeObat;
			this.JumlahObat = jumlahObat;
			this.ProduksiTelur = produksiTelur;
			this.BiayaVariabel = biayaVariabel;
			this.KomentarKematian = komentarKematian;
		}


	public String getKodeCatatan() {
		return KodeCatatan;
	}
	public void setKodeCatatan(String kodeCatatan) {
		KodeCatatan = kodeCatatan;
	}
	public Date getTanggalCatatan() {
		return TanggalCatatan;
	}
	public void setTanggalCatatan(Date tanggalCatatan) {
		TanggalCatatan = tanggalCatatan;
	}
	public String getUmur() {
		return Umur;
	}
	public void setUmur(String umur) {
		Umur = umur;
	}
	public Integer getMinggu() {
		return Minggu;
	}
	public void setMinggu(Integer minggu) {
		Minggu = minggu;
	}
	public Integer getKematianJantan() {
		return KematianJantan;
	}
	public void setKematianJantan(Integer kematianJantan) {
		KematianJantan = kematianJantan;
	}
	public Integer getSisaJantan() {
		return SisaJantan;
	}
	public void setSisaJantan(Integer sisaJantan) {
		SisaJantan = sisaJantan;
	}
	public Integer getKematianBetina() {
		return KematianBetina;
	}
	public void setKematianBetina(Integer kematianBetina) {
		KematianBetina = kematianBetina;
	}
	public Integer getSisaBetina() {
		return SisaBetina;
	}
	public void setSisaBetina(Integer sisaBetina) {
		SisaBetina = sisaBetina;
	}
	public Integer getTotalSisa() {
		return TotalSisa;
	}
	public void setTotalSisa(Integer totalSisa) {
		TotalSisa = totalSisa;
	}
	public Double getPerbandinganJantan() {
		return perbandinganJantan;
	}
	public void setPerbandinganJantan(Double perbandinganJantan) {
		this.perbandinganJantan = perbandinganJantan;
	}
	public Double getPerbandinganBetina() {
		return perbandinganBetina;
	}
	public void setPerbandinganBetina(Double perbandinganBetina) {
		this.perbandinganBetina = perbandinganBetina;
	}
	public String getKodePakan() {
		return KodePakan;
	}
	public void setKodePakan(String kodePakan) {
		KodePakan = kodePakan;
	}
	public String getJumlahPakan() {
		return JumlahPakan;
	}
	public void setJumlahPakan(String jumlahPakan) {
		JumlahPakan = jumlahPakan;
	}
	public String getPakanPerEkor() {
		return PakanPerEkor;
	}
	public void setPakanPerEkor(String pakanPerEkor) {
		PakanPerEkor = pakanPerEkor;
	}
	public String getKodeObat() {
		return KodeObat;
	}
	public void setKodeObat(String kodeObat) {
		KodeObat = kodeObat;
	}
	public String getJumlahObat() {
		return JumlahObat;
	}
	public void setJumlahObat(String jumlahObat) {
		JumlahObat = jumlahObat;
	}
	public String getProduksiTelur() {
		return ProduksiTelur;
	}
	public void setProduksiTelur(String produksiTelur) {
		ProduksiTelur = produksiTelur;
	}
	public String getPersentaseProduksi() {
		return PersentaseProduksi;
	}
	public void setPersentaseProduksi(String persentaseProduksi) {
		PersentaseProduksi = persentaseProduksi;
	}
	public String getBiayaVariabel() {
		return BiayaVariabel;
	}
	public void setBiayaVariabel(String biayaVariabel) {
		BiayaVariabel = biayaVariabel;
	}
	public String getKomentarKematian() {
		return KomentarKematian;
	}
	public void setKomentarKematian(String komentarKematian) {
		KomentarKematian = komentarKematian;
	}


	public void setTanggalCatatan(LocalDate now) {
		// TODO Auto-generated method stub
		
	}


	public Integer getPenjualanJantan() {
		return PenjualanJantan;
	}


	public Integer getAfkirJantan() {
		return AfkirJantan;
	}


	public Integer getPindahJantan() {
		return PindahJantan;
	}


	public Integer getPenjualanBetina() {
		return PenjualanBetina;
	}


	public Integer getAfkirBetina() {
		return AfkirBetina;
	}


	public Integer getPindahBetina() {
		return PindahBetina;
	}


	public void setPenjualanJantan(Integer penjualanJantan) {
		PenjualanJantan = penjualanJantan;
	}


	public void setAfkirJantan(Integer afkirJantan) {
		AfkirJantan = afkirJantan;
	}


	public void setPindahJantan(Integer pindahJantan) {
		PindahJantan = pindahJantan;
	}


	public void setPenjualanBetina(Integer penjualanBetina) {
		PenjualanBetina = penjualanBetina;
	}


	public void setAfkirBetina(Integer afkirBetina) {
		AfkirBetina = afkirBetina;
	}


	public void setPindahBetina(Integer pindahBetina) {
		PindahBetina = pindahBetina;
	}
	
	
}
