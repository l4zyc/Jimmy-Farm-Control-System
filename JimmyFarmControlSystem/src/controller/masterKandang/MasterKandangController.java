package controller.masterKandang;

import java.util.Optional;

import controller.MainTemplateController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.MsKandang;
import util.reusableMethod;
import view.TableViewTemplate;
import view.MainPage.MainPageView;
import view.MasterKandang.KandangInputView;
import view.MasterKandang.KandangUpdateView;
import view.MasterKandang.MasterKandangView;
import view.login.LoginView;

public class MasterKandangController extends MainTemplateController{

	public MasterKandangController(TableViewTemplate view) {
		super(view);
		setOnLogOut();
		setOnAction(); 
		setOnHome();
	}
	
	public void setOnLogOut() {
	((MasterKandangView) view).getLogOut().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				new LoginView();
			}
		});
	}

	public void setOnAction() {
		((MasterKandangView) view).getInputData().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				new KandangInputView(((MasterKandangView) view));
			}
		});
		
		((MasterKandangView) view).getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				MsKandang kandang = getMasterKandang();
				
				if(kandang != null) {
					new KandangUpdateView(((MasterKandangView) view), kandang);
				} else {
					reusableMethod.showAlert(AlertType.ERROR, "Select Item", "No Item was Selected");
				}
			}
		});
		
		((MasterKandangView) view).getDelete().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {	
				if(reusableMethod.confirmationAlert().get().equals(ButtonType.OK)) {
					data.deleteMasterKandang(getMasterKandang());
					reusableMethod.showAlert(AlertType.CONFIRMATION, "Delete", "Data Deleted");
					data.refreshMasterKandang(((MasterKandangView) view).getTableKandang());
				}
			}
		});
	}
	
	public MsKandang getMasterKandang() {
		TableSelectionModel<MsKandang> model = ((MasterKandangView) view).getTableKandang().getSelectionModel();
		model.setSelectionMode(SelectionMode.SINGLE);
		return (MsKandang)model.getSelectedItem();
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
	
}
