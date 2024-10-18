package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

import util.createPage;

public class MainController {
	@FXML MenuItem Logout;
	@FXML Button inputDataBtn;
	
	public void onLogOut() {
		createPage.loginpage();
	}
	
	public void onClickInputDataBtn() {
		createPage.DataInputCatatanHarian();
	}
}
