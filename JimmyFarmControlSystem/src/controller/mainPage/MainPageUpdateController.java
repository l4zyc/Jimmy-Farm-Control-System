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
			String KODE_KANDANG = view.getKodeKandang().getText();
			String KODE_CATATAN = view.getKodeCatatanTF().getText(); 
			String KETERANGAN = view.getKeteranganJenisTF().getText();
			LocalDate DATE_ = view.getTanggalMasuk().getValue();
			Date DATE = Date.valueOf(DATE_);
			Integer JumlahJantan = Integer.parseInt(view.getJumlahAwalJantan().getText()); 
			Integer JumlahBetina = Integer.parseInt(view.getJumlahAwalBetina().getText());
			String KOMENTAR = view.getKomentar().getText();
			
			data.updateCatatanHarianData(new CatatanHarianUtama(KODE_CATATAN, DATE, KODE_KANDANG, KETERANGAN, JumlahJantan, JumlahBetina, KOMENTAR));
			reusableMethod.showAlert(AlertType.INFORMATION, "Update", "Value Updated!");
			data.refreshCatatanHarianUtamaTable(view.getView().getTable());
			
			Stage stage = view.getStage();
			stage.close();
		});
	}
	
	
}
