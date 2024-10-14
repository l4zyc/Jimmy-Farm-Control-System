package util;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;

public interface execQuery {
	public static final Connect connect = Connect.getInstance();
	
	public static void insertValue(User user) {
		String query = String.format("INSERT INTO MsUser (UserID, Name, Username, passwd) VALUES ('%s', '%s', '%s', '%s')"
				, user.getID(), user.getName(), user.getUsername(), user.getPassword());
		
		connect.execUpdate(query);
	}
	
	
	public static String getNewID() {
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
	
	public static ArrayList<User> getData() {
		connect.rs = connect.execQuery("SELECT * FROM MsUser");
		
		ArrayList<User> user_list = new ArrayList<User>();
		
		try {
			while(connect.rs.next()) {
				String ID = connect.rs.getString("UserID");
				String name = connect.rs.getString("Name");
				String username = connect.rs.getString("Username");
				String passwd = connect.rs.getString("passwd");
				
				user_list.add(new User(ID, name, username, passwd, passwd));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user_list;
	}
}
