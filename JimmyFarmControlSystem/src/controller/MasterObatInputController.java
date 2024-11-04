package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.DaftarObat;
import util.Data;
import view.ObatInputView;

public class MasterObatInputController {
	
	private Data data = new Data();
	ObatInputView view;
	
	public MasterObatInputController(ObatInputView view) {
		this.view = view;
		setOnActionSave();
	}
	
	public void setOnActionSave() {
		view.getSave().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String KODE_OBAT = data.getNewkodeObat();
				String NAMA_OBAT = view.getNamaObatTF().getText();
				String JENIS_OBAT = view.getJenisObatTF().getText();
				Integer DOSIS = Integer.parseInt(view.getDosisTF().getText());
				String SATUAN = view.getSatuanTF().getText();
				String PENYAKIT = view.getPenyakitTF().getText();
				Integer JUMLAH_PER_PACK = Integer.parseInt(view.getJumlahPerPackTF().getText());
				Integer HARGA_PER_PACK = Integer.parseInt(view.getHargaPerPackTF().getText());
				Integer HARGA_PER_SATUAN = Integer.parseInt(view.getHargaPerSatuanTF().getText());
				
				DaftarObat Object_Obat = new DaftarObat(KODE_OBAT, NAMA_OBAT, JENIS_OBAT, DOSIS, SATUAN,
						PENYAKIT, JUMLAH_PER_PACK, HARGA_PER_PACK, HARGA_PER_SATUAN);
				
				data.insertMasterObat(Object_Obat);
				
				view.getNamaObatTF().setText(null);
				view.getNamaObatTF().setText(null);
				view.getJenisObatTF().setText(null);
				view.getDosisTF().setText(null);
				view.getSatuanTF().setText(null);
				view.getPenyakitTF().setText(null);
				view.getJumlahPerPackTF().setText(null);
				view.getHargaPerPackTF().setText(null);
				view.getHargaPerSatuanTF().setText(null);
				
				data.refreshMasterObat(view.getView().getTableObat());
				
				Stage stage = (Stage) view.getBp().getScene().getWindow();
				stage.close();
			}
		});
	}
}


