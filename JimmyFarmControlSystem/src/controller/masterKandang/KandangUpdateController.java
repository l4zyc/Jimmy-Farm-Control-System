package controller.masterKandang;

import controller.ControllerData;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.MsKandang;
import util.reusableMethod;
import view.MasterKandang.KandangUpdateView;

public class KandangUpdateController extends ControllerData{

	private KandangUpdateView view;
	
	public KandangUpdateController(KandangUpdateView view) {
		this.view = view;
		setOnAction();
	} 
	
	public void setOnAction() {
		view.getSave().setOnAction(e -> { 
			String KODE_KANDANG = view.getKodeKandangTF().getText();
			String LOKASI = view.getLokasiTF().getText();
			
			data.updateMasterKandang( 
					new MsKandang(KODE_KANDANG, LOKASI)
					);
	
			reusableMethod.showAlert(AlertType.INFORMATION, "Update", "Kandang Data Updated!"); 
			data.refreshMasterKandang(view.getView().getTableKandang());
			Stage stage = view.getStage();
			stage.close();
		});
	}

}
