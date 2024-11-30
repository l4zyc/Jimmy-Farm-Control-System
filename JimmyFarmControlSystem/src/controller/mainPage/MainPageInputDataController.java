package controller.mainPage;
import java.util.ArrayList;

import controller.ControllerData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
import model.CatatanHarianUtama;
import model.MsKandang;
import util.Connect;
import util.Data;
import util.reusableMethod;
import view.MainPage.MainPageInputDataView;

import java.sql.Date;
import java.time.LocalDate;

public class MainPageInputDataController extends ControllerData{
	
	private MainPageInputDataView view; 
	private Connect connect = Connect.getInstance();
	
	public MainPageInputDataController(MainPageInputDataView mainpageinputdataview) { 
		this.view = mainpageinputdataview; 
		SetOnActionSave();
	} 
	
	protected void SetOnActionSave() { 
		view.getSave().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				try {
					String KodeKandang = view.getKodeKandangCB().getValue().toString();
					
					if(KodeKandang.isEmpty()) { 
						reusableMethod.showAlert(AlertType.ERROR, "Error", "Please Insert Kode Kandang");
						return;
					}
					
					if(!kodeKandanginList(KodeKandang)) {//it have to exist 
						reusableMethod.showAlert(AlertType.ERROR, "Error", "Kode Kandang Does Not Exist");
						return;
					}  
					
					if(!kodeKandangUnique(KodeKandang)) { 
						reusableMethod.showAlert(AlertType.ERROR, "Error", "Kode Kandang Already been used");
						return; 
					}
					
					LocalDate dateConv = view.getTanggalMasuk().getValue();//perlu validasi di bagian date
					
					if(dateConv == null) { 
						reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Please input a date please");
				        return;
					}
					
					Date date = Date.valueOf(dateConv); 
					
					String KeteranganJenis = view.getKeteranganJenis().getText();   
					Integer JumlahAwalBetina, JumlahAwalJantan;
					try {
						JumlahAwalBetina = Integer.parseInt(view.getJumlahAwalBetina().getText().trim()); 
						JumlahAwalJantan = Integer.parseInt(view.getJumlahAwalJantan().getText().trim());  
											
						if(JumlahAwalBetina < 0 || JumlahAwalJantan < 0) { 
							reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Awal Betina and Jantan must be non-negative numbers.");
					        return;
						}
					} catch (Exception e) {
						// TODO: handle exception 
						 reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Awal Betina and Jantan must be whole numbers.");
						 return;
					}
					
					String Komentar = view.getKomentar().getText();
					String kodeCatatan = data.getNewkodeCatatan();
				
					if(Komentar.isEmpty()) { 
						reusableMethod.showAlert(AlertType.ERROR, "Error", "Please Insert Komentar");
						return;
					}
					
					if(KeteranganJenis.isEmpty()) { 
						reusableMethod.showAlert(AlertType.ERROR, "Error", "Please Insert Keterangan Jenis");
						return;
					}
					
					
					
					CatatanHarianUtama chu = new CatatanHarianUtama(kodeCatatan, date, KodeKandang, KeteranganJenis, JumlahAwalJantan, JumlahAwalBetina, Komentar);
					
					data.insertCatatanHarianUtama(chu);
					
					view.getKodeKandangCB().setValue(null);
					view.getKeteranganJenis().setText("");
					view.getTanggalMasuk().setValue(null);
					view.getJumlahAwalBetina().setText("");
					view.getJumlahAwalJantan().setText("");
					view.getKomentar().setText("");
					data.refreshCatatanHarianUtamaTable(view.getView().getTable());
					
					Stage stage = (Stage) view.getBp().getScene().getWindow();
					stage.close();	
				} catch(Exception e) {
					reusableMethod.showAlert(AlertType.ERROR, "Error", "Input All Data!");
				}
			}  
			
		});
	} 
	
	public boolean kodeKandanginList(String KodeKandang) {
		ObservableList<MsKandang> kandang = data.getMasterKandangData();
		
		for (MsKandang mskandang : kandang) {
			if((mskandang.getKodeKandang().equals(KodeKandang))) {
				return true;
			}
		}
		
		reusableMethod.showAlert(AlertType.ERROR, "Data", String.format("%s Does not exist", KodeKandang));
		return false;
	} 
	
	public boolean kodeKandangUnique(String KodeKandang) { 
		ObservableList<CatatanHarianUtama> CatatanHarian = data.getCatatanHarian(); 
		
		for (CatatanHarianUtama CH : CatatanHarian) { 
			if(CH.getKodeKandang().equals(KodeKandang)) { 
				return false;
			}
		}
		return true;
	}
	
}
