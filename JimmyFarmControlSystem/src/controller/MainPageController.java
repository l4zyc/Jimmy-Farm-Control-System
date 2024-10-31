package controller;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
import model.CatatanHarianUtama;
import util.reusableMethod;
import view.MainPageInputDataView;
import view.MainPageUpdateView;
import view.MainPageView;

public class MainPageController {
	
	private MainPageView view; 
	private CatatanHarianUtama catatan;  // Selected item
	
	public MainPageController(MainPageView mainpageview) { 
		this.view = mainpageview; 
		setOnActionEventUpdate();
		setOnActionEventInputData();
		setOnMouseClicked();
	}
	
	// Set up the selection handler
	public void setOnMouseClicked() {
	    view.getTable().setOnMouseClicked(event -> {
	        TableSelectionModel<CatatanHarianUtama> selectionModel = view.getTable().getSelectionModel();
	        selectionModel.setSelectionMode(SelectionMode.SINGLE);
	        catatan = selectionModel.getSelectedItem();
	        System.out.println("Selected item: " + (catatan != null ? catatan.getLokasi() : "null"));
	    });
	}

	// Open update view if an item is selected
	public void setOnActionEventUpdate() {
		view.getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (catatan != null) {
				    new MainPageUpdateView(catatan);
				} else {
				    System.out.println("No item selected.");
				}
			}
		});
	} 
	
	// Open input data view
	public void setOnActionEventInputData() { 
		view.getInputData().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new MainPageInputDataView();
			} 
		}); 
	} 
}

