package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.TableViewTemplate;
import view.MainPage.MainPageView;
import view.MasterKandang.MasterKandangView;
import view.MasterObat.MasterObatView;
import view.MasterPakan.MasterPakanView;
import view.MasterSupplier.MasterSupplierView;

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
	
	public void setOnMouseClickedCatatanHarian() {
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
