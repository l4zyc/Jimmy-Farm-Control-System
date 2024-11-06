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
import javafx.scene.control.TableSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
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

public class MainPageController extends MainTemplateController{
	
	private CatatanHarianUtama catatan;  // Selected item
	
	public MainPageController(MainPageView view) { 
		super(view);
		setOnActionEventUpdate();
		setOnActionEventInputData();
		setOnActionEventDelete();
		setOnLogOut();
		setOnMouseClicked(); 
		setOnMouseClickedTemplate();
	}
	
	// Set up the selection handler
	public void setOnMouseClicked() {
	    ((MainPageView) view).getTable().setOnMouseClicked(event -> {
	        TableSelectionModel<CatatanHarianUtama> selectionModel = ((MainPageView) view).getTable().getSelectionModel();
	        selectionModel.setSelectionMode(SelectionMode.SINGLE);
	        catatan = selectionModel.getSelectedItem();
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
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Delete Data");
				alert.setTitle("Are you sure you want to delete the data?");
				Optional op = alert.showAndWait();
				
				if(op.get().equals(ButtonType.OK)) {
					data.deleteCatatanHarianData(catatan);
					reusableMethod.showAlert(AlertType.INFORMATION, "Delete", "Data Deleted");
					reusableMethod.refreshTable(((MainPageView) view).getTable());
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

