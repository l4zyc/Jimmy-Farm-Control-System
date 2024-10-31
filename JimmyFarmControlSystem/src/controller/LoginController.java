package controller;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
import model.User;
import util.Data;
import util.execQuery;
import util.reusableMethod;
import view.LoginView;
import view.RegisterView;

public class LoginController {
	
	private LoginView view;
	private Data data = new Data();
	
	public LoginController(LoginView loginView) {
		this.view = loginView;
		setOnActionEvent();
		setOnMouseClicked();
	}
	
	public void setOnActionEvent() {
		view.getSignIn().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				clickLoginBtn();
			}
		});
	}
	
	public void setOnMouseClicked() {
		view.getSignUpContainer().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getSignUpContainer().getScene().getWindow();
				window.close();
				new RegisterView();
			}
		});
	}
	
	public void clickLoginBtn() {
		String username = view.getUsernameTF().getText();
		String password = view.getPasswdPF().getText();

		boolean listCheck = checkList(data.getData(), username, password);
		
		if(!listCheck) {
			reusableMethod.showAlert(AlertType.ERROR, "Error", "Invalid Username or Password");
			return;
		}
		
		reusableMethod.showAlert(AlertType.INFORMATION, "Log In", "Logged In!");
		
		Stage window = (Stage) view.getSignIn().getScene().getWindow();
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
}
