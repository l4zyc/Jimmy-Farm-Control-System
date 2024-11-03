package view;

import controller.MainPageUpdateController;
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
import model.CatatanHarianUtama;

public class MainPageUpdateView extends ViewTemplate{
	BorderPane bp = new BorderPane(); 
	GridPane form1 = new GridPane(); 

	Double width = Screen.getPrimary().getBounds().getWidth();
	Double height = Screen.getPrimary().getBounds().getHeight(); 

	Scene scene = new Scene(bp, width * 0.5, height * 0.5);

	Label KodeCatatanLbl, KodeKandangLbl, KeteranganJenisLbl, TanggalMasukLbl, JumlahAwalJantanLbl, JumlahAwalBetinaLbl, KomentarLbl;
	TextField KodeCatatanTF, KodeKandang, KeteranganJenisTF, JumlahAwalJantan, JumlahAwalBetina, Komentar;
	DatePicker TanggalMasuk; 
	Button Save;
	
	private CatatanHarianUtama catatan;
	private MainPageView view;
	private Stage stage;

	public MainPageUpdateView(MainPageView view, CatatanHarianUtama catatan) { 
		this.catatan = catatan;
		this.view = view;
		init(); 
		arrangeComponent(); 
		stage = new Stage();
		stage.setTitle("Update Catatan Harian");
		
		stage.setScene(scene);
		stage.show(); 
		
		new MainPageUpdateController(this);
	}
	
	@Override
	public void init() {
	    // Initialize fields and labels
		KodeCatatanLbl = new Label("Kode Catatan"); 
		KodeCatatanTF = new TextField(); 
		KodeCatatanTF.setEditable(false);
		KodeCatatanTF.setText(catatan.getKodeCatatan());

	    KodeKandangLbl = new Label("Kode Kandang*"); 
	    KodeKandang = new TextField();  
	    KodeKandang.setText(catatan.getKodeKandang());
	    
	    KeteranganJenisLbl = new Label("Keterangan Jenis");
	    KeteranganJenisTF = new TextField();
	    KeteranganJenisTF.setText(catatan.getKeteranganJenis());

	    TanggalMasukLbl = new Label("Tanggal Masuk*"); 
	    TanggalMasuk = new DatePicker(catatan.getTanggalMasuk().toLocalDate()); 

	    JumlahAwalJantanLbl = new Label("Jumlah Awal Jantan*"); 
	    JumlahAwalJantan = new TextField();  
	    JumlahAwalJantan.setText(String.valueOf(catatan.getJumlahAwalJantan()));

	    JumlahAwalBetinaLbl = new Label("Jumlah Awal Betina*"); 
	    JumlahAwalBetina = new TextField();  
	    JumlahAwalBetina.setText(String.valueOf(catatan.getJumlahAwalBetina()));

	    KomentarLbl = new Label("Komentar");
	    Komentar = new TextField();
	    Komentar.setText(catatan.getKomentar());

	    // Initialize Save button
	    Save = new Button("Save"); 
	    Save.setFont(Font.font("Inter", 20));
	    Save.setMinWidth(150);
	}
	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		form1.setHgap(10); 
		form1.setVgap(10);  
		form1.add(KodeCatatanLbl, 1, 0); 
		form1.add(KodeCatatanTF, 2, 0);
		form1.add(KodeKandangLbl, 1, 1); 
		form1.add(KodeKandang, 2, 1);
		form1.add(KeteranganJenisLbl, 1, 2); 
		form1.add(KeteranganJenisTF, 2, 2); 
		form1.add(TanggalMasukLbl, 1, 3);
		form1.add(TanggalMasuk, 2, 3); 
		form1.add(JumlahAwalJantanLbl, 1, 4); 
		form1.add(JumlahAwalJantan, 2, 4); 
		form1.add(JumlahAwalBetinaLbl, 1, 5); 
		form1.add(JumlahAwalBetina, 2, 5); 
		form1.add(KomentarLbl, 1, 6); 
		form1.add(Komentar, 2, 6); 
		form1.setAlignment(Pos.CENTER);
		
		bp.setBottom(Save); 
		bp.setCenter(form1);
		BorderPane.setAlignment(Save, Pos.CENTER);
		
		bp.setPadding(new Insets(50));
	
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
	
	public TextField getKodeKandang() {
		return KodeKandang;
	}

	public TextField getKeteranganJenisTF() {
		return KeteranganJenisTF;
	}
	
	public Label getKeteranganJenisLbl() {
		return KeteranganJenisLbl;
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

	public void setKodeKandang(TextField kodeKandang) {
		KodeKandang = kodeKandang;
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

	public MainPageView getView() {
		return view;
	}

	public void setView(MainPageView view) {
		this.view = view;
	}

	public Label getKodeCatatan() {
		return KodeCatatanLbl;
	}

	public void setKodeCatatan(Label kodeCatatan) {
		KodeCatatanLbl = kodeCatatan;
	}

	public TextField getKodeCatatanTF() {
		return KodeCatatanTF;
	}

	public void setKodeCatatanTF(TextField kodeCatatanTF) {
		KodeCatatanTF = kodeCatatanTF;
	}	
}
