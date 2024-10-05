package resources;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

	@FXML
	private Label accountSign;
	@FXML
	private Button loginBtn;
	
	public void noAccount() {
		accountSign.setUnderline(true);
	}
	
	public void exitNoAccount() {
		accountSign.setUnderline(false);
	}
	
	public void clickLoginBtn() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Log in!");
		alert.showAndWait();
		
		Stage window = (Stage) loginBtn.getScene().getWindow();
		window.close();
	}
}
