package view;

import controller.LoginController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginView extends ViewTemplate{

	BorderPane bp = new BorderPane(); 
	GridPane form = new GridPane();

	Scene scene = new Scene(bp, 300, 300);
	Label loginLbl, usernameLbl, passwordLbl, signUpLbl, ALbl;
	TextField usernameTF;
	PasswordField passwdPF;
	Button signIn;
	HBox signUpContainer;
	
	private Stage stage;
	
	public LoginView() {
		init();
		arrangeComponent();
		
		stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();
		
		new LoginController(this);
	}
	
	@Override
	public void init() {
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
		
	}

	@Override
	public void arrangeComponent() {
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

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Label getLoginLbl() {
		return loginLbl;
	}

	public void setLoginLbl(Label loginLbl) {
		this.loginLbl = loginLbl;
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

	public Label getSignUpLbl() {
		return signUpLbl;
	}

	public void setSignUpLbl(Label signUpLbl) {
		this.signUpLbl = signUpLbl;
	}

	public Label getALbl() {
		return ALbl;
	}

	public void setALbl(Label aLbl) {
		ALbl = aLbl;
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
