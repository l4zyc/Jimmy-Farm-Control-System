package controller.detailCatatan;

import controller.ControllerData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.CatatanHarianDetail;
import model.CatatanHarianUtama;
import util.Connect;
import view.CatatanDetail.DetailCatatanInputView;

public class DetailCatatanInputController extends ControllerData{ 
	
	private DetailCatatanInputView view; 
	private Connect connect = Connect.getInstance(); 
	
	public DetailCatatanInputController(DetailCatatanInputView detailcatataninputview) { 
		this.view = detailcatataninputview; 
	
		SetOnActionSave();
	}

	
	protected void SetOnActionSave() { 
		view.getSave().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Integer KematianJantan = Integer.parseInt(view.getKematianJantanTF().getText().trim()); 
				Integer KematianBetina = Integer.parseInt(view.getKematianBetinaTF().getText().trim()); 
				String KodePakan = view.getKodePakanCB().getValue().toString(); 
				Integer JumlahPakan = Integer.parseInt(view.getJumlahPakanTF().getText().trim()); 
				String KodeObat = view.getKodeObatCB().getValue().toString(); 
				Integer JumlahObat = Integer.parseInt(view.getJumlahObatTF().getText().trim()); 
				Integer JumlahProduksiTelur = Integer.parseInt(view.getJumlahProduksiTelurTF().getText().trim()); 
				Integer BiayaVariable = Integer.parseInt(view.getBiayaVariabelTF().getText().trim()); 
				String KomentarKematian = view.getKomentar().getValue().toString();
				
				CatatanHarianUtama baseData = data.getSpecificCatatanHarian(view.getView().getKode());
				
				CatatanHarianDetail CHD = new CatatanHarianDetail(
							baseData.getKodeCatatan(),
							baseData.getTanggalMasuk(),
							KematianJantan,
							KematianBetina,
							KodePakan,
							JumlahPakan.toString(),
							KodeObat,
							JumlahObat.toString(),
							JumlahProduksiTelur.toString(),
							BiayaVariable.toString(),
							KomentarKematian
						); 
				
				data.insertCatatanHarianDetail(CHD); 
				
				data.refreshTableCatatanHarianDetail(view.getView().getTable(), baseData.getKodeCatatan()); 
				
				Stage stage = (Stage) view.getBp().getScene().getWindow();
				stage.close();
				
			}  
			
			
		});
		
		
	}
	
}
