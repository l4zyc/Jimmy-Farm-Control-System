package resources;


import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Login {

	Stage stage;
	Scene scene;
	
	public Login() {
		start();
	}
	
	public void start() {
		try {
			stage = new Stage();
			Parent login = FXMLLoader.load(getClass().getResource("/view/Login.FXML"));
			scene = new Scene(login);
			
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Main.currStage);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.initStyle(StageStyle.UNDECORATED);

			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
