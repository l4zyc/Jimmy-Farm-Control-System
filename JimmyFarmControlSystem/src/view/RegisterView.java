package view;

import javafx.scene.control.Label; 
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


public class RegisterView extends ViewTemplate{

	BorderPane bp = new BorderPane(); 
	GridPane form = new GridPane();

	Scene scene = new Scene(bp, 300, 300);
	
	Label name, username, password, confirmpassword;
	public RegisterView() { 
		name = new Label("Name");
		username = new Label("Username"); 
		password = new Label("Password"); 
		confirmpassword = new Label("Confirm Password");
	
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
	}

}
