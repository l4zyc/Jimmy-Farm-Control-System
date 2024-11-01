package controller;
import java.util.ArrayList;

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
import util.Connect;
import util.Data;
import util.reusableMethod;
import view.MainPageInputDataView;
import java.sql.Date;
import java.time.LocalDate;

public class MainPageInputDataController {
	
	private MainPageInputDataView view; 
	private Connect connect = Connect.getInstance();
	private Data data = new Data();
	
	public MainPageInputDataController(MainPageInputDataView mainpageinputdataview) { 
		this.view = mainpageinputdataview; 
		SetOnActionSave();
	} 
	
	protected void SetOnActionSave() { 
		view.getSave().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String KodeKandang = view.getKodeKandang().getText();
				String Lokasi = view.getLokasi().getText();
				String KeteranganJenis = view.getKeteranganJenis().getText();  
				LocalDate dateConv = view.getTanggalMasuk().getValue();
				Date date = Date.valueOf(dateConv);
				Integer JumlahAwalBetina = Integer.parseInt(view.getJumlahAwalBetina().getText());
				Integer JumlahAwalJantan = Integer.parseInt(view.getJumlahAwalJantan().getText()); 
				String Komentar = view.getKomentar().getText();
				
				CatatanHarianUtama chu = new CatatanHarianUtama(KodeKandang, Lokasi, date, KeteranganJenis, JumlahAwalJantan, JumlahAwalBetina, Komentar);
				
				insertCatatanHarianUtama(chu);
				
				view.getKodeKandang().setText("");
				view.getLokasi().setText("");
				view.getKeteranganJenis().setText("");
				view.getTanggalMasuk().setValue(null);
				view.getJumlahAwalBetina().setText("");
				view.getJumlahAwalJantan().setText("");
				view.getKomentar().setText("");
				
				refreshTable(view.getView().getTable());
				
				Stage stage = (Stage) view.getBp().getScene().getWindow();
				stage.close();
			} 
			
		});
	} 
	
	protected void insertCatatanHarianUtama(CatatanHarianUtama catatanharianutama) {
	    String query = String.format("INSERT INTO CatatanHarianUtama VALUES ('%s', '%s', '%s', '%s', '%d', '%d', '%s')",
	            catatanharianutama.getKodeKandang(), catatanharianutama.getLokasi(), catatanharianutama.getKeteranganJenis(), 
	            catatanharianutama.getTanggalMasuk().toString(), catatanharianutama.getJumlahAwalJantan(), 
	            catatanharianutama.getJumlahAwalBetina(), catatanharianutama.getKomentar());
		connect.execUpdate(query);	
		reusableMethod.showAlert(AlertType.INFORMATION, "CatatanHarianUtama", "CatatanHarianUtama Added Succesfully!");
	}
	
	public void refreshTable(TableView<CatatanHarianUtama> catatan) {
		catatan.getItems().clear();
		catatan.setItems(data.getCatatanHarian());
	}
}
