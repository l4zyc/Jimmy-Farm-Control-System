package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class User {
	private String name;
	private String username;
	private String password;
	private String confPasswd;
	
	public String getName() {
		return name;
	}
	public boolean setName(String name) {
		if(name.length() < 5) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("name field is less than 5");
			alert.showAndWait();
			return false;
		}
		this.name = name;
		
		return true;
	}
	public String getUsername() {
		return username;
	}
	public boolean setUsername(String username) {
		if(username.length() < 5) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("username field is less than 5");
			alert.showAndWait();
			return false;
		}
		
		this.username = username;
		
		return true;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfPasswd() {
		return confPasswd;
	}
	public void setConfPasswd(String confPasswd) {
		this.confPasswd = confPasswd;
	}
}
