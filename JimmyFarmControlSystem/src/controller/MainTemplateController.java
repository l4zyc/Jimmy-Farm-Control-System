package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.MainPageView;
import view.MasterKandangView;
import view.MasterObatView;
import view.MasterPakanView;
import view.MasterSupplierView;
import view.TableViewTemplate;

public class MainTemplateController {
	
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
	
	public void setOnMouseClickedCatatanHarian() {
		view.getSideBarCatatanHarianLbl().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Stage window = (Stage) view.getMasterPakan().getScene().getWindow();
				window.close(); 
				new MainPageView();
			} 
			
		});
	}
	
	public void setOnMouseClickedMasterPakan() { 
		view.getMasterPakanLbl().setOnMouseClicked(new EventHandler<MouseEvent>() {

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
		view.getMasterObatLbl().setOnMouseClicked(new EventHandler<MouseEvent>() {

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
		view.getMasterSupplierLbl().setOnMouseClicked(new EventHandler<MouseEvent>() {

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
		view.getMasterKandangLbl().setOnMouseClicked(new EventHandler<MouseEvent>() {

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
