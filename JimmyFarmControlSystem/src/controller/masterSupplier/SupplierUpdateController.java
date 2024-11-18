package controller.masterSupplier;

import controller.ControllerData;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.DaftarSupplier;
import util.reusableMethod;
import view.MasterSupplier.SupplierUpdateView;

public class SupplierUpdateController extends ControllerData{
	private SupplierUpdateView view;
	public SupplierUpdateController(SupplierUpdateView view) {
		this.view = view;
		setOnAction();
	} 
	
	public void setOnAction() {
		view.getSave().setOnAction(e -> {
			String NAMA_SUPPLIER = view.getNamaSupplierTF().getText();
			
			if(NAMA_SUPPLIER.isEmpty()) { 
				reusableMethod.showAlert(AlertType.ERROR, "Error", "Please input nama supplier");
				return; 
			} 
			
			data.updateMasterSupplier( 
						new DaftarSupplier(view.getSupplier().getKodeSupplier(), 
								NAMA_SUPPLIER));
					
			
			reusableMethod.showAlert(AlertType.INFORMATION, "Update", "Supplier Data Updated!"); 
			data.refreshMasterSupplier(view.getView().getTableSupplier());
			Stage stage = view.getStage();
			stage.close();
		});
	}

}
