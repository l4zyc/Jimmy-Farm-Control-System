package view;

import controller.LoginController;
import javafx.event.EventHandler;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class LoginView extends ViewTemplate{

	BorderPane bp = new BorderPane(); 
	GridPane form = new GridPane();
	
	Double width = Screen.getPrimary().getBounds().getWidth();
	Double height = Screen.getPrimary().getBounds().getHeight(); 

	Scene scene = new Scene(bp, width * 0.5, height * 0.5);
	Label loginLbl, usernameLbl, passwordLbl, signUpLbl, ALbl;
	TextField usernameTF;
	PasswordField passwdPF;
	Button signIn;
	VBox signUpContainer; HBox noAccountLblContainer;
	
	private Stage stage;
	
	public LoginView() {
		init();
		arrangeComponent();
		
		stage = new Stage();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(MainPageView.mainStage);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.setFullScreen(false);
		stage.show();
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				event.consume();
			}
		});
		
		new LoginController(this);
	}
	
	@Override
	public void init() { 
		//bagian username dan password
		loginLbl = new Label("Login"); 
		usernameLbl = new Label("Username");
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
		signUpContainer = new VBox();
		noAccountLblContainer = new HBox();
		noAccountLblContainer.getChildren().addAll(signUpLbl, ALbl);
		signUpContainer.getChildren().addAll(signIn, noAccountLblContainer);
	}

	@Override
	public void arrangeComponent() {
		form.setVgap(5); 
		form.setHgap(5);
		//bagian username, password
		form.add(usernameLbl, 0, 0);  
		form.add(usernameTF, 1, 0);
		form.add(passwordLbl, 0, 1); 
		form.add(passwdPF, 1, 1); 
	
		
		bp.setTop(loginLbl);
		bp.setCenter(form);
		bp.setBottom(signUpContainer);
		
		signUpContainer.setAlignment(Pos.CENTER);
		noAccountLblContainer.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(loginLbl, Pos.CENTER);
		
		bp.setPadding(new Insets(100));
		
		signUpContainer.setSpacing(10);
		
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

	public VBox getSignUpContainer() {
		return signUpContainer;
	}

	public void setSignUpContainer(VBox signUpContainer) {
		this.signUpContainer = signUpContainer;
	}
	
	

}
