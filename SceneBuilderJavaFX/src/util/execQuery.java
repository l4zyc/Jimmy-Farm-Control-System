package util;

import java.sql.SQLException;

public interface execQuery {
	public static final Connect connect = Connect.getInstance();
	
	public static void insertValue(String query, Object object) {
		connect.rs = connect.execQuery(query);
		
		try {
			while(connect.rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
