package controller.masterPakan;

import controller.ControllerData;
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
			String NAMA_PAKAN = view.getNamaPakanTF().getText();  
			String JENIS_PAKAN = view.getJenisPakanCB().getValue().toString();  
			Integer HARGA = Integer.parseInt(view.getHargaTF().getText());
			
			data.updateMasterPakan( 
						new DaftarPakan(KODE_PAKAN, NAMA_PAKAN, 
								JENIS_PAKAN, HARGA));
			
			reusableMethod.showAlert(AlertType.INFORMATION, "Update", "Pakan Data Updated!");  
			data.refreshTablePakan(view.getView().getTablePakan());
			Stage stage = view.getStage();
			stage.close();
		});
	}
	
}
