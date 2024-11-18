package controller.masterKandang;

import controller.ControllerData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.MsKandang;
import util.reusableMethod;
import view.MasterKandang.KandangInputView;

public class KandangInputController extends ControllerData{
	KandangInputView view;
	
	public KandangInputController(KandangInputView view) {
		this.view = view;
		setOnActionSave();
	} 
	
	public void setOnActionSave() {
		view.getSave().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String KODE_KANDANG = data.getNewkodeKandang();
				String LOKASI = view.getLokasiTF().getText();
				
				if(LOKASI.isEmpty()) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Lokasi must not be empty");
					return;
				}
				
				MsKandang object_kandang = new MsKandang(KODE_KANDANG, LOKASI);
				
				data.insertMasterKandang(object_kandang);
		
				data.refreshMasterKandang(view.getView().getTableKandang());
				
				Stage stage = (Stage) view.getBp().getScene().getWindow();
				stage.close();
			}
		});
	}

}
