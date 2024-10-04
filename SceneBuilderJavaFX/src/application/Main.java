package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import resources.Login;

public class Main extends Application {
	public static Stage currStage;
	
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root, 1200, 600);
			currStage = stage;
	
			stage.setScene(scene);
			stage.setTitle("Jimmy Farm Control System");
			stage.show();
			stage.setResizable(false);
			
			new Login();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
