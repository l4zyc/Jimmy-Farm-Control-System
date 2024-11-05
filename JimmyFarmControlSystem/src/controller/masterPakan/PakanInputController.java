package controller.masterPakan;

import controller.ControllerData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.DaftarPakan;
import view.MasterPakan.PakanInputView;

public class PakanInputController extends ControllerData{
	
	private PakanInputView view;

	public PakanInputController(PakanInputView view) {
		this.view = view;
		setOnAction();
	}
	
	public void setOnAction() {
		view.getSave().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				data.insertMasterPakan(getInputData());
				data.refreshTablePakan(view.getView().getTablePakan());
				
				Stage stage = (Stage) view.getBp().getScene().getWindow();
				stage.close();
			}
		});
	}
	
	public DaftarPakan getInputData() {
		String KODE_PAKAN = data.getNewKodePakan();
		String NAMA_PAKAN = view.getNamaPakanTF().getText();
		String JENIS_PAKAN = view.getJenisPakanTF().getText();
		Integer HARGA = Integer.parseInt(view.getHargaTF().getText());
		
		DaftarPakan pakan = new DaftarPakan(KODE_PAKAN, NAMA_PAKAN, JENIS_PAKAN, HARGA);
		return pakan;
	}
}
