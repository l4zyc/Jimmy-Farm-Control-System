package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.TableViewTemplate;
import view.MainPage.MainPageView;
import view.MasterKandang.MasterKandangView;
import view.MasterObat.MasterObatView;
import view.MasterPakan.MasterPakanView;
import view.MasterSupplier.MasterSupplierView;
import view.login.LoginView;

public class MainTemplateController extends ControllerData{
	
	protected TableViewTemplate view;

	public MainTemplateController(TableViewTemplate view) {
		this.view = view;
	}
	
	public void setOnMouseClickedTemplate() {
		setOnMouseClickedCatatanHarian();
		setOnMouseClickedMasterPakan(); 
		setOnMouseClickedMasterObat(); 
		setOnMouseClickedMasterSupplier(); 
		setOnMouseClickedMasterKandang();
	}
	
	public void setOnLogOut() {
		view.getLogOut().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				new LoginView();
			}
		});
	}
	
	private void setOnMouseClickedCatatanHarian() {
		view.getCatatanHarian().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getMasterPakan().getScene().getWindow();
				window.close(); 
				new MainPageView();
			} 
			
		});
	}
	
	private void setOnMouseClickedMasterPakan() { 
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
	
	private void setOnMouseClickedMasterObat() { 
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
	
	private void setOnMouseClickedMasterSupplier() { 
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
	
	private void setOnMouseClickedMasterKandang() { 
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
