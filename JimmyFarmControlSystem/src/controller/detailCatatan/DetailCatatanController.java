package controller.detailCatatan;

import controller.MainTemplateController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableSelectionModel;
import model.CatatanHarianDetail;
import util.reusableMethod;
import view.TableViewTemplate;
import view.CatatanDetail.CatatanHarianDetailView;
import view.CatatanDetail.DetailCatatanInputView;
import view.CatatanDetail.DetailCatatanUpdateView;

public class DetailCatatanController extends MainTemplateController{

	private CatatanHarianDetailView detailView;
	private CatatanHarianDetail catatan;
	
	public DetailCatatanController(CatatanHarianDetailView view) {
		super(view);
		detailView = view;
		setOnMouseClick();
		setOnAction();
	}
	
	public void setOnMouseClick() {
		((CatatanHarianDetailView) view).getTable().setOnMouseClicked(e -> {
			TableSelectionModel<CatatanHarianDetail> model = ((CatatanHarianDetailView) view).getTable().getSelectionModel();
			model.setSelectionMode(SelectionMode.SINGLE);
			catatan = model.getSelectedItem();
		});
	}
	
	public void setOnAction() {
		detailView.getInputData().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				new DetailCatatanInputView(detailView, detailView.getKode());
			}
		});
		
		detailView.getUpdate().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(catatan != null) {
					new DetailCatatanUpdateView(detailView, catatan);	
				}
			}
		});
		
		detailView.getDelete().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(catatan != null) {
					reusableMethod.confirmationAlert();
					data.deleteCatatanHarianDetail(catatan);
					reusableMethod.showAlert(AlertType.INFORMATION, "Delete Data", "Data Deleted");
					data.refreshTableCatatanHarianDetail(detailView.getTable(), catatan.getKodeCatatan());
				}
			}
		});
	} 
}
