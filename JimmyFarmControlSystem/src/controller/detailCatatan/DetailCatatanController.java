package controller.detailCatatan;

import controller.MainTemplateController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableSelectionModel;
import model.CatatanHarianDetail;
import model.DaftarPakan;
import util.reusableMethod;
import view.TableViewTemplate;
import view.CatatanDetail.CatatanHarianDetailView;
import view.CatatanDetail.DetailCatatanInputView;
import view.CatatanDetail.DetailCatatanUpdateView;
import view.MainPage.MainPageView;
import view.MasterPakan.MasterPakanView;

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
				}
			}
		});
		
		detailView.getDelete().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(catatan != null) {
					reusableMethod.confirmationAlert();
					data.deleteCatatanHarianDetail(catatan);
					reusableMethod.showAlert(AlertType.INFORMATION, "Delete Data", "Data Deleted");
					data.refreshTableCatatanHarianDetail(detailView.getTable(), catatan.getKodeCatatan());
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

}
