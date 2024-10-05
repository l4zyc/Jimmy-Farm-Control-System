package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.User;
import resources.Validation;

public class RegisterController {

	@FXML
	private Label existLbl;
	
	@FXML
	private TextField nameField, usernameField;
	@FXML
	private PasswordField passwdField, confPasswdField;
	
	public void loginLabel() {
		existLbl.setUnderline(true);
	}
	
	public void exitLoginLabel() {
		existLbl.setUnderline(false);
	}
	
	public void registerUser() {
		String name = nameField.getText();
		String username = usernameField.getText();
		String password = passwdField.getText();
		String confirm = confPasswdField.getText();
		User user = new User();
		
		Alert alert = new Alert(AlertType.ERROR);
		
		if(!user.setName(name)) {
			return;
		} else if(!user.setUsername(username)) {
			return;
		} 
		
		if(!Validation.isAlphanumeric(password) || password.length() < 5) {
			alert.setContentText("The Password needs to be Alphanumeric or its less than 5 Alphabet");
			alert.showAndWait();
			return;
		}
		
		if(!confirm.equals(password)) {
			alert.setContentText("Does not match with the Password");
			alert.showAndWait();
			return;
		}
		
		
	}

}
