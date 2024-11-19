package controller.masterPakan;

import controller.ControllerData;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.DaftarPakan;
import util.reusableMethod;
import view.MasterPakan.PakanUpdateView;

public class PakanUpdateController extends ControllerData{

	private PakanUpdateView view;
	
	public PakanUpdateController(PakanUpdateView view) {
		this.view = view;
		setOnAction();
	} 
	
	public void setOnAction() {
		view.getSave().setOnAction(e -> { 
			String KODE_PAKAN = view.getKodePakanTF().getText();  
			
			if(KODE_PAKAN.isEmpty()) { 
				reusableMethod.showAlert(AlertType.ERROR, "Error", "Please insert kode pakan");
				return;
			}
			
			String NAMA_PAKAN = view.getNamaPakanTF().getText(); 
			
			if(NAMA_PAKAN.isEmpty()) { 
				reusableMethod.showAlert(AlertType.ERROR, "Error", "Please insert nama pakan");
				return;
			}
			 
			String JENIS_PAKAN = view.getJenisPakanCB().getValue().toString();  
			
			Integer HARGA;
			 try {
			        HARGA = Integer.parseInt(view.getHargaTF().getText().trim());
			        if (HARGA < 0) {
			        	reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Awal Betina and Jantan must be non-negative numbers.");
				        return;
			        }
			} catch (NumberFormatException e1) {
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Awal Betina and Jantan must be whole numbers.");
		        return;
			}
			 
			String KODE_SUPPLIER = view.getKodeSupplier().getValue().toString();
			
			data.updateMasterPakan( 
						new DaftarPakan(KODE_PAKAN, NAMA_PAKAN, 
								JENIS_PAKAN, HARGA, KODE_SUPPLIER));
			
			reusableMethod.showAlert(AlertType.INFORMATION, "Update", "Pakan Data Updated!");  
			data.refreshTablePakan(view.getView().getTablePakan());
			Stage stage = view.getStage();
			stage.close();
		});
	}
	
	
	
}
