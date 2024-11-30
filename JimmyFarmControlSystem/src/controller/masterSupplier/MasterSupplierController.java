package controller.masterSupplier;

import java.util.Optional;

import controller.MainTemplateController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.stage.Stage;
import model.DaftarPakan;
import model.DaftarSupplier;
import util.reusableMethod;
import view.MasterSupplier.*;
import view.login.LoginView;
import view.TableViewTemplate;
import view.MainPage.MainPageView;
import view.MasterPakan.MasterPakanView;

public class MasterSupplierController extends MainTemplateController{

	public MasterSupplierController(TableViewTemplate view) {
		super(view);
		setOnLogOut();
		setOnAction();  
		setOnHome();
		setOnSearch();
	}

	public void setOnLogOut() {
		((MasterSupplierView)view).getLogOut().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) { 
				Stage window = (Stage) view.getMasterSupplier().getScene().getWindow();
				window.close(); 
				new LoginView();
			}
		});
	}

	
	public void setOnAction() { 
		((MasterSupplierView)view).getInputData().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new SupplierInputView((MasterSupplierView) view);
			} 
		}); 
		
		((MasterSupplierView)view).getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				DaftarSupplier supplier = getSupplierItem();
				
				if (supplier != null) {
				    new SupplierUpdateView((MasterSupplierView) view, supplier); // 
				} else {
				    reusableMethod.showAlert(AlertType.ERROR, "Update Data", "No Selected Item");
				}
			}
		});
		
		((MasterSupplierView)view).getDelete().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				if(getSupplierItem() != null) {
					if(reusableMethod.confirmationAlert("Delete Data", "Do you want to delete this Data ?").get().equals(ButtonType.OK)) {
						data.deleteMasterSupplier(getSupplierItem());
						reusableMethod.showAlert(AlertType.INFORMATION, "Delete Data", "Data Deleted");
						data.refreshMasterSupplier(((MasterSupplierView)view).getTableSupplier());
					}
				} else {
					reusableMethod.showAlert(AlertType.ERROR, "Delete", "No Selected Data");
				}
			}
		});
	}  
	
	public DaftarSupplier getSupplierItem() {
		TableViewSelectionModel<DaftarSupplier> model = ((MasterSupplierView) view).getTableSupplier().getSelectionModel();
		model.setSelectionMode(SelectionMode.SINGLE);
		return (DaftarSupplier) model.getSelectedItem();
	} 
	
	public void setOnHome() { 
		view.getHome().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {  
				Stage window = (Stage) view.getMasterSupplier().getScene().getWindow(); 
				window.close();
				new MainPageView();
			}
		});
	}
	
	public void setOnSearch() { 
		((MasterSupplierView) view).getSearch1().textProperty().addListener((observable, oldValue, newValue) -> {
	        // Check if 'data' is not null and 'searchMasterKandangData' method exists
	        if (data != null) {
	            ObservableList<DaftarSupplier> searchResults = data.searchMasterSupplierData(newValue);
	            // Ensure the TableView is being updated with the search results
	            ((MasterSupplierView) view).getTableSupplier().setItems(searchResults);
	            // Optionally refresh the TableView to force the UI update
	            ((MasterSupplierView) view).getTableSupplier().refresh();
	        } else {
	            System.err.println("Data instance is null or method not found.");
	        }
	    });;
	}
	
 }
