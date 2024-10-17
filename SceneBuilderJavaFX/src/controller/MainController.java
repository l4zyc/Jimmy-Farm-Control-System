package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import resources.Data_Input_Catatan_Harian_Form;
import util.createPage;

public class MainController {
	@FXML MenuItem Logout;
	@FXML Button inputDataBtn;
	
	public void onLogOut() {
		createPage.loginpage();
	}
	
	public void onClickInputDataBtn() {
		Stage stage = (Stage) inputDataBtn.getScene().getWindow();
		stage.close();
		
		createPage.DataInputCatatanHarian();
	}
}
