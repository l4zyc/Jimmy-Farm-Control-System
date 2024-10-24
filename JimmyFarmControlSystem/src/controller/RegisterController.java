package controller;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.Main;
import model.User;
import util.execQuery;
import util.reusableMethod;
import view.RegisterView;

public class RegisterController {
	private RegisterView view;
	
	public RegisterController(RegisterView view) {
		this.view = view;
		setOnActionEvent();
	}
	
	//Digunakan sebagai fuction untuk menampung data
	public void setOnActionEvent() {
		view.getSignUpbtn().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				clickSignUpBtn();
			}
		});
		
	}
	
	public void clickSignUpBtn() {
		String name = view.getNameTF().getText();
		String username = view.getUsernameTF().getText();
		String password = view.getPasswordPF().getText();
		String confirmpassword = view.getConfirmpasswordPF().getText();
		String userID = execQuery.getNewID();

		if(name.isEmpty()) {
			reusableMethod.showAlert(AlertType.ERROR, "Error", "Name");
			return;
		}else if(isNameUnique(name)) { 
			reusableMethod.showAlert(AlertType.ERROR, "Error", "Name Exist");
			return;
		}
	
		if(username.isEmpty()) {
			reusableMethod.showAlert(AlertType.ERROR, "Error", "Input userName");
			return;
		}else if(isUserNameUnique(username)) { 
			reusableMethod.showAlert(AlertType.ERROR, "Error", "User name Exist");
			return;
		}
		
		if(!confirmpassword.equals(password)) { 
			return;
		} 
		
		execQuery.insertUser(new User(userID, name, username, password,confirmpassword));
	} 
	
	//validasi nama harus unik
	public boolean isNameUnique(String name) {
		ArrayList<User> users = execQuery.getData();
		
		for (User user : users) {
			if(user.getName().equals(name)) { 
				return true;
			}
		}  
		return false;
	} 
	
	//validasi username harus unik
	public boolean isUserNameUnique(String username) { 
		ArrayList<User> users = execQuery.getData(); 
		
		for (User user : users) { 
			if(user.getUsername().equals(username)) { 
				return true;
			}
		}
		return false;
	}
}
