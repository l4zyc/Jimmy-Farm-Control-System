package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import resources.Register;

public class LoginController {

	@FXML
	private Button loginBtn;
	@FXML
	private Label accountSign;
	
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
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Log in!");
		alert.showAndWait();
		
		Stage window = (Stage) loginBtn.getScene().getWindow();
		window.close();
	}
}
