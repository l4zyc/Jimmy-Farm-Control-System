package controller.masterObat;

import controller.ControllerData;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.DaftarObat;
import util.reusableMethod;
import view.MasterObat.ObatUpdateView;

public class MasterObatUpdateController extends ControllerData{
	private ObatUpdateView view;
	
	public MasterObatUpdateController(ObatUpdateView view) {
		this.view = view;
		setOnAction();
	}
	
	public void setOnAction() {
		view.getSave().setOnAction(e -> {
			String NAMA_OBAT = view.getNamaObatTF().getText();
			String JENIS_OBAT = view.getJenisObatCB().getValue().toString();
			Integer DOSIS; 
			try {
				DOSIS = Integer.parseInt(view.getDosisTF().getText());  
				if(DOSIS < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Dosis must be non-negative numbers.");
			        return; 
				}
			} catch (Exception e1) {
				// TODO: handle exception 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Dosis must be whole numbers.");
				return;
			} 
			String SATUAN = view.getSatuanCB().getValue().toString();
			String PENYAKIT = view.getPenyakitTF().getText();
			Integer JUMLAH_PER_PACK; 
			try {
				JUMLAH_PER_PACK = Integer.parseInt(view.getJumlahPerPackTF().getText());  
				
				if(JUMLAH_PER_PACK < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Per Pack must be non-negative numbers.");
			        return; 
				}
			} catch (Exception e1) {
				// TODO: handle exception 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Per Pack must be whole numbers.");
				return;
			}
			Integer HARGA_PER_PACK; 
			try {
				HARGA_PER_PACK = Integer.parseInt(view.getHargaPerPackTF().getText());  
				if(HARGA_PER_PACK < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Harga per pack must be non-negative numbers.");
			        return; 
				}
			} catch (Exception e1) {
				// TODO: handle exception 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Harga per pack must be whole numbers.");
				return;
			}
			Integer HARGA_PER_SATUAN; 
			try {
				HARGA_PER_SATUAN = Integer.parseInt(view.getHargaPerSatuanTF().getText()); 
				if(HARGA_PER_SATUAN < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Harga per satuan must be non-negative numbers.");
			        return; 
				}
			} catch (Exception e1) {
				// TODO: handle exception
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Harga per satuan must be whole numbers.");
				return;
			}
			
			String KODE_SUPPLIER = view.getKodeSupplierCB().getValue().toString();

			if(NAMA_OBAT.isEmpty()) { 
				reusableMethod.showAlert(AlertType.ERROR, "Error", "Please Insert Nama Obat");
				return;
			}
			
			
			if(PENYAKIT.isEmpty()) { 
				reusableMethod.showAlert(AlertType.ERROR, "Error", "Please Insert Penyakit");
				return;
			}
			
			data.updateMasterObat(
						new DaftarObat(view.getObat().getKodeObat(), 
								NAMA_OBAT, 
								JENIS_OBAT, 
								DOSIS, 
								SATUAN, 
								PENYAKIT, 
								JUMLAH_PER_PACK, 
								HARGA_PER_PACK, 
								HARGA_PER_SATUAN, 
								KODE_SUPPLIER)
					);
			
			reusableMethod.showAlert(AlertType.INFORMATION, "Update", "Obat Data Updated!");
			data.refreshMasterObat(view.getView().getTableObat());
			Stage stage = view.getStage();
			stage.close();
		});
	}
	
	
	
}
