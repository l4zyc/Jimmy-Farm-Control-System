package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RegisterController {

	@FXML
	private Label existLbl;
	
	public void loginLabel() {
		existLbl.setUnderline(true);
	}
	
	public void exitloginLabel() {
		existLbl.setUnderline(false);
	}

}
