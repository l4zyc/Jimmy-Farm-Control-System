package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.User;
import resources.Login;
import resources.Validation;
import util.createPage;
import util.execQuery;

public class RegisterController {

	@FXML
	private Label existLbl;
	
	@FXML
	private TextField nameField, usernameField;
	@FXML
	private PasswordField passwdField, confPasswdField;
	@FXML
	private Button createAccBtn;
	
	public void loginLabel() {
		existLbl.setUnderline(true);
	}
	
	public void onClickLabelLogin() {
		Stage stage = (Stage) existLbl.getScene().getWindow();
		stage.close();
		createPage.loginpage();
	}
	
	public void exitLoginLabel() {
		existLbl.setUnderline(false);
	}
	
	public void onCreateBtnPressed() {
		createAccBtn.setStyle("");
	}
	
	public void onCreateBtnReleased() {
		createAccBtn.setStyle("");
	}
	
	public void registerUser() {
		String name = nameField.getText();
		String username = usernameField.getText();
		String password = passwdField.getText();
		String confirm = confPasswdField.getText();
		User user = new User("", "", "", "", "");
		
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
		
		String ID = execQuery.getNewID();
		
		user.setID(ID);
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setConfPasswd(confirm);
		
		execQuery.insertValue(user);
		
		alert.setAlertType(AlertType.INFORMATION);
		alert.setContentText("Account created");
		alert.showAndWait();
		
		Stage stage = (Stage) existLbl.getScene().getWindow();
		stage.close();
		
		createPage.loginpage();
	}

}
