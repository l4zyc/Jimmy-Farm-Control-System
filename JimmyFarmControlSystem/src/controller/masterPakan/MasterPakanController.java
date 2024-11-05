package controller.masterPakan;

import controller.MainTemplateController;
import controller.mainPage.MainPageController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.TableViewTemplate;
import view.MasterPakan.MasterPakanView;
import view.MasterPakan.PakanInputView;

public class MasterPakanController extends MainTemplateController{
	
	public MasterPakanController(MasterPakanView view) {
		super(view);
		setOnAction();
	}
	
	public void setOnAction() {
		((MasterPakanView)view).getInputData().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				new PakanInputView((MasterPakanView) view);
			}
		});
	}

}
