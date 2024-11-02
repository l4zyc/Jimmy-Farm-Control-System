package controller;

import java.util.ArrayList;
import java.util.Optional;

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
import view.LoginView;
import view.MainPageInputDataView;
import view.MainPageUpdateView;
import view.MainPageView;

public class MainPageController {
	
	private MainPageView view; 
	private CatatanHarianUtama catatan;  // Selected item
	private Data data = new Data();
	
	public MainPageController(MainPageView mainpageview) { 
		this.view = mainpageview; 
		setOnActionEventUpdate();
		setOnActionEventInputData();
		setOnActionEventDelete();
		setOnLogOut();
		setOnMouseClicked();
	}
	
	// Set up the selection handler
	public void setOnMouseClicked() {
	    view.getTable().setOnMouseClicked(event -> {
	        TableSelectionModel<CatatanHarianUtama> selectionModel = view.getTable().getSelectionModel();
	        selectionModel.setSelectionMode(SelectionMode.SINGLE);
	        catatan = selectionModel.getSelectedItem();
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

	// Open update view if an item is selected
	public void setOnActionEventUpdate() {
		view.getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (catatan != null) {
				    new MainPageUpdateView(view, catatan);
				} else {
				    System.out.println("No item selected.");
				}
			}
		});
	} 
	
	public void setOnActionEventDelete() {
		view.getDelete().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.CONFIRMATION);
				Optional op = alert.showAndWait();
				
				if(op.get().equals(ButtonType.OK)) {
					data.deleteCatatanHarianData(catatan);
					reusableMethod.showAlert(AlertType.INFORMATION, "Delete", "Data Deleted");
					reusableMethod.refreshTable(view.getTable());
				}
			}
		});
	}
	
	// Open input data view
	public void setOnActionEventInputData() { 
		view.getInputData().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new MainPageInputDataView(view);
			} 
		}); 
	} 
}

