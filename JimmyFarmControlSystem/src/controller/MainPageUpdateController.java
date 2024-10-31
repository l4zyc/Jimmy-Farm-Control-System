package controller;

import java.sql.Date;
import java.time.LocalDate;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.CatatanHarianUtama;
import util.Data;
import util.reusableMethod;
import view.MainPageInputDataView;
import view.MainPageUpdateView;

public class MainPageUpdateController {
	
	private MainPageUpdateView view;
	private Data data = new Data();

	public MainPageUpdateController(MainPageUpdateView mainPageUpdateView) {
		this.view = mainPageUpdateView;
		setOnActionEvent();
	}
	
	public void setOnActionEvent() {
		view.getSave().setOnAction(e -> {
			String ID = view.getKodeKandang().getText();
			String KODE = view.getKodeKandang().getText(); 
			String LOKASI = view.getLokasi().getText();
			String KETERANGAN = "";
			LocalDate DATE_ = view.getTanggalMasuk().getValue();
			Date DATE = Date.valueOf(DATE_);
			Integer JumlahJantan = Integer.parseInt(view.getJumlahAwalJantan().getText()); 
			Integer JumlahBetina = Integer.parseInt(view.getJumlahAwalBetina().getText());
			String KOMENTAR = view.getKomentar().getText();
			
			data.updateCatatanHarianData(new CatatanHarianUtama(LOKASI, KODE, DATE, KETERANGAN, JumlahJantan, JumlahBetina, KOMENTAR));
			reusableMethod.showAlert(AlertType.INFORMATION, "Update", "Value Updated!");
			refreshTable(view.getView().getTable());
			
			Stage stage = view.getStage();
			stage.close();
		});
	}
	
	public void refreshTable(TableView<CatatanHarianUtama> catatan) {
		catatan.getItems().clear();
		catatan.setItems(data.getCatatanHarian());
	}
	
}
