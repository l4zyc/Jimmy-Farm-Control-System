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
import model.DaftarObat;
import util.Data;
import util.reusableMethod;
import view.LoginView;
import view.MainPageInputDataView;
import view.MainPageUpdateView;
import view.MainPageView;
import view.MasterKandangView;
import view.MasterObatView;
import view.MasterPakanView;
import view.MasterSupplierView;
import view.ObatInputView;
import view.ObatUpdateView;

public class MasterObatController {

	private MasterObatView view; 
	private DaftarObat obat;  // Selected item
	private Data data = new Data();
	
	public MasterObatController(MasterObatView masterobatview) { 
		this.view = masterobatview; 
		setOnActionEventUpdate();
		setOnActionEventInputData();
		setOnActionEventDelete();
		setOnLogOut();
		setOnMouseClicked(); 
		setOnMouseClickedMasterPakan(); 
		setOnMouseClickedMasterObat(); 
		setOnMouseClickedMasterSupplier(); 
		setOnMouseClickedMasterKandang();
	}
	
	// Set up the selection handler
	public void setOnMouseClicked() {
	    view.getTableObat().setOnMouseClicked(event -> {
	        TableSelectionModel<DaftarObat> selectionModel = view.getTableObat().getSelectionModel();
	        selectionModel.setSelectionMode(SelectionMode.SINGLE);
	        obat = selectionModel.getSelectedItem();
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

	//Open update view if an item is selected
	public void setOnActionEventUpdate() {
		view.getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (obat != null) {
				    new ObatUpdateView(view, obat); // 
				} else {
				    reusableMethod.showAlert(AlertType.ERROR, "Item Select", "No Item was Selected");
				}
			}
		});
	} 
	
	//Delete Data
	public void setOnActionEventDelete() {
		view.getDelete().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Delete Data");
				alert.setTitle("Are you sure you want to delete the data?");
				Optional op = alert.showAndWait();
				
				if(op.get().equals(ButtonType.OK)) {
					data.deleteMasterObat(obat);
					reusableMethod.showAlert(AlertType.INFORMATION, "Delete", "Data Deleted");
					reusableMethod.refreshCatatanObatTable(view.getTableObat());
				}
			}
		});
	}
	
	//Open input data view
	public void setOnActionEventInputData() { 
		view.getInputData().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new ObatInputView(view);
			} 
		}); 
	}  
	
	public void setOnMouseClickedMasterPakan() { 
		view.getMasterPakan().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getMasterPakan().getScene().getWindow();
				window.close(); 
				new MasterPakanView();
			} 
			
		});
	} 
	
	public void setOnMouseClickedMasterObat() { 
		view.getMasterObat().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getMasterPakan().getScene().getWindow();
				window.close(); 
				new MasterObatView();
			} 
			
		});
	}
	
	public void setOnMouseClickedMasterSupplier() { 
		view.getMasterSupplier().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getMasterPakan().getScene().getWindow();
				window.close(); 
				new MasterSupplierView();
			} 
			
		});
	}
	
	public void setOnMouseClickedMasterKandang() { 
		view.getMasterKandang().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getMasterPakan().getScene().getWindow();
				window.close(); 
				new MasterKandangView();
			} 
			
		});
	}
	
}
