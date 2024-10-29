package controller;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
import model.CatatanHarianUtama;
import util.execQuery;
import util.reusableMethod;
import view.MainPageInputDataView;
import view.MainPageUpdateView;
import view.MainPageView;

public class MainPageController {
	
	private MainPageView view; 
	
	public MainPageController(MainPageView mainpageview) { 
		this.view = mainpageview; 
		setOnActionEventUpdate();
		setOnActionEventInputData();
	}
	 
	
	public void setOnActionEventUpdate() {
		view.getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getUpdate().getScene().getWindow();
				window.close();
				new MainPageUpdateView();
			}
		});
	} 
	
	public void setOnActionEventInputData() { 
		view.getInputData().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getInputData().getScene().getWindow(); 
				window.close(); 
				new MainPageInputDataView();
			} 
			
		}); 
	} 
	
}
