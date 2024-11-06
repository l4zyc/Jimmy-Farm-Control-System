package controller.register;

import java.util.ArrayList;

import controller.ControllerData;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
import model.User;
import util.Data;
import util.reusableMethod;
import view.login.LoginView;
import view.register.RegisterView;

public class RegisterController extends ControllerData{
	private RegisterView view;
	
	public RegisterController(RegisterView view) {
		this.view = view;
		setOnActionEvent();
		setOnMouseClicked(); 
		signUPBtnClicked();
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
		String userID = data.getNewUserID();

		if(name.isEmpty()) { //validasi  name tersebut empty
			reusableMethod.showAlert(AlertType.ERROR, "Error", "Name");
			return;
		}else if(isNameUnique(name)) { //validasi name harus unique
			reusableMethod.showAlert(AlertType.ERROR, "Error", "Name Exist");
			return;
		}
	
		if(username.isEmpty()) { //validasi username tersebut empty
			reusableMethod.showAlert(AlertType.ERROR, "Error", "Input userName");
			return;
		}else if(isUserNameUnique(username)) { //validasi username harus unique
			reusableMethod.showAlert(AlertType.ERROR, "Error", "User name Exist");
			return;
		}
		
		if(password.isEmpty()) { //validasi password tersebut empty
			reusableMethod.showAlert(AlertType.ERROR, "Error", "Input password");
			return;
		}
		
		if(confirmpassword.isEmpty()) {// validasi harus memasukan confirm password
			reusableMethod.showAlert(AlertType.ERROR, "Error", "Input confirm password");
			return;
		}else if(!confirmpassword.equals(password)) { //validasi memasukan password sama dengan confirm password
			reusableMethod.showAlert(AlertType.INFORMATION, "Error", "Input the same password");
			return;
		}
		
		data.insertUser(new User(userID, name, username, password,confirmpassword));
		view.getNameTF().setText(null);
		view.getUsernameTF().setText(null);
		view.getPasswordPF().setText(null);
		view.getConfirmpasswordPF().setText(null);
		
		new LoginView();
	} 
	
	public void setOnMouseClicked() { 
		view.getLogin().setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getLogin().getScene().getWindow();
				window.close();
				new LoginView();
			} 
			
		});
	}
	
	public void signUPBtnClicked() { 
		view.getSignUpbtn().setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getSignUpbtn().getScene().getWindow(); 
				window.close(); 
				new LoginView(); 
			} 
			
		});
	}
	
	//validasi nama harus unik
	public boolean isNameUnique(String name) {
		ArrayList<User> users = data.getUserData();
		
		for (User user : users) {
			if(user.getName().equals(name)) { 
				return true;
			}
		}  
		return false;
	} 
	
	//validasi username harus unik
	public boolean isUserNameUnique(String username) { 
		ArrayList<User> users = data.getUserData(); 
		
		for (User user : users) { 
			if(user.getUsername().equals(username)) { 
				return true;
			}
		}
		return false;
	}
}
