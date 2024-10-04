package resources;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {

	@FXML
	private Label accountSign;
	
	public void noAccount() {
		accountSign.setUnderline(true);
	}
	
	public void exitNoAccount() {
		accountSign.setUnderline(false);
	}
}
