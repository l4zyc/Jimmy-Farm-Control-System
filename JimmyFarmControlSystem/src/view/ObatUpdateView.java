package view;

import controller.MainPageUpdateController;
import controller.MasterObatInputController;
import controller.MasterObatUpdateController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.DaftarObat;

public class ObatUpdateView extends ViewTemplate{ 
	
	BorderPane bp = new BorderPane(); 
	GridPane form1 = new GridPane(); 

	Scene scene = new Scene(bp, width * 0.5, height * 0.5);

	Label NamaObatLbl, JenisObatLbl, DosisLbl, SatuanLbl, PenyakitLbl, JumlahPerPackLbl, HargaPerPackLbl, HargaPerSatuanLbl;
	TextField NamaObatTF, JenisObatTF, DosisTF, SatuanTF, PenyakitTF, JumlahPerPackTF, HargaPerPackTF, HargaPerSatuanTF;
	Button Save;
	
	private MasterObatView view;
	private Stage stage;
	private DaftarObat obat;
	
	public ObatUpdateView(MasterObatView view, DaftarObat obat) {
		this.view = view;
		this.obat = obat;
		init(); 
		arrangeComponent(); 
		stage = new Stage();
		stage.setTitle("Input Obat");
		
		stage.setScene(scene);
		stage.show(); 
		
		new MasterObatUpdateController(this);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		//Nama Obat
		NamaObatLbl = new Label("Nama Obat*"); 
		NamaObatTF = new TextField();  
		NamaObatTF.setText(obat.getNamaObat());
		
		//Tanggal Masuk
		JenisObatLbl = new Label("Jenis Obat*"); 
		JenisObatTF = new TextField();
		JenisObatTF.setText(obat.getJenisObat());
		
		//Keterangan Jenis
		DosisLbl = new Label("Dosis*");
		DosisTF = new TextField();
		DosisTF.setText(obat.getDosis().toString());
		
		//Jumlah Awal Jantan
		SatuanLbl = new Label("Satuan*"); 
		SatuanTF = new TextField();  
		SatuanTF.setText(obat.getSatuan().toString());
		
		//Jumlah Awal Betina
		PenyakitLbl = new Label("Penyakit*"); 
		PenyakitTF = new TextField(); 
		PenyakitTF.setText(obat.getPenyakit());
		
		//Komentar
		JumlahPerPackLbl = new Label("Jumlah Per Pack*");
		JumlahPerPackTF = new TextField();
		JumlahPerPackTF.setText(obat.getJumlahPerPack().toString());
		
		//Komentar
		HargaPerPackLbl = new Label("Harga Per Pack*");
		HargaPerPackTF = new TextField();
		HargaPerPackTF.setText(obat.getHargaPerPack().toString());
		
		//Komentar
		HargaPerSatuanLbl = new Label("Harga Per Satuan");
		HargaPerSatuanTF = new TextField();
		HargaPerSatuanTF.setText(obat.getHargaPerSatuan().toString());
						
		//Button Save
		Save = new Button("Save"); 
		Save.setFont(Font.font("Inter", 20));
		Save.setMinWidth(150); 
				
		
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		form1.setHgap(10); 
		form1.setVgap(10);  
		form1.add(NamaObatLbl, 1, 1); 
		form1.add(NamaObatTF, 2, 1); 
		form1.add(JenisObatLbl, 1, 2);
		form1.add(JenisObatTF, 2, 2);  
		form1.add(DosisLbl, 1, 3); 
		form1.add(DosisTF, 2, 3);
		form1.add(SatuanLbl, 1, 4); 
		form1.add(SatuanTF, 2, 4); 
		form1.add(PenyakitLbl, 1, 5); 
		form1.add(PenyakitTF, 2, 5); 
		form1.add(JumlahPerPackLbl, 1, 6); 
		form1.add(JumlahPerPackTF, 2, 6); 
		form1.add(HargaPerPackLbl, 1, 7); 
		form1.add(HargaPerPackTF, 2, 7); 
		form1.add(HargaPerSatuanLbl, 1, 8); 
		form1.add(HargaPerSatuanTF, 2, 8); 
		
		bp.setBottom(Save); 
		bp.setCenter(form1);
		
		bp.setPadding(new Insets(50));
		form1.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(Save, Pos.CENTER);
	}

	public BorderPane getBp() {
		return bp;
	}

	public GridPane getForm1() {
		return form1;
	}

	public Double getWidth() {
		return width;
	}

	public Double getHeight() {
		return height;
	}

	public Scene getScene() {
		return scene;
	}

	public Label getNamaObatLbl() {
		return NamaObatLbl;
	}

	public Label getJenisObatLbl() {
		return JenisObatLbl;
	}

	public Label getDosisLbl() {
		return DosisLbl;
	}

	public Label getSatuanLbl() {
		return SatuanLbl;
	}

	public Label getPenyakitLbl() {
		return PenyakitLbl;
	}

	public Label getJumlahPerPackLbl() {
		return JumlahPerPackLbl;
	}

	public Label getHargaPerPackLbl() {
		return HargaPerPackLbl;
	}

	public Label getHargaPerSatuanLbl() {
		return HargaPerSatuanLbl;
	}

	public TextField getNamaObatTF() {
		return NamaObatTF;
	}

	public TextField getJenisObatTF() {
		return JenisObatTF;
	}

	public TextField getDosisTF() {
		return DosisTF;
	}

	public TextField getSatuanTF() {
		return SatuanTF;
	}

	public TextField getPenyakitTF() {
		return PenyakitTF;
	}

	public TextField getJumlahPerPackTF() {
		return JumlahPerPackTF;
	}

	public TextField getHargaPerPackTF() {
		return HargaPerPackTF;
	}

	public TextField getHargaPerSatuanTF() {
		return HargaPerSatuanTF;
	}

	public Button getSave() {
		return Save;
	}

	public MasterObatView getView() {
		return view;
	}

	public Stage getStage() {
		return stage;
	}

	public void setBp(BorderPane bp) {
		this.bp = bp;
	}

	public void setForm1(GridPane form1) {
		this.form1 = form1;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public void setNamaObatLbl(Label namaObatLbl) {
		NamaObatLbl = namaObatLbl;
	}

	public void setJenisObatLbl(Label jenisObatLbl) {
		JenisObatLbl = jenisObatLbl;
	}

	public void setDosisLbl(Label dosisLbl) {
		DosisLbl = dosisLbl;
	}

	public void setSatuanLbl(Label satuanLbl) {
		SatuanLbl = satuanLbl;
	}

	public void setPenyakitLbl(Label penyakitLbl) {
		PenyakitLbl = penyakitLbl;
	}

	public void setJumlahPerPackLbl(Label jumlahPerPackLbl) {
		JumlahPerPackLbl = jumlahPerPackLbl;
	}

	public void setHargaPerPackLbl(Label hargaPerPackLbl) {
		HargaPerPackLbl = hargaPerPackLbl;
	}

	public void setHargaPerSatuanLbl(Label hargaPerSatuanLbl) {
		HargaPerSatuanLbl = hargaPerSatuanLbl;
	}

	public void setNamaObatTF(TextField namaObatTF) {
		NamaObatTF = namaObatTF;
	}

	public void setJenisObatTF(TextField jenisObatTF) {
		JenisObatTF = jenisObatTF;
	}

	public void setDosisTF(TextField dosisTF) {
		DosisTF = dosisTF;
	}

	public void setSatuanTF(TextField satuanTF) {
		SatuanTF = satuanTF;
	}

	public void setPenyakitTF(TextField penyakitTF) {
		PenyakitTF = penyakitTF;
	}

	public void setJumlahPerPackTF(TextField jumlahPerPackTF) {
		JumlahPerPackTF = jumlahPerPackTF;
	}

	public void setHargaPerPackTF(TextField hargaPerPackTF) {
		HargaPerPackTF = hargaPerPackTF;
	}

	public void setHargaPerSatuanTF(TextField hargaPerSatuanTF) {
		HargaPerSatuanTF = hargaPerSatuanTF;
	}

	public void setSave(Button save) {
		Save = save;
	}

	public void setView(MasterObatView view) {
		this.view = view;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public DaftarObat getObat() {
		return obat;
	}

	public void setObat(DaftarObat obat) {
		this.obat = obat;
	}
	
}
