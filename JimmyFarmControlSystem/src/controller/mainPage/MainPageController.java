package controller.mainPage;

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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
import model.CatatanHarianDetail;
import model.CatatanHarianUtama;
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
		setOnActionEventUpdate();
		setOnActionEventInputData();
		setOnActionEventDelete();
		setOnLogOut(); 
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
	                reusableMethod.showAlert(AlertType.WARNING, "Item Select", "No item selected. Please select an item to view details.");
	            }
			} 
			
			
		});
	}

	public void setOnMouseClicked() {
	    ((MainPageView) view).getTable().setOnMouseClicked(event -> {
	        TableSelectionModel<CatatanHarianUtama> selectionModel = ((MainPageView) view).getTable().getSelectionModel();
	        selectionModel.setSelectionMode(SelectionMode.SINGLE);
	        this.catatan = selectionModel.getSelectedItem();
	    });
	}
	
	//Open update view if an item is selected
	public void setOnActionEventUpdate() {
		((MainPageView) view).getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (catatan != null) {
				    new MainPageUpdateView(((MainPageView) view), catatan);
				} else {
				    reusableMethod.showAlert(AlertType.ERROR, "Item Select", "No Item was Selected");
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
				
				if(reusableMethod.confirmationAlert().get().equals(ButtonType.OK)) {
					if(catatan != null) {
						data.deleteCatatanHarianData(catatan);
						reusableMethod.showAlert(AlertType.INFORMATION, "Delete", "Data Deleted");
						data.refreshCatatanHarianUtamaTable(((MainPageView) view).getTable());	
					} else {
						reusableMethod.showAlert(AlertType.WARNING, "Empty Item", "Catatan is Null");
					}
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
}

