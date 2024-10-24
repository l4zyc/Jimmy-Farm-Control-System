package main;

import controller.LoginController;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField; 

public class Main extends Application{

	BorderPane bp = new BorderPane(); 
	GridPane form = new GridPane();

	Scene scene = new Scene(bp, 300, 300);
	Label loginLbl, usernameLbl, passwordLbl, signUpLbl, ALbl;
	TextField usernameTF;
	PasswordField passwdPF;
	Button signIn;
	HBox signUpContainer;
	
	public void login() { 
		//Bagian input data UserName and Password
		loginLbl = new Label("Login"); 
		usernameLbl = new Label("UserName");
		passwordLbl = new Label("Password");  
		loginLbl.setStyle("-fx-font-size: 36px;-fx-font-weight: bold;");
		loginLbl.setFont(Font.font("Inter", 36));
		usernameLbl.setStyle("-fx-font-size: 20px");  
		usernameLbl.setFont(Font.font("Inter", 20));
		passwordLbl.setStyle("-fx-font-size: 20px"); 
		passwordLbl.setFont(Font.font("Inter", 20));
		usernameTF = new TextField(); 
		passwdPF = new PasswordField();  
		
		//Bagian Button
		signIn = new Button("Login"); 
		signIn.setFont(Font.font("Inter", 20));
		signIn.setMinWidth(150);
		
		//Bagian sign up
		signUpLbl = new Label("Don't have an account? "); 
		ALbl = new Label("Sign Up");
		ALbl.setStyle("-fx-font-weight: bold;");  
		signUpLbl.setFont(Font.font("Inter", 10)); 
		ALbl.setFont(Font.font("Inter", 10));
		signUpContainer = new HBox();
		signUpContainer.getChildren().addAll(signUpLbl, ALbl);
		
		
		form.setVgap(5); 
		form.setHgap(2);
		
		form.add(usernameLbl, 0, 1);  
		form.add(usernameTF, 1, 1);
		form.add(passwordLbl, 0, 2); 
		form.add(passwdPF, 1, 2); 
		form.add(signIn, 1, 3);
		form.add(signUpContainer, 1, 4);
		
		bp.setTop(loginLbl);
		bp.setCenter(form);
		BorderPane.setAlignment(loginLbl, Pos.CENTER);
		
		bp.setPadding(new Insets(290));
		
		GridPane.setHalignment(loginLbl, HPos.CENTER);
		
		
		form.setAlignment(Pos.CENTER);
		
		new LoginController(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub 
		primaryStage.setTitle("Login"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
		login();
	}
	
	
	public Label getSignUpLbl() {
		return signUpLbl;
	}

	public void setSignUpLbl(Label signUpLbl) {
		this.signUpLbl = signUpLbl;
	}

	public TextField getUsernameTF() {
		return usernameTF;
	}

	public void setUsernameTF(TextField usernameTF) {
		this.usernameTF = usernameTF;
	}

	public PasswordField getPasswdPF() {
		return passwdPF;
	}

	public void setPasswdPF(PasswordField passwdPF) {
		this.passwdPF = passwdPF;
	}

	public Button getSignIn() {
		return signIn;
	}

	public void setSignIn(Button signIn) {
		this.signIn = signIn;
	}

	public HBox getSignUpContainer() {
		return signUpContainer;
	}

	public void setSignUpContainer(HBox signUpContainer) {
		this.signUpContainer = signUpContainer;
	}
	
	

}
