package controller.masterObat;

import controller.ControllerData;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.DaftarObat;
import util.reusableMethod;
import view.MasterObat.ObatUpdateView;

public class MasterObatUpdateController extends ControllerData{
	private ObatUpdateView view;
	
	public MasterObatUpdateController(ObatUpdateView view) {
		this.view = view;
		setOnAction();
	}
	
	public void setOnAction() {
		view.getSave().setOnAction(e -> {
			String NAMA_OBAT = view.getNamaObatTF().getText();
			String JENIS_OBAT = view.getJenisObatTF().getText();
			Integer DOSIS = Integer.parseInt(view.getDosisTF().getText());
			String SATUAN = view.getSatuanTF().getText();
			String PENYAKIT = view.getPenyakitTF().getText();
			Integer JUMLAH_PER_PACK = Integer.parseInt(view.getJumlahPerPackTF().getText());
			Integer HARGA_PER_PACK = Integer.parseInt(view.getHargaPerPackTF().getText());
			Integer HARGA_PER_SATUAN = Integer.parseInt(view.getHargaPerSatuanTF().getText());
			
			data.updateMasterObat(
						new DaftarObat(view.getObat().getKodeObat(), 
								NAMA_OBAT, 
								JENIS_OBAT, 
								DOSIS, 
								SATUAN, 
								PENYAKIT, 
								JUMLAH_PER_PACK, 
								HARGA_PER_PACK, 
								HARGA_PER_SATUAN)
					);
			
			reusableMethod.showAlert(AlertType.INFORMATION, "Update", "Obat Data Updated!");
			data.refreshMasterObat(view.getView().getTableObat());
			Stage stage = view.getStage();
			stage.close();
		});
	}
}
