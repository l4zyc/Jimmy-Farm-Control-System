package controller.masterObat;

import controller.ControllerData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.CatatanHarianUtama;
import model.DaftarObat;
import util.Data;
import util.reusableMethod;
import view.MasterObat.ObatInputView;

public class MasterObatInputController extends ControllerData {
	
	ObatInputView view;
	
	public MasterObatInputController(ObatInputView view) {
		this.view = view;
		setOnActionSave();
	}
	
	public void setOnActionSave() {
		view.getSave().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				try {
					String KODE_OBAT = data.getNewkodeObat(); 
					String NAMA_OBAT = view.getNamaObatTF().getText(); 
					String JENIS_OBAT = view.getJenisObatCB().getValue().toString();
					Integer DOSIS; 
					try {
						DOSIS = Integer.parseInt(view.getDosisTF().getText());  
						if(DOSIS < 0) { 
							reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Dosis must be non-negative numbers.");
					        return; 
						}
					} catch (Exception e) {
						// TODO: handle exception 
						reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Dosis must be whole numbers.");
						return;
					} 
					
					String SATUAN = view.getSatuanCB().getValue().toString(); 
					String PENYAKIT = view.getPenyakitTF().getText(); 
					Integer JUMLAH_PER_PACK; 
					try {
						JUMLAH_PER_PACK = Integer.parseInt(view.getJumlahPerPackTF().getText());  
						
						if(JUMLAH_PER_PACK < 0) { 
							reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Per Pack must be non-negative numbers.");
					        return; 
						}
					} catch (Exception e) {
						// TODO: handle exception 
						reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Per Pack must be whole numbers.");
						return;
					}
					Integer HARGA_PER_PACK; 
					try {
						HARGA_PER_PACK = Integer.parseInt(view.getHargaPerPackTF().getText());  
						if(HARGA_PER_PACK < 0) { 
							reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Harga per pack must be non-negative numbers.");
					        return; 
						}
					} catch (Exception e) {
						// TODO: handle exception 
						reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Harga per pack must be whole numbers.");
						return;
					}
					Integer HARGA_PER_SATUAN; 
					try {
						HARGA_PER_SATUAN = Integer.parseInt(view.getHargaPerSatuanTF().getText()); 
						if(HARGA_PER_SATUAN < 0) { 
							reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Harga per satuan must be non-negative numbers.");
					        return; 
						}
					} catch (Exception e) {
						// TODO: handle exception
						reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Harga per satuan must be whole numbers.");
						return;
					}
					
					if(NAMA_OBAT.isEmpty()) { 
						reusableMethod.showAlert(AlertType.ERROR, "Error", "Please Insert Nama Obat");
						return;
					}
					
					if(!NamaObatUnique(NAMA_OBAT)) { 
						reusableMethod.showAlert(AlertType.ERROR, "Error", "Nama obat Already been used");
						return; 
					}
					
					if(PENYAKIT.isEmpty()) { 
						reusableMethod.showAlert(AlertType.ERROR, "Error", "Please Insert Penyakit");
						return;
					}
					
					String KODE_SUPPLIER = view.getKodeSupplier().getValue().toString();
					
					DaftarObat Object_Obat = new DaftarObat(KODE_OBAT, NAMA_OBAT, JENIS_OBAT, DOSIS, SATUAN,
							PENYAKIT, JUMLAH_PER_PACK, HARGA_PER_PACK, HARGA_PER_SATUAN, KODE_SUPPLIER);
					
					data.insertMasterObat(Object_Obat);
					
					data.refreshMasterObat(view.getView().getTableObat());
					
					Stage stage = (Stage) view.getBp().getScene().getWindow();
					stage.close();
				} catch(Exception e) {
					reusableMethod.showAlert(AlertType.ERROR, "Error", "Input All Data !");
				}
			}
		});
	} 
	
	public boolean NamaObatUnique(String NamaObat) { 
		ObservableList<DaftarObat> Obat = data.getObatData(); 
		
		for (DaftarObat O : Obat) { 
			if(O.getNamaObat().equals(NamaObat)) { 
				return false;
			}
		}
		return true;
	}
}


