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
				LocalDate dateConv = view.getTanggalMasuk().getValue();
				Date date = Date.valueOf(dateConv);
				String KodeKandang = view.getKodeKandang().getText();
				String KeteranganJenis = view.getKeteranganJenis().getText();  
				Integer JumlahAwalBetina = Integer.parseInt(view.getJumlahAwalBetina().getText());
				Integer JumlahAwalJantan = Integer.parseInt(view.getJumlahAwalJantan().getText()); 
				String Komentar = view.getKomentar().getText();
				String kodeCatatan = data.getNewkodeCatatan();
				
				CatatanHarianUtama chu = new CatatanHarianUtama(kodeCatatan, date, KodeKandang, KeteranganJenis, JumlahAwalJantan, JumlahAwalBetina, Komentar);
				
				data.insertCatatanHarianUtama(chu);
				
				view.getKodeKandang().setText("");
				view.getKeteranganJenis().setText("");
				view.getTanggalMasuk().setValue(null);
				view.getJumlahAwalBetina().setText("");
				view.getJumlahAwalJantan().setText("");
				view.getKomentar().setText("");
				
				data.refreshCatatanHarianUtamaTable(view.getView().getTable());
				
				Stage stage = (Stage) view.getBp().getScene().getWindow();
				stage.close();
			} 
			
		});
	} 
	
}
