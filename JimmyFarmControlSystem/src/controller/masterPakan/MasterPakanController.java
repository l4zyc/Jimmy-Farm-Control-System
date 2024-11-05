package controller.masterPakan;

import controller.MainTemplateController;
import controller.mainPage.MainPageController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import model.DaftarPakan;
import util.reusableMethod;
import view.TableViewTemplate;
import view.MasterPakan.MasterPakanView;
import view.MasterPakan.PakanInputView;
import view.MasterPakan.PakanUpdateView;

public class MasterPakanController extends MainTemplateController{
	
	public MasterPakanController(MasterPakanView view) {
		super(view);
		setOnAction();
	}
	
	public DaftarPakan getSelectedPakan() {
		TableSelectionModel model = ((MasterPakanView)view).getTablePakan().getSelectionModel();
		model.setSelectionMode(SelectionMode.SINGLE);
		return (DaftarPakan) model.getSelectedItem();
	}
	
	public void setOnAction() {
		((MasterPakanView)view).getInputData().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				new PakanInputView((MasterPakanView) view);
			}
		});
		
		((MasterPakanView)view).getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(getSelectedPakan() != null) {
					new PakanUpdateView(((MasterPakanView) view), getSelectedPakan());
				} else {
					reusableMethod.showAlert(AlertType.ERROR, "Select item", "No Item was selected");
				}
			}
		});
	}

}
