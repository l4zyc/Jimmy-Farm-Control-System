package controller.masterObat;

import java.util.ArrayList;
import java.util.Optional;

import controller.MainTemplateController;
import javafx.application.Platform;
import javafx.collections.ObservableList;
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
import model.MsKandang;
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
		setOnHome();
		setOnMouseClicked(); 
		setOnSearch();
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
				Stage window = (Stage) view.getMasterObat().getScene().getWindow();
				window.close(); 
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
				    reusableMethod.showAlert(AlertType.ERROR, "Update Data", "No Selected Item");
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
				
				if(obat != null) {
					if(reusableMethod.confirmationAlert("Delete Data", "Do you want to delete this data ?").get().equals(ButtonType.OK)) {
						data.deleteMasterObat(obat);
						reusableMethod.showAlert(AlertType.INFORMATION, "Delete", "Data Deleted");
						data.refreshMasterObat(((MasterObatView) view).getTableObat());
					}
				} else {
					reusableMethod.showAlert(AlertType.ERROR, "Delete Data", "No Selected Data");
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
	
	public void setOnHome() { 
		view.getHome().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {  
				Stage window = (Stage) view.getMasterObat().getScene().getWindow(); 
				window.close();
				new MainPageView();
			}
		});
	}
	
	public void setOnSearch() { 
		
		((MasterObatView) view).getSearch().textProperty().addListener((observable, oldValue, newValue) -> {
	        // Check if 'data' is not null and 'searchMasterKandangData' method exists
	        if (data != null) {
	            ObservableList<DaftarObat> searchResults = data.searchMasterObatData(newValue, null);
	            // Ensure the TableView is being updated with the search results
	            ((MasterObatView) view).getTableObat().setItems(searchResults);
	            // Optionally refresh the TableView to force the UI update
	            ((MasterObatView) view).getTableObat().refresh();
	        } else {
	            System.err.println("Data instance is null or method not found.");
	        }
	    });;
	}
	
}
