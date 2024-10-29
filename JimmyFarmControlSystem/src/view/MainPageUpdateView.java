package view;

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

public class MainPageUpdateView extends ViewTemplate{
	BorderPane bp = new BorderPane(); 
	GridPane form1 = new GridPane(); 

	Double width = Screen.getPrimary().getBounds().getWidth();
	Double height = Screen.getPrimary().getBounds().getHeight(); 

	Scene scene = new Scene(bp, width * 0.5, height * 0.5);

	Label LokasiLbl, KodeKandangLbl, TanggalMasukLbl, JumlahAwalJantanLbl, JumlahAwalBetinaLbl, KomentarLbl;
	TextField Lokasi, KodeKandang, KeteranganJenis, JumlahAwalJantan, JumlahAwalBetina, Komentar;
	DatePicker TanggalMasuk; 
	Button Save;
	
	private Stage stage;

	public MainPageUpdateView() { 
		init(); 
		arrangeComponent(); 
		stage = new Stage();
		
		stage.setScene(scene);
		stage.show(); 
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		//Lokasi
				LokasiLbl = new Label("Lokasi*"); 
				Lokasi = new TextField();  
				//Kode Kandang
				KodeKandangLbl = new Label("Kode Kandang*"); 
				KodeKandang = new TextField();  
				//Tanggal Masuk
				TanggalMasukLbl = new Label("Tanggal Masuk*"); 
				TanggalMasuk = new DatePicker();  
				//Jumlah Awal Jantan
				JumlahAwalJantanLbl = new Label("Jumlah Awal Jantan*"); 
				JumlahAwalJantan = new TextField();  
				//Jumlah Awal Betina
				JumlahAwalBetinaLbl = new Label("Jumlah Awal Betina*"); 
				JumlahAwalBetina = new TextField();  
				//Komentar
				KomentarLbl = new Label("Komentar");
				Komentar = new TextField();
				
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
		form1.add(LokasiLbl, 1, 0); 
		form1.add(Lokasi, 2, 0);
		form1.add(KodeKandangLbl, 1, 1); 
		form1.add(KodeKandang, 2, 1); 
		form1.add(TanggalMasukLbl, 1, 2);
		form1.add(TanggalMasuk, 2, 2); 
		form1.add(JumlahAwalJantanLbl, 1, 3); 
		form1.add(JumlahAwalJantan, 2, 3); 
		form1.add(JumlahAwalBetinaLbl, 1, 4); 
		form1.add(JumlahAwalBetina, 2, 4); 
		form1.add(KomentarLbl, 1, 5); 
		form1.add(Komentar, 2, 5); 
		
		bp.setBottom(Save); 
		bp.setCenter(form1);
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

	public Label getLokasiLbl() {
		return LokasiLbl;
	}

	public Label getKodeKandangLbl() {
		return KodeKandangLbl;
	}

	public Label getTanggalMasukLbl() {
		return TanggalMasukLbl;
	}

	public Label getJumlahAwalJantanLbl() {
		return JumlahAwalJantanLbl;
	}

	public Label getJumlahAwalBetinaLbl() {
		return JumlahAwalBetinaLbl;
	}

	public Label getKomentarLbl() {
		return KomentarLbl;
	}

	public TextField getLokasi() {
		return Lokasi;
	}

	public TextField getKodeKandang() {
		return KodeKandang;
	}

	public TextField getKeteranganJenis() {
		return KeteranganJenis;
	}

	public TextField getJumlahAwalJantan() {
		return JumlahAwalJantan;
	}

	public TextField getJumlahAwalBetina() {
		return JumlahAwalBetina;
	}

	public TextField getKomentar() {
		return Komentar;
	}

	public DatePicker getTanggalMasuk() {
		return TanggalMasuk;
	}

	public Button getSave() {
		return Save;
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

	public void setLokasiLbl(Label lokasiLbl) {
		LokasiLbl = lokasiLbl;
	}

	public void setKodeKandangLbl(Label kodeKandangLbl) {
		KodeKandangLbl = kodeKandangLbl;
	}

	public void setTanggalMasukLbl(Label tanggalMasukLbl) {
		TanggalMasukLbl = tanggalMasukLbl;
	}

	public void setJumlahAwalJantanLbl(Label jumlahAwalJantanLbl) {
		JumlahAwalJantanLbl = jumlahAwalJantanLbl;
	}

	public void setJumlahAwalBetinaLbl(Label jumlahAwalBetinaLbl) {
		JumlahAwalBetinaLbl = jumlahAwalBetinaLbl;
	}

	public void setKomentarLbl(Label komentarLbl) {
		KomentarLbl = komentarLbl;
	}

	public void setLokasi(TextField lokasi) {
		Lokasi = lokasi;
	}

	public void setKodeKandang(TextField kodeKandang) {
		KodeKandang = kodeKandang;
	}

	public void setKeteranganJenis(TextField keteranganJenis) {
		KeteranganJenis = keteranganJenis;
	}

	public void setJumlahAwalJantan(TextField jumlahAwalJantan) {
		JumlahAwalJantan = jumlahAwalJantan;
	}

	public void setJumlahAwalBetina(TextField jumlahAwalBetina) {
		JumlahAwalBetina = jumlahAwalBetina;
	}

	public void setKomentar(TextField komentar) {
		Komentar = komentar;
	}

	public void setTanggalMasuk(DatePicker tanggalMasuk) {
		TanggalMasuk = tanggalMasuk;
	}

	public void setSave(Button save) {
		Save = save;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}


	
}
