package controller.masterSupplier;

import java.util.Optional;

import controller.MainTemplateController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView.TableViewSelectionModel;
import model.DaftarSupplier;
import util.reusableMethod;
import view.MasterSupplier.*;
import view.login.LoginView;
import view.TableViewTemplate;
import view.MainPage.MainPageView;

public class MasterSupplierController extends MainTemplateController{

	public MasterSupplierController(TableViewTemplate view) {
		super(view);
		setOnLogOut();
		setOnAction();
	}

	public void setOnLogOut() {
		((MasterSupplierView)view).getLogOut().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				new LoginView();
			}
		});
	}

	
	public void setOnAction() { 
		((MasterSupplierView)view).getInputData().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new SupplierInputView((MasterSupplierView) view);
			} 
		}); 
		
		((MasterSupplierView)view).getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				DaftarSupplier supplier = getSupplierItem();
				
				if (supplier != null) {
				    new SupplierUpdateView((MasterSupplierView) view, supplier); // 
				} else {
				    reusableMethod.showAlert(AlertType.ERROR, "Item Select", "No Item was Selected");
				}
			}
		});
		
		((MasterSupplierView)view).getDelete().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Delete Data");
				alert.setContentText("Are you sure you want to delete the data?");
				Optional<ButtonType> op = alert.showAndWait();
				
				if(op.get().equals(ButtonType.OK)) {
					data.deleteMasterSupplier(getSupplierItem());
					reusableMethod.showAlert(AlertType.INFORMATION, "Delete", "Data Deleted");
					data.refreshMasterSupplier(((MasterSupplierView)view).getTableSupplier());
				}
			}
		});
	}  
	
	public DaftarSupplier getSupplierItem() {
		TableViewSelectionModel<DaftarSupplier> model = ((MasterSupplierView) view).getTableSupplier().getSelectionModel();
		model.setSelectionMode(SelectionMode.SINGLE);
		return (DaftarSupplier) model.getSelectedItem();
	}
 }
