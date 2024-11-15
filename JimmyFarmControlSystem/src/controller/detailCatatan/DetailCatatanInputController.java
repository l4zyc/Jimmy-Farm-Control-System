package controller.detailCatatan;

import controller.ControllerData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.CatatanHarianDetail;
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
				String KodePakan = view.getKodeObatCB().getValue().toString(); 
				Integer JumlahPakan = Integer.parseInt(view.getJumlahPakanTF().getText().trim()); 
				String KodeObat = view.getKodeObatCB().getValue().toString(); 
				Integer JumlahObat = Integer.parseInt(view.getJumlahObatTF().getText().trim()); 
				Integer JumlahProduksiTelur = Integer.parseInt(view.getJumlahProduksiTelurTF().getText().trim()); 
				Integer BiayaVariable = Integer.parseInt(view.getBiayaVariabelTF().getText().trim()); 
				String KomentarKematian = view.getKomentarKematianTA().getText(); 
				
				CatatanHarianDetail CHD = new CatatanHarianDetail(KematianJantan, 
						KematianBetina, 
						KodePakan, 
						JumlahPakan, 
						KodeObat, 
						JumlahObat, 
						JumlahProduksiTelur, 
						BiayaVariable, 
						KomentarKematian); 
				
				data.insertCatatanHarianDetail(CHD); 
				
				view.getKematianJantanTF().setText(null); 
				view.getKematianBetinaTF().setText(null); 
				view.getKodePakanCB().setValue(null); 
				view.getJumlahPakanTF().setText(null); 
				view.getKodeObatCB().setValue(null); 
				view.getJumlahObatTF().setText(null); 
				view.getJumlahProduksiTelurTF().setText(null); 
				view.getBiayaVariabelTF().setText(null); 
				view.getKomentarKematianTA().setText(null); 
				
				//data.refreshTableCatatanHarianDetail(view.getView(), CHD); 
				
				
				Stage stage = (Stage) view.getBp().getScene().getWindow();
				stage.close();
				
			}  
			
			
		});
		
		
	}
	
}
