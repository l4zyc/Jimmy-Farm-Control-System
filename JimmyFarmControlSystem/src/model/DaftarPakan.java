package model;

import java.sql.*;

public class DaftarPakan{ 
	
	private String KodePakan; 
	private String NamaPakan; 
	private String JenisPakan;
	private Integer Harga; 
	
	public DaftarPakan(String kodePakan, String namaPakan, String jenisPakan,Integer harga) {

		KodePakan = kodePakan;
		NamaPakan = namaPakan;
		JenisPakan = jenisPakan;
		Harga = harga;
	}
	
	public String getKodePakan() {
		return KodePakan;
	}
	
	public String getNamaPakan() {
		return NamaPakan;
	}
	
	public String getJenisPakan() {
		return JenisPakan;
	}
	
	public Integer getHarga() {
		return Harga;
	}
	
	public void setKodePakan(String kodePakan) {
		KodePakan = kodePakan;
	}
	
	public void setNamaPakan(String namaPakan) {
		NamaPakan = namaPakan;
	}
	
	public void setJenisPakan(String jenisPakan) {
		JenisPakan = jenisPakan;
	}
	
	public void setHarga(Integer harga) {
		Harga = harga;
	}
	
}
