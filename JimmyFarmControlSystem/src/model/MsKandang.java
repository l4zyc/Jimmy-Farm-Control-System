package model;

import java.sql.*;

public class MsKandang {

	private String KodeKandang; 
	private String Lokasi;
	
	public MsKandang(String kodeKandang, String lokasi) {
		KodeKandang = kodeKandang;
		Lokasi = lokasi;
	}
	
	public String getKodeKandang() {
		return KodeKandang;
	}
	public String getLokasi() {
		return Lokasi;
	}
	public void setKodeKandang(String kodeKandang) {
		KodeKandang = kodeKandang;
	}
	public void setLokasi(String lokasi) {
		Lokasi = lokasi;
	}

	
}
