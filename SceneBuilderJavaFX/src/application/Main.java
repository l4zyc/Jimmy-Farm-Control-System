package application;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import resources.Login;

public class Main extends Application {
	public static Stage currStage;
	
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Main.FXML"));
			Scene scene = new Scene(root, 2000, 2000);
			currStage = stage;
	 
			stage.setScene(scene);
			stage.setTitle("Jimmy Farm Control System");
			stage.show();
			stage.setResizable(false);
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				
				@Override
				public void handle(WindowEvent event) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Do you want to Quit ?");
					alert.setTitle("Exit");
					
					Optional<ButtonType> close = alert.showAndWait();
					
					if(close.get().equals(ButtonType.CANCEL)) {
						event.consume();
					}
				}
			});
			
			new Login();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
