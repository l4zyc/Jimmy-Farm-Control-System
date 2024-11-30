package controller.detailCatatan;

import controller.MainTemplateController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.input.MouseEvent;
import model.CatatanHarianDetail;
import model.DaftarPakan;
import util.reusableMethod;
import view.TableViewTemplate;
import view.CatatanDetail.CatatanHarianDetailView;
import view.CatatanDetail.DetailCatatanInputView;
import view.CatatanDetail.DetailCatatanUpdateView;
import view.MainPage.MainPageView;
import view.MasterPakan.MasterPakanView;
import view.login.LoginView;

public class DetailCatatanController extends MainTemplateController{

	private CatatanHarianDetailView detailView;
	private CatatanHarianDetail catatan;
	
	public DetailCatatanController(CatatanHarianDetailView view, String kodeCatatan) {
		super(view);
		detailView = view;
		setOnMouseClick();
		setOnAction();
		setOnLogOut(); 
		setOnHome();   
		SetOnBack();
		setOnSearch(kodeCatatan);
	} 
	
	public void setOnMouseClick() {
		((CatatanHarianDetailView) view).getTable().setOnMouseClicked(e -> {
			TableSelectionModel<CatatanHarianDetail> model = ((CatatanHarianDetailView) view).getTable().getSelectionModel();
			model.setSelectionMode(SelectionMode.SINGLE);
			catatan = model.getSelectedItem();
		});
	}
	
	public void setOnAction() {
		detailView.getInputData().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				new DetailCatatanInputView(detailView, detailView.getKode());
			}
		});
		
		detailView.getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(catatan != null) {
					new DetailCatatanUpdateView(detailView, catatan);	
				} else {
					reusableMethod.showAlert(AlertType.ERROR, "Update Data", "No Selected Item");
				}
			}
		});
		
		detailView.getDelete().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(catatan != null) {
					if(reusableMethod.confirmationAlert("Delete", "Are you sure you want to delete this data ?").get().equals(ButtonType.OK)) {
						data.deleteCatatanHarianDetail(catatan);
						reusableMethod.showAlert(AlertType.INFORMATION, "Delete Data", "Data Deleted");
						data.refreshTableCatatanHarianDetail(detailView.getTable(), catatan.getKodeCatatan());	
					}
				} else {
					reusableMethod.showAlert(AlertType.ERROR, "Delete Data", "Catatan Harian Detail is Null");
				}
			}
		});
	}  
	
	public void setOnHome() { 
		view.getHome().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {  
				Stage window = (Stage) view.getMasterKandang().getScene().getWindow(); 
				window.close();
				new MainPageView();
			}
		});
	} 
	
	public void SetOnBack() { 
		((CatatanHarianDetailView) view).getBack().setOnMouseClicked(new EventHandler<MouseEvent>() { 
			
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getMasterKandang().getScene().getWindow(); 
				window.close();
				new MainPageView();
			}
		});
	}
	
	public void setOnSearch(String kodeCatatan) { 
	    ((CatatanHarianDetailView) view).getSearch2().textProperty().addListener((observable, oldValue, newValue) -> {
	        if (data != null) {
	            // Perform the search with the new value (keyword) and KodeCatatan
	            ObservableList<CatatanHarianDetail> searchResults = data.searchCatatanHarianDetailAllColumns(kodeCatatan, newValue);
	            
	            // Update the TableView with the filtered results
	            ((CatatanHarianDetailView) view).getTable().setItems(searchResults);

	            // Refresh the TableView to ensure UI updates properly
	            ((CatatanHarianDetailView) view).getTable().refresh();
	        } else {
	            // Log an error if 'data' is null or not initialized
	            System.err.println("Data instance is null or method not found.");
	        }
	    });
	}

	public void setOnLogOut() {
		view.getLogOut().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				new LoginView();
			}
		});
	}
	
}
