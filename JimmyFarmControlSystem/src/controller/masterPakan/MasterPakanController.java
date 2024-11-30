package controller.masterPakan;

import java.util.Optional;

import controller.MainTemplateController;
import controller.mainPage.MainPageController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DaftarPakan;
import model.MsKandang;
import util.reusableMethod;
import view.TableViewTemplate;
import view.MainPage.MainPageView;
import view.MasterKandang.MasterKandangView;
import view.MasterPakan.MasterPakanView;
import view.MasterPakan.PakanInputView;
import view.MasterPakan.PakanUpdateView;
import view.login.LoginView;

public class MasterPakanController extends MainTemplateController{
	
	public MasterPakanController(MasterPakanView view) {
		super(view);
		setOnAction(); 
		setOnHome(); 
		setOnLogOut();
		setOnSearch();
	}
	
	public DaftarPakan getSelectedPakan() {
		TableSelectionModel model = ((MasterPakanView)view).getTablePakan().getSelectionModel();
		model.setSelectionMode(SelectionMode.SINGLE);
		return (DaftarPakan) model.getSelectedItem();
	}
	
	public void setOnAction() {
		((MasterPakanView)view).getInputData().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				new PakanInputView((MasterPakanView) view);
			}
		});
		
		((MasterPakanView)view).getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(getSelectedPakan() != null) {
					new PakanUpdateView(((MasterPakanView) view), getSelectedPakan());
				} else {
					reusableMethod.showAlert(AlertType.ERROR, "Update Data", "No Selected Item");
				}
			}
		});
		
		((MasterPakanView)view).getDelete().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(getSelectedPakan() != null) {
					if(reusableMethod.confirmationAlert("Delete Data", "Do you want to delete this Data ?").get().equals(ButtonType.OK)) {
						data.deleteMasterPakan(getSelectedPakan());
						reusableMethod.showAlert(AlertType.INFORMATION, "Delete Data", "Data Deleted!");
						data.refreshTablePakan(((MasterPakanView) view).getTablePakan());
					}	
				} else {
					reusableMethod.showAlert(AlertType.ERROR, "Delete Data", "No Selected Data");
				}
			}
		});
	} 
	
	public void setOnHome() { 
		view.getHome().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {  
				Stage window = (Stage) view.getMasterPakan().getScene().getWindow(); 
				window.close();
				new MainPageView();
			}
		});
	}

	public void setOnSearch() { 
		((MasterPakanView) view).getSearch().textProperty().addListener((observable, oldValue, newValue) -> {
	        // Check if 'data' is not null and 'searchMasterKandangData' method exists
	        if (data != null) {
	            ObservableList<DaftarPakan> searchResults = data.searchMasterPakanData(newValue);
	            // Ensure the TableView is being updated with the search results
	            ((MasterPakanView) view).getTablePakan().setItems(searchResults);
	            // Optionally refresh the TableView to force the UI update
	            ((MasterPakanView) view).getTablePakan().refresh();
	        } else {
	            System.err.println("Data instance is null or method not found.");
	        }
	    });;
	}
	
	public void setOnLogOut() {
		view.getLogOut().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Stage window = (Stage) view.getMasterPakan().getScene().getWindow();
				window.close(); 
				new LoginView();
			}
		});
	}
	
}
