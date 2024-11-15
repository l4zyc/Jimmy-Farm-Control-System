package controller.detailCatatan;

import controller.ControllerData;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.CatatanHarianDetail;
import model.DaftarObat;
import util.reusableMethod;
import view.MasterObat.ObatUpdateView; 
import view.CatatanDetail.DetailCatatanUpdateView;

public class DetailCatatanUpdateController extends ControllerData{

	private DetailCatatanUpdateView view;
	
	public DetailCatatanUpdateController(DetailCatatanUpdateView view) { 
		this.view = view;
	} 
	
	public void setOnAction() {
		view.getSave().setOnAction(e -> {
			
			Integer KematianJantan = Integer.parseInt(view.getKematianJantanTF().getText().trim()); 
			Integer KematianBetina = Integer.parseInt(view.getKematianBetinaTF().getText().trim()); 
			String KodePakan = view.getKodeObatCB().getValue().toString(); 
			Integer JumlahPakan = Integer.parseInt(view.getJumlahPakanTF().getText().trim()); 
			String KodeObat = view.getKodeObatCB().getValue().toString(); 
			Integer JumlahObat = Integer.parseInt(view.getJumlahObatTF().getText().trim()); 
			Integer JumlahProduksiTelur = Integer.parseInt(view.getJumlahProduksiTelurTF().getText().trim()); 
			Integer BiayaVariable = Integer.parseInt(view.getBiayaVariabelTF().getText().trim()); 
			String KomentarKematian = view.getKomentarKematianTA().getText(); 
			
			//data.updateCatatanHarianDetail( 
					//new CatatanHarianDetail()); 
			
			reusableMethod.showAlert(AlertType.INFORMATION, "Update", "Obat Data Updated!");
			//data.refreshMasterObat();
			Stage stage = view.getStage();
			stage.close();
		});
	}
	
}
