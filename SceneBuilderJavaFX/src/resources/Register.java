package resources;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Register {
	
	Stage stage;
	Scene scene;

	public Register() {
		start();
	}
	
	public void start() {
		try {
			stage = new Stage();
			Parent register = FXMLLoader.load(getClass().getResource("Register.FXML"));
			scene = new Scene(register);
			
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Main.currStage);
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}