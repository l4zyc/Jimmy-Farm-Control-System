package controller;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.User;
import resources.Register;
import util.execQuery;
import util.reusableMethod;

public class LoginController {

	@FXML private Button loginBtn;
	@FXML private Label accountSign;

	@FXML private TextField usernameField;
	@FXML private TextField passwordField;
	
	public void noAccount() {
		accountSign.setUnderline(true);
	}
	
	public void exitNoAccount() {
		accountSign.setUnderline(false);
	}
	
	public void createAccount() {
		Stage window = (Stage) accountSign.getScene().getWindow();
		window.close();
		new Register();
	}
	
	public void clickLoginBtn() {
		String username = usernameField.getText();
		String password = passwordField.getText();
	
		boolean listCheck = checkList(execQuery.getData(), username, password);
		
		if(!listCheck) {
			reusableMethod.showAlert(AlertType.ERROR, "Error", "Invalid Username or Password");
			return;
		}
		
	    Platform.runLater(() -> {
	        progressBar();
	    });
		
		Stage window = (Stage) loginBtn.getScene().getWindow();
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
	
	public void passwordKeyCode() {
		passwordField.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode().equals(KeyCode.ENTER)) {
					clickLoginBtn();
				} else if(event.getCode().equals(KeyCode.UP)) {
 					usernameField.requestFocus();
				}
			}
		});
	}
	
	public void usernameKeyCode() {
		usernameField.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.ENTER)) {
					
					if(usernameField.getText().isEmpty()) {
						return;
					}
					
					passwordField.requestFocus();
				} 
			}
			
		});
	}
	
	public void progressBar() {
	    Button btn = new Button("Close");
	    Label lbl = new Label("Checking User Database...");
	    BorderPane bp = new BorderPane();
	    Stage stage = new Stage();
	    Scene scene = new Scene(bp, 250, 100);

	    VBox container = new VBox();

	    ProgressBar pb = new ProgressBar();
	    pb.setProgress(0);
	    pb.setPrefWidth(150);

	    container.getChildren().addAll(pb, lbl);
	    container.setAlignment(Pos.CENTER);
	    container.setSpacing(5);
	    lbl.setVisible(true);

	    BorderPane.setMargin(btn, new Insets(0, 0, 10, 0));
	    bp.setCenter(container);
	    bp.setBottom(btn);

	    BorderPane.setAlignment(btn, Pos.CENTER);
	    btn.setVisible(false);

	    stage.setTitle("Progress");
	    stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show();
	    
	    setTimer(pb, 5, btn);

	    btn.setOnAction(event -> {
	    	pbClose(stage);
	    });
	    
	    btn.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.ENTER)) {
					pbClose(stage);
				}
			}
		});
	}
	
	//Close Progress Bar
	public void pbClose(Stage stage) {
		stage.close();  
        reusableMethod.showAlert(AlertType.INFORMATION, "Logged in", "Access Granted!");
	}

	//Create a timer for progress Bar
	public void setTimer(ProgressBar pb, double totalSeconds, Button btn) {
	    Timeline timeline = new Timeline();

	    timeline.getKeyFrames().add(
	        new KeyFrame(Duration.seconds(0.1), event -> {
	            double progress = pb.getProgress();
	            if (progress < 1.0) {
	                pb.setProgress(progress + (0.1 / totalSeconds));
	            } else {
	                pb.setProgress(1.0);
	                btn.setVisible(true);
	                timeline.stop();
	            }
	        })
	    );

	    timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.play();
	}



}
