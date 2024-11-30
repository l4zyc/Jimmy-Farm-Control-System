package controller.mainPage;

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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
import model.CatatanHarianDetail;
import model.CatatanHarianUtama;
import model.DaftarPakan;
import util.Data;
import util.reusableMethod;
import view.TableViewTemplate;
import view.MainPage.MainPageInputDataView;
import view.MainPage.MainPageUpdateView;
import view.MainPage.MainPageView;
import view.MasterKandang.MasterKandangView;
import view.MasterObat.MasterObatView;
import view.MasterPakan.MasterPakanView;
import view.MasterSupplier.MasterSupplierView;
import view.login.LoginView; 
import view.CatatanDetail.CatatanHarianDetailView;

public class MainPageController extends MainTemplateController{
	
	private CatatanHarianUtama catatan;  // Selected item
	
	public MainPageController(MainPageView view) { 
		super(view);
		setOnMouseClicked();
//		setOnMouseDoubleClick();
		setOnActionEventUpdate();
		setOnActionEventInputData();
		setOnActionEventDelete();
		setOnLogOut();  
		setOnSearch();
		setOnCatatanHarianDetail();
	}
	
	// Untuk masuk kedalam halaman catatan harian detail
	public void setOnCatatanHarianDetail() { 
		((MainPageView) view).getCatatanHarianDetail().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (catatan != null) {
	                String KodeCatatan = catatan.getKodeCatatan();
	                
	                // Close the current stage and open the detail view
	                Stage window = (Stage) view.getTableLayout().getScene().getWindow();
	                window.close();

	                // Open CatatanHarianDetailView with the selected KodeCatatan
	                new CatatanHarianDetailView(KodeCatatan); 
	                
	            } else {
	                reusableMethod.showAlert(AlertType.ERROR, "Item Select", "No item selected. Please select an item to view details.");
	            }
			} 
			
			
		});
	}

	public void setOnMouseClicked() {
	    ((MainPageView) view).getTable().setOnMouseClicked(event -> {
	        TableSelectionModel<CatatanHarianUtama> selectionModel = ((MainPageView) view).getTable().getSelectionModel();
	        selectionModel.setSelectionMode(SelectionMode.SINGLE);
	        catatan = selectionModel.getSelectedItem();
	    });
	}
	
//	public void setOnMouseDoubleClick() {
//		((MainPageView) view).getTable().setRowFactory(tv -> {
//			TableRow<CatatanHarianUtama> row = new TableRow<CatatanHarianUtama>();
//			
//			row.setOnMouseClicked(event -> {
//				if(event.getClickCount() == 2) {
//					CatatanHarianUtama _catatan = row.getItem();
//					new CatatanHarianDetailView(_catatan.getKodeCatatan());
//				}
//			});
//			
//			return row;
//		});
//	}
	
	//Open update view if an item is selected
	public void setOnActionEventUpdate() {
		((MainPageView) view).getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (catatan != null) {
				    new MainPageUpdateView(((MainPageView) view), catatan);
				} else {
				    reusableMethod.showAlert(AlertType.ERROR, "Update Data", "No Selected Item");
				}
			}
		});
	} 
	
	//Delete Data
	public void setOnActionEventDelete() {
		((MainPageView) view).getDelete().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				if(catatan != null) {
					if(reusableMethod.confirmationAlert("Delete", "Are you sure you want to delete this data ?").get().equals(ButtonType.OK)) {
						data.deleteCatatanHarianData(catatan);
						reusableMethod.showAlert(AlertType.INFORMATION, "Delete", "Data Deleted");
						data.refreshCatatanHarianUtamaTable(((MainPageView) view).getTable());		
					}
				} else {
					reusableMethod.showAlert(AlertType.ERROR, "Delete Data", "No Selected Data");
				}
			}
		});
	}
	
	//Open input data view
	public void setOnActionEventInputData() { 
		((MainPageView) view).getInputData().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new MainPageInputDataView(((MainPageView) view));
			} 
		}); 
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
	
	public void setOnSearch() { 
		((MainPageView) view).getSearch().textProperty().addListener((observable, oldValue, newValue) -> {
	        // Check if 'data' is not null and 'searchMasterKandangData' method exists
	        if (data != null) {
	            ObservableList<CatatanHarianUtama> searchResults = data.searchCatatanHarianUtama(newValue, null);
	            // Ensure the TableView is being updated with the search results
	            ((MainPageView) view).getTable().setItems(searchResults);
	            // Optionally refresh the TableView to force the UI update
	            ((MainPageView) view).getTable().refresh();
	        } else {
	            System.err.println("Data instance is null or method not found.");
	        }
	    });;
	}
	
}

