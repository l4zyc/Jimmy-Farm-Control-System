package controller.detailCatatan;

import controller.MainTemplateController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.TableViewTemplate;
import view.CatatanDetail.CatatanHarianDetailView;
import view.CatatanDetail.DetailCatatanInputView;

public class DetailCatatanController extends MainTemplateController{

	private CatatanHarianDetailView detailView;
	
	public DetailCatatanController(CatatanHarianDetailView view) {
		super(view);
		detailView = view;
		
		setOnAction();
	}
	
	public void setOnAction() {
		detailView.getInputData().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				new DetailCatatanInputView();
			}
		});
	} 
}
