package util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import model.CatatanHarianUtama;
import model.DaftarObat;

public interface reusableMethod {
	
	public static Optional<ButtonType> confirmationAlert(String title, String text) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setContentText(text);
		Optional<ButtonType> optional = alert.showAndWait();
		
		return optional;
	}
	
	public static void showAlert(AlertType type, String title, String content) {
		Alert alert = new Alert(type);
		alert.setContentText(content);
		alert.setTitle(title);
		
		alert.showAndWait();
	} 
}
