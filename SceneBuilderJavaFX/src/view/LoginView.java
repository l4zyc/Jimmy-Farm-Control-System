package view;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginView extends viewTemplate{

	private Stage stage;
	private Scene scene;
	private BorderPane mainLayout;
	
	public LoginView() {
		start();
	}
	
	public void start() {
		try {
			init();
			stage = new Stage();
			
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(MainPageView.currStage);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.initStyle(StageStyle.UNDECORATED);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
	    Label loginLabel = new Label("Login");
	    loginLabel.setFont(new Font("System Bold", 31));
	    loginLabel.setPadding(new Insets(40, 0, 0, 0));
	    BorderPane.setAlignment(loginLabel, javafx.geometry.Pos.CENTER);

	    // Center GridPane (Username, Password)
	    GridPane centerGrid = new GridPane();
	    centerGrid.setPadding(new Insets(30, 0, 0, 0));

	    Label usernameLabel = new Label("Username");
	    usernameLabel.setFont(new Font(18));
	    GridPane.setHalignment(usernameLabel, HPos.CENTER);
	    centerGrid.add(usernameLabel, 0, 0);  // First and only addition

	    TextField usernameField = new TextField();
	    usernameField.setMaxWidth(200);
	    centerGrid.add(usernameField, 1, 0);  // First and only addition

	    Label passwordLabel = new Label("Password");
	    passwordLabel.setFont(new Font(18));
	    GridPane.setHalignment(passwordLabel, HPos.CENTER);
	    centerGrid.add(passwordLabel, 0, 1);  // First and only addition

	    PasswordField passwordField = new PasswordField();
	    passwordField.setMaxWidth(200);
	    passwordField.setPrefSize(177, 26);
	    centerGrid.add(passwordField, 1, 1);  // First and only addition

	    // Bottom GridPane (Login Button and Account Sign)
	    GridPane bottomGrid = new GridPane();
	    bottomGrid.setVgap(20);
	    bottomGrid.setPadding(new Insets(0, 0, 20, 0));

	    Button loginBtn = new Button("Login");
	    loginBtn.setFont(new Font("System Bold", 18));
	    loginBtn.setPrefSize(149, 22);
	    GridPane.setHalignment(loginBtn, HPos.CENTER);
	    bottomGrid.add(loginBtn, 0, 0);

	    Label accountSign = new Label("Don't have an account? Sign Up");
	    accountSign.setFont(new Font(14));
	    GridPane.setHalignment(accountSign, HPos.CENTER);
	    bottomGrid.add(accountSign, 0, 1);

	    // Set grid gaps
	    centerGrid.setHgap(10);
	    centerGrid.setVgap(20);
	    centerGrid.setPadding(new Insets(10));

	    // Main BorderPane
	    BorderPane root = new BorderPane();
	    root.setTop(loginLabel);
	    root.setCenter(centerGrid);
	    root.setBottom(bottomGrid);

	    // Set up the Scene
	    scene = new Scene(root, 500, 500);
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
	}

}
