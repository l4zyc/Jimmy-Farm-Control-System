package controller.mainPage;

import java.sql.Date;
import java.time.LocalDate;

import controller.ControllerData;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.CatatanHarianUtama;
import util.Data;
import util.reusableMethod;
import view.MainPage.MainPageInputDataView;
import view.MainPage.MainPageUpdateView;

public class MainPageUpdateController extends ControllerData{
	
	private MainPageUpdateView view;

	public MainPageUpdateController(MainPageUpdateView mainPageUpdateView) {
		this.view = mainPageUpdateView;
		setOnActionEvent();
	}
	
	public void setOnActionEvent() {
		view.getSave().setOnAction(e -> { 
			String KODE_CATATAN = view.getKodeCatatanTF().getText(); 
			String KODE_KANDANG = view.getKodeKandang().getValue().toString(); 
			String KETERANGAN = view.getKeteranganJenisTF().getText();  
			LocalDate DATE_ = view.getTanggalMasuk().getValue();
			Date DATE = Date.valueOf(DATE_); 
			Integer JumlahJantan, JumlahBetina; 
			try {
				JumlahBetina = Integer.parseInt(view.getJumlahAwalBetina().getText().trim()); 
				JumlahJantan = Integer.parseInt(view.getJumlahAwalJantan().getText().trim());  
									
				if(JumlahBetina < 0 || JumlahJantan < 0) { 
					reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Awal Betina and Jantan must be non-negative numbers.");
			        return;
				}
			} catch (Exception e1) {
				// TODO: handle exception 
				 reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Jumlah Awal Betina and Jantan must be whole numbers.");
				 return;
			}
			
			if(KETERANGAN.isEmpty()) { 
				 reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Please input keterangan jenis.");
				 return;
			}
			
			String KOMENTAR = view.getKomentar().getText(); 
			
			if(KOMENTAR.isEmpty()) { 
				reusableMethod.showAlert(AlertType.ERROR, "Invalid Input", "Please input komentar.");
				 return;
			}
			
			data.updateCatatanHarianData(new CatatanHarianUtama(KODE_CATATAN, DATE, KODE_KANDANG, KETERANGAN, JumlahJantan, JumlahBetina, KOMENTAR));
			reusableMethod.showAlert(AlertType.INFORMATION, "Update", "Value Updated!");
			data.refreshCatatanHarianUtamaTable(view.getView().getTable());
			
			Stage stage = view.getStage();
			stage.close();
		});
	}
	
	
}
