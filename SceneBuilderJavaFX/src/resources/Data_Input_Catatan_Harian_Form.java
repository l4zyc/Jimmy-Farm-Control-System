package resources;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Data_Input_Catatan_Harian_Form {
	
	Stage stage = new Stage();

	public Data_Input_Catatan_Harian_Form() {
		start();
	}
	
	public void start()
	{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Data_Input_Catatan_Harian_Form.fxml"));
			Scene scene = new Scene(root);
			
			stage.initOwner(Main.currStage);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setTitle("Input Data Catatan Harian");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
