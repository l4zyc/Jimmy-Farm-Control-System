package view.MainPage;

import controller.mainPage.MainPageUpdateController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.CatatanHarianUtama;
import util.Data;
import view.ViewTemplate;

public class MainPageUpdateView extends ViewTemplate{
	BorderPane bp = new BorderPane(); 
	GridPane form1 = new GridPane(); 
	
	BorderPane outerLayout = new BorderPane();
	StackPane leftPane= new StackPane();

	Scene scene = new Scene(outerLayout, width * 0.5, height * 0.5);

	Label KodeCatatanLbl, KodeKandangLbl, KeteranganJenisLbl, TanggalMasukLbl, JumlahAwalJantanLbl, JumlahAwalBetinaLbl, KomentarLbl;
	TextField KodeCatatanTF, KeteranganJenisTF, JumlahAwalJantan, JumlahAwalBetina, Komentar;
	DatePicker TanggalMasuk; 
	Button Save;
	
	ComboBox KodeKandang;
	
	
	Label pageNameLbl;
	Image bgImage;
	BackgroundSize bgSize;
	Background bg;
	
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
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(MainPageView.mainStage);
		Image icon = new Image("SmallCustomLogoJimmyFarm.png");
		stage.getIcons().add(icon);		
		
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
	    KodeKandang = new ComboBox(Data.getKodeKandangData());  
	    KodeKandang.setValue(catatan.getKodeKandang());
	    
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
	    
	    pageNameLbl = new Label("Update Data Catatan Harian");
	    pageNameLbl.setFont(Font.font("Inter", FontWeight.BOLD, 24));
	    pageNameLbl.setWrapText(true);
	    pageNameLbl.setMaxWidth(200);
	    pageNameLbl.setTextAlignment(TextAlignment.CENTER);
	    			
	    bgImage = new Image("Background2.png");
	    bgSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true);
		bg = new Background(new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgSize));


	    // Initialize Save button
		Save = new Button("Save"); 
		Save.setFont(Font.font("Inter", FontWeight.BOLD, 20));
		Save.setPadding(new Insets(10, 20, 10, 16));
		Save.setStyle("-fx-background-color: #227B94; -fx-text-fill: white;");
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
		
		leftPane.getChildren().add(pageNameLbl);
		leftPane.setPrefWidth(250);
		leftPane.setBackground(bg);
		leftPane.setStyle("-fx-border-width: 0px 1px 0px 0px;"
				+ "-fx-border-color: GREY");
		leftPane.setAlignment(Pos.CENTER);
				
				
		outerLayout.setCenter(bp);
		outerLayout.setLeft(leftPane);
		
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

	
	public Label getKodeCatatanLbl() {
		return KodeCatatanLbl;
	}

	public ComboBox getKodeKandang() {
		return KodeKandang;
	}

	public CatatanHarianUtama getCatatan() {
		return catatan;
	}

	public void setKodeCatatanLbl(Label kodeCatatanLbl) {
		KodeCatatanLbl = kodeCatatanLbl;
	}

	public void setKeteranganJenisLbl(Label keteranganJenisLbl) {
		KeteranganJenisLbl = keteranganJenisLbl;
	}

	public void setKeteranganJenisTF(TextField keteranganJenisTF) {
		KeteranganJenisTF = keteranganJenisTF;
	}

	public void setKodeKandang(ComboBox kodeKandang) {
		KodeKandang = kodeKandang;
	}

	public void setCatatan(CatatanHarianUtama catatan) {
		this.catatan = catatan;
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
