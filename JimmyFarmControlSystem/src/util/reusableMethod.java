package util;

import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import model.CatatanHarianUtama;
import model.DaftarObat;

public interface reusableMethod {
	static Data data = new Data();
	
	public static void showAlert(AlertType type, String title, String content) {
		Alert alert = new Alert(type);
		alert.setContentText(content);
		alert.setTitle(title);
		
		alert.showAndWait();
	}
	
	public static void refreshTable(TableView<CatatanHarianUtama> catatan) {
		catatan.getItems().clear();
		catatan.setItems(data.getCatatanHarian());
	}
	
	public static void refreshCatatanObatTable(TableView<DaftarObat> Obat_Table) {
		Obat_Table.getItems().clear();
		Obat_Table.setItems(data.getObatData());
	}
}
