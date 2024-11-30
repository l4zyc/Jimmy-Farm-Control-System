package controller.detailCatatan;

import java.sql.Date;
import java.time.LocalDate;

import controller.ControllerData;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.CatatanHarianDetail;
import model.CatatanHarianUtama;
import model.DaftarObat;
import util.reusableMethod;
import view.MasterObat.ObatUpdateView; 
import view.CatatanDetail.DetailCatatanUpdateView;

public class DetailCatatanUpdateController extends ControllerData{

	private DetailCatatanUpdateView view;
	
	public DetailCatatanUpdateController(DetailCatatanUpdateView view) { 
		this.view = view;
		setOnAction();
	} 
	
	public void setOnAction() {
		
		view.getSave().setOnAction(e -> {
			Integer KematianJantan = 0,  
					KematianBetina = 0, 
					PenjualanJantan = 0, 
					PenjualanBetina = 0, 
					AfkirJantan = 0,  
					AfkirBetina = 0, 
					PindahJantan = 0,  
					PindahBetina = 0, 
					JumlahPakan = 0, 
					JumlahObat = 0, 
					JumlahProduksiTelur = 0, 
					BiayaVariable = 0; 
			String KodePakan = null;
			String KodeObat = null;  
			String KomentarKematian = null;
			
			try {
				if(view.getKematianJantanTF().getText().trim().isEmpty() &&
						view.getKematianBetinaTF().getText().trim().isEmpty() &&
						view.getPenjualanJantanTF().getText().trim().isEmpty() && 
						view.getPenjualanBetinaTF().getText().trim().isEmpty() && 
						view.getAfkirJantanTF().getText().trim().isEmpty() && 
						view.getAfkirBetinaTF().getText().trim().isEmpty() && 
						view.getPindahJantanTF().getText().trim().isEmpty() && 
						view.getPindahBetinaTF().getText().trim().isEmpty() && 
						view.getKodePakanCB().getValue().toString().isEmpty() && 
						view.getJumlahPakanTF().getText().trim().isEmpty() && 
						view.getKodeObatCB().getValue().toString().isEmpty() && 
						view.getJumlahObatTF().getText().trim().isEmpty() && 
						view.getJumlahProduksiTelurTF().getText().trim().isEmpty() && 
						view.getBiayaVariabelTF().getText().trim().isEmpty() && 
						view.getKomentar().getValue().toString().isEmpty()) {  
						
					reusableMethod.showAlert(AlertType.ERROR, "Please Input Data", "You have to input all data");
			        return;
				}
			} catch(Exception ex) {
				reusableMethod.showAlert(AlertType.ERROR, "Error", "");
			}
			
			
			if(KematianJantan == null || KematianBetina == null) { 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Kematian Betina and Jantan please input data");
		        return;
			} 
			
			if(PenjualanJantan == null || PenjualanBetina == null) { 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Penjualan Betina and Jantan please input data");
		        return;
			}
			
			if(AfkirJantan == null || AfkirBetina == null) { 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Afkir Betina and Jantan please input data");
		        return;
			} 
			
			if(PindahJantan == null || PindahBetina == null) { 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Pindah Betina and Jantan please input data");
		        return;
			}
			
			try {
				KematianJantan = Integer.parseInt(view.getKematianJantanTF().getText().trim()); 
				KematianBetina = Integer.parseInt(view.getKematianBetinaTF().getText().trim());  
				if(KematianBetina < 0 || KematianJantan < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Kematian Betina and Jantan must be non-negative numbers.");
			        return;
				}
				
			} catch (Exception e1) {
				// TODO: handle exception 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Kematian Betina and Jantan must be whole numbers.");
				 return;
			}
			
		
			try {
				PenjualanJantan = Integer.parseInt(view.getPenjualanJantanTF().getText().trim()); 
				PenjualanBetina = Integer.parseInt(view.getPenjualanBetinaTF().getText().trim());  
				if(PenjualanJantan < 0 || PenjualanBetina < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Penjualan Betina and Jantan must be non-negative numbers.");
			        return;
				}
				
			} catch (Exception e1) {
				// TODO: handle exception 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Penjualan Betina and Jantan must be whole numbers.");
				 return;
			}
			
		
			try {
				AfkirJantan = Integer.parseInt(view.getAfkirJantanTF().getText().trim()); 
				AfkirBetina = Integer.parseInt(view.getAfkirBetinaTF().getText().trim());  
				if(AfkirJantan < 0 || AfkirBetina < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Afkir Betina and Jantan must be non-negative numbers.");
			        return;
				}
				
			} catch (Exception e1) {
				// TODO: handle exception 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Afkir Betina and Jantan must be whole numbers.");
				 return;
			} 
			
			
			try {
				PindahJantan = Integer.parseInt(view.getPindahJantanTF().getText().trim()); 
				PindahBetina = Integer.parseInt(view.getPindahBetinaTF().getText().trim());  
				} catch (Exception e1) {
				// TODO: handle exception 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Pindah Betina and Jantan must be whole numbers.");
				 return;
			}
			 
			KodePakan = view.getKodePakanCB().getValue().toString();
			
			 
			try {
				JumlahPakan = Integer.parseInt(view.getJumlahPakanTF().getText().trim());  
				if(JumlahPakan < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Pakan must be non-negative numbers.");
			        return;
				}
				
			} catch (Exception e1) {
				// TODO: handle exception 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Pakan must be whole numbers.");
				 return;
			}
			KodeObat = view.getKodeObatCB().getValue().toString();  
		
			try {
				JumlahObat = Integer.parseInt(view.getJumlahObatTF().getText().trim());  
				if(JumlahObat < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Obat must be non-negative numbers.");
			        return;
				}
				
			} catch (Exception e1) {
				// TODO: handle exception 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Obat must be whole numbers.");
				 return;
			} 
			
			try {
				JumlahProduksiTelur = Integer.parseInt(view.getJumlahProduksiTelurTF().getText().trim()); 
				if(JumlahProduksiTelur < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Produksi Telur must be non-negative numbers.");
			        return;
				}
				
			} catch (Exception e1) {
				// TODO: handle exception 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Produksi Telur must be whole numbers.");
				 return;
			}
			
			  
			try {
				BiayaVariable = Integer.parseInt(view.getBiayaVariabelTF().getText().trim());
				if(BiayaVariable < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Biaya Variable must be non-negative numbers.");
			        return;
				}
				
			} catch (Exception e1) {
				// TODO: handle exception 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Biaya Variable must be whole numbers.");
				 return;
			}
			KomentarKematian = view.getKomentar().getValue().toString();
			String KODE_CATATAN = view.getView().getKode(); 
			
			LocalDate dateConv = view.getDate().getValue();
			Date date = Date.valueOf(dateConv);  
			
			if(KodePakan.isEmpty()) { 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Kode Pakan must not be empty");
				return;
			} 
			
			if(KomentarKematian.isEmpty()) {
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Komentar Kematian must not be empty");
				return;
			}
			
			CatatanHarianDetail basisData = data.getSpecificCatatanHarianDetail(KODE_CATATAN, date);
			data.updateCatatanHarianDetail(new CatatanHarianDetail(
						basisData.getKodeCatatan(),
						basisData.getTanggalCatatan(),
						KematianJantan, 
						KematianBetina, 
						KodePakan,
						JumlahPakan.toString(),
						KodeObat,
						JumlahObat.toString(),
						JumlahProduksiTelur.toString(),
						BiayaVariable.toString(),
						KomentarKematian, 
						PenjualanJantan, 
						AfkirJantan, 
						PindahJantan,
						PenjualanBetina, 
						AfkirBetina, 
						PindahBetina
					));
			
			reusableMethod.showAlert(AlertType.INFORMATION, "Update", "Data Updated!");
			data.refreshTableCatatanHarianDetail(view.getView().getTable(), KODE_CATATAN);
			Stage stage = view.getStage();
			stage.close();
		});
	}
	
}
