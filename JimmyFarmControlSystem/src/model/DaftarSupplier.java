package model;

import java.sql.*;

public class DaftarSupplier {
	
	private String KodeSupplier; 
	private String NamaSupplier; 
	
	public DaftarSupplier(String kodeSupplier, String namaSupplier) {

		KodeSupplier = kodeSupplier;
		NamaSupplier = namaSupplier; 
	}

	public String getKodeSupplier() {
		return KodeSupplier;
	}
	
	public String getNamaSupplier() {
		return NamaSupplier;
	}
	
	public void setKodeSupplier(String kodeSupplier) {
		KodeSupplier = kodeSupplier;
	}
	
	public void setNamaSupplier(String namaSupplier) {
		NamaSupplier = namaSupplier;
	}
	
}
