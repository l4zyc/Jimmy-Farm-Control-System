package controller.masterObat;

import java.util.ArrayList;
import java.util.Optional;

import controller.MainTemplateController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
import model.DaftarObat;
import util.Data;
import util.reusableMethod;
import view.MainPage.MainPageInputDataView;
import view.MainPage.MainPageUpdateView;
import view.MainPage.MainPageView;
import view.MasterKandang.MasterKandangView;
import view.MasterObat.MasterObatView;
import view.MasterObat.ObatInputView;
import view.MasterObat.ObatUpdateView;
import view.MasterPakan.MasterPakanView;
import view.MasterSupplier.MasterSupplierView;
import view.login.LoginView;

public class MasterObatController extends MainTemplateController{

	private DaftarObat obat;  // Selected item
	private Data data = new Data();
	
	public MasterObatController(MasterObatView view) { 
		super((MasterObatView)view);
		setOnActionEventUpdate();
		setOnActionEventInputData();
		setOnActionEventDelete();
		setOnLogOut();
		setOnMouseClicked(); 
		setOnMouseClickedMasterPakan(); 
		setOnMouseClickedMasterObat(); 
		setOnMouseClickedMasterSupplier(); 
		setOnMouseClickedMasterKandang();
	}
	
	// Set up the selection handler
	public void setOnMouseClicked() {
	    ((MasterObatView) view).getTableObat().setOnMouseClicked(event -> {
	        TableSelectionModel<DaftarObat> selectionModel = ((MasterObatView) view).getTableObat().getSelectionModel();
	        selectionModel.setSelectionMode(SelectionMode.SINGLE);
	        obat = selectionModel.getSelectedItem();
	    });
	}
	
	public void setOnLogOut() {
		((MasterObatView) view).getLogOut().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				new LoginView();
			}
		});
	}

	//Open update view if an item is selected
	public void setOnActionEventUpdate() {
		((MasterObatView) view).getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (obat != null) {
				    new ObatUpdateView(((MasterObatView) view), obat); // 
				} else {
				    reusableMethod.showAlert(AlertType.ERROR, "Item Select", "No Item was Selected");
				}
			}
		});
	} 
	
	//Delete Data
	public void setOnActionEventDelete() {
		((MasterObatView) view).getDelete().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Delete Data");
				alert.setTitle("Are you sure you want to delete the data?");
				Optional op = alert.showAndWait();
				
				if(op.get().equals(ButtonType.OK)) {
					data.deleteMasterObat(obat);
					reusableMethod.showAlert(AlertType.INFORMATION, "Delete", "Data Deleted");
					reusableMethod.refreshCatatanObatTable(((MasterObatView) view).getTableObat());
				}
			}
		});
	}
	
	//Open input data view
	public void setOnActionEventInputData() { 
		((MasterObatView) view).getInputData().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new ObatInputView(((MasterObatView) view));
			} 
		}); 
	}  
	
}
