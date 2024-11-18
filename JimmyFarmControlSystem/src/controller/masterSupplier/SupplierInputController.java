package controller.masterSupplier;

import controller.ControllerData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.DaftarObat;
import model.DaftarSupplier;
import util.Data;
import util.reusableMethod;
import view.MasterSupplier.SupplierInputView;

public class SupplierInputController extends ControllerData {

	SupplierInputView view;
	
	public SupplierInputController(SupplierInputView view) {
		this.view = view;
		setOnActionSave();
	}
	
	public void setOnActionSave() {
		view.getSave().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String KODE_SUPPLIER = data.getNewkodeSupplier();
				String NAMA_SUPPLIER = view.getNamaSupplierTF().getText();
				
				if(NAMA_SUPPLIER.isEmpty()) { 
					reusableMethod.showAlert(AlertType.ERROR, "Error", "Please input nama supplier");
					return; 
				} 
				
				if(!NamaSupplierUnique(NAMA_SUPPLIER)) { 
					reusableMethod.showAlert(AlertType.ERROR, "Error", "Nama supplier Already been used");
					return; 
				}
				
				DaftarSupplier Object_Supplier = new DaftarSupplier(KODE_SUPPLIER, NAMA_SUPPLIER);
				
				data.insertMasterSupplier(Object_Supplier);
	
				data.refreshMasterSupplier(view.getView().getTableSupplier());

				
				Stage stage = (Stage) view.getBp().getScene().getWindow();
				stage.close();
			}
		});
	} 
	
	public boolean NamaSupplierUnique(String NamaObat) { 
		ObservableList<DaftarObat> Obat = data.getObatData(); 
		
		for (DaftarObat O : Obat) { 
			if(O.getNamaObat().equals(NamaObat)) { 
				return false;
			}
		}
		return true;
	}

}
