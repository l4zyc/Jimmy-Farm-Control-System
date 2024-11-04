package view;

import javafx.scene.control.Label;
import controller.RegisterController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class RegisterView extends ViewTemplate{

	BorderPane bp = new BorderPane(); 
	GridPane form = new GridPane();
	Stage stage;
	Scene scene;
	VBox BottomContainer;
	Label RegisterLbl, nameLbl, usernameLbl, passwordLbl, confirmpasswordLbl, loginpageLbl, ALbl;
	
	//Lbl = Label 
	//TF = TextField 
	//PF = Password Field (Dikhususkan untuk password)  
	//ALbl itu untuk tulisan "Login" yang dibuat bold 
	//HBOX login itu buat yang bagian masuk lagi ke halaman login 

	TextField nameTF, usernameTF; 
	PasswordField passwordPF, confirmpasswordPF;
	Button signUpbtn; 
	HBox Login;
	public RegisterView() {  
		init(); 
		arrangeComponent(); 
		
		stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Register");
		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(MainPageView.mainStage);
		stage.show(); 
		
		new RegisterController(this);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
				scene = new Scene(bp, width * 0.65, height * 0.65);
				//Name and Username 
				RegisterLbl = new Label("Sign Up");
				RegisterLbl.setFont(new Font(35));
				nameLbl = new Label("Name");
				nameLbl.setFont(new Font(15));
				usernameLbl = new Label("Username"); 
				usernameLbl.setFont(new Font(15));
				nameTF = new TextField(); 
				usernameTF = new TextField();  
				
				//Password and Confirm passowrd
				passwordLbl = new Label("Password"); 
				passwordLbl.setFont(new Font(15));
				confirmpasswordLbl = new Label("Confirm Password");
				confirmpasswordLbl.setFont(new Font(15));
				passwordPF = new PasswordField(); 
				confirmpasswordPF = new PasswordField();
				
				//Bagian Button
				signUpbtn = new Button("Create Account"); 
				signUpbtn.setFont(Font.font("Inter", 20)); 
				signUpbtn.setMinWidth(150);
				
				//Bagian kearah Login Page  
				loginpageLbl = new Label("Already have an account? ");  
				ALbl = new Label("Login"); 
				ALbl.setStyle("-fx-font-weight: bold;");
				loginpageLbl.setFont(Font.font("Inter", 15)); 
				ALbl.setFont(Font.font("Inter", 15));  
				Login = new HBox(); 
				
				BottomContainer = new VBox();
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		form.setVgap(20); 
		form.setHgap(20);
		
		form.add(nameLbl, 0, 0);
		form.add(nameTF, 1, 0);
		
		form.add(usernameLbl, 0, 1);
		form.add(usernameTF, 1, 1);

		form.add(passwordLbl, 0, 2);
		form.add(passwordPF, 1, 2);
	
		form.add(confirmpasswordLbl, 0, 3);
		form.add(confirmpasswordPF, 1, 3);
		
		Login.getChildren().addAll(loginpageLbl, ALbl);
		
		BottomContainer.getChildren().add(signUpbtn);
		BottomContainer.getChildren().add(Login);
		
		bp.setTop(RegisterLbl);
		bp.setCenter(form);
		bp.setBottom(BottomContainer);
		
		bp.setPadding(new Insets(120));
		BorderPane.setAlignment(RegisterLbl, Pos.CENTER);
		form.setAlignment(Pos.CENTER);
		BottomContainer.setAlignment(Pos.CENTER);
		BottomContainer.setSpacing(10);
		Login.setAlignment(Pos.CENTER);
	}

	public BorderPane getBp() {
		return bp;
	}

	public void setBp(BorderPane bp) {
		this.bp = bp;
	}

	public GridPane getForm() {
		return form;
	}

	public void setForm(GridPane form) {
		this.form = form;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public TextField getNameTF() {
		return nameTF;
	}

	public void setNameTF(TextField nameTF) {
		this.nameTF = nameTF;
	}

	public TextField getUsernameTF() {
		return usernameTF;
	}

	public void setUsernameTF(TextField usernameTF) {
		this.usernameTF = usernameTF;
	}

	public PasswordField getPasswordPF() {
		return passwordPF;
	}

	public void setPasswordPF(PasswordField passwordPF) {
		this.passwordPF = passwordPF;
	}

	public PasswordField getConfirmpasswordPF() {
		return confirmpasswordPF;
	}

	public void setConfirmpasswordPF(PasswordField confirmpasswordPF) {
		this.confirmpasswordPF = confirmpasswordPF;
	}

	public Button getSignUpbtn() {
		return signUpbtn;
	}

	public void setSignUpbtn(Button signUpbtn) {
		this.signUpbtn = signUpbtn;
	}

	public HBox getLogin() {
		return Login;
	}

	public void setLogin(HBox login) {
		Login = login;
	}

	public Label getRegisterLbl() {
		return RegisterLbl;
	}

	public void setRegisterLbl(Label registerLbl) {
		RegisterLbl = registerLbl;
	}

	public Label getNameLbl() {
		return nameLbl;
	}

	public void setNameLbl(Label nameLbl) {
		this.nameLbl = nameLbl;
	}

	public Label getUsernameLbl() {
		return usernameLbl;
	}

	public void setUsernameLbl(Label usernameLbl) {
		this.usernameLbl = usernameLbl;
	}

	public Label getPasswordLbl() {
		return passwordLbl;
	}

	public void setPasswordLbl(Label passwordLbl) {
		this.passwordLbl = passwordLbl;
	}

	public Label getConfirmpasswordLbl() {
		return confirmpasswordLbl;
	}

	public void setConfirmpasswordLbl(Label confirmpasswordLbl) {
		this.confirmpasswordLbl = confirmpasswordLbl;
	}

	public Label getLoginpageLbl() {
		return loginpageLbl;
	}

	public void setLoginpageLbl(Label loginpageLbl) {
		this.loginpageLbl = loginpageLbl;
	}

	public Label getALbl() {
		return ALbl;
	}

	public void setALbl(Label aLbl) {
		ALbl = aLbl;
	} 
	
	
	

	
	
}
