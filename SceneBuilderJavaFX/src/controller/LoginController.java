package controller;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.User;
import resources.Register;
import util.execQuery;
import util.reusableMethod;

public class LoginController {

	@FXML private Button loginBtn;
	@FXML private Label accountSign;

	@FXML private TextField usernameField;
	@FXML private TextField passwordField;
	
	public void noAccount() {
		accountSign.setUnderline(true);
	}
	
	public void exitNoAccount() {
		accountSign.setUnderline(false);
	}
	
	public void createAccount() {
		Stage window = (Stage) accountSign.getScene().getWindow();
		window.close();
		new Register();
	}
	
	public void clickLoginBtn() {
		String username = usernameField.getText();
		String password = passwordField.getText();
	
		boolean listCheck = checkList(execQuery.getData(), username, password);
		
		if(!listCheck) {
			reusableMethod.showAlert(AlertType.ERROR, "Error", "Invalid Username or Password");
			return;
		}
		
		reusableMethod.showAlert(AlertType.INFORMATION, "Logged in", "Access Granted!");
		Stage window = (Stage) loginBtn.getScene().getWindow();
		window.close();
	}
	
	public boolean checkList(ArrayList<User> users, String username, String password) {
		for (User user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void passwordKeyCode() {
		passwordField.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode().equals(KeyCode.ENTER)) {
					clickLoginBtn();
				} else if(event.getCode().equals(KeyCode.UP)) {
 					usernameField.requestFocus();
				}
			}
		});
	}
	
	public void usernameKeyCode() {
		usernameField.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.ENTER)) {
					
					if(usernameField.getText().isEmpty()) {
						return;
					}
					
					passwordField.requestFocus();
				} 
			}
			
		});
	}
}
