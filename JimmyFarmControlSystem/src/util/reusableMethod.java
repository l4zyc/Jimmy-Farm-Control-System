package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public interface reusableMethod {
	public static void showAlert(AlertType type, String title, String content) {
		Alert alert = new Alert(type);
		alert.setContentText(content);
		alert.setTitle(title);
		
		alert.showAndWait();
	}
}
