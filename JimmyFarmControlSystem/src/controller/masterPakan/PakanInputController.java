package controller.masterPakan;

import controller.ControllerData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.DaftarPakan; 
import model.MsKandang;
import util.reusableMethod;
import view.MasterPakan.PakanInputView;

public class PakanInputController extends ControllerData{
	
	private PakanInputView view;

	public PakanInputController(PakanInputView view) {
		this.view = view;
		setOnAction();
	}
	//Experimental system
	public void setOnAction() {
		view.getSave().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) { 
				
				String KODE_PAKAN = view.getKodePakanTF().getText();  
				
				if(KODE_PAKAN.isEmpty()) { 
					reusableMethod.showAlert(AlertType.ERROR, "Error", "Please insert kode pakan");
					return;
				}
				
				if(!KodePakanUnique(KODE_PAKAN)) { 
					reusableMethod.showAlert(AlertType.ERROR, "Error", "Kode Pakan Already been used");
					return;
				}
				
				
				String NAMA_PAKAN = view.getNamaPakanTF().getText(); 
				
				if(NAMA_PAKAN.isEmpty()) { 
					reusableMethod.showAlert(AlertType.ERROR, "Error", "Please insert nama pakan");
					return;
				}
				
				if(!NamaPakanUnique(NAMA_PAKAN)) { 
					reusableMethod.showAlert(AlertType.ERROR, "Error", "nama Pakan Already been used");
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
				} catch (NumberFormatException e) {
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Awal Betina and Jantan must be whole numbers.");
			        return;
				}
				 
				String KODE_SUPPLIER = view.getKodeSupplier().getValue().toString();
				
				DaftarPakan pakan = new DaftarPakan(KODE_PAKAN, NAMA_PAKAN, JENIS_PAKAN, HARGA, KODE_SUPPLIER);
			
				
				data.insertMasterPakan(pakan); 
				data.refreshTablePakan(view.getView().getTablePakan());
				
				Stage stage = (Stage) view.getBp().getScene().getWindow();
				stage.close();
			}
		});
	}
	
	public boolean KodePakanUnique(String KodePakan) { 
		ObservableList<DaftarPakan> DaftarPakan = data.getMasterPakanData(); 
		
		for(DaftarPakan DP : DaftarPakan) { 
			if(DP.getKodePakan().equals(KodePakan)) { 
				return false;
			}
		}
			
			return true;
	}
	
	public boolean NamaPakanUnique(String NamaPakan) { 
		ObservableList<DaftarPakan> DaftarPakan = data.getMasterPakanData(); 
		
		for(DaftarPakan DP : DaftarPakan) { 
			if(DP.getNamaPakan().equals(NamaPakan)) { 
				return false;
			}
		}
			
			return true;
	}
	
}
