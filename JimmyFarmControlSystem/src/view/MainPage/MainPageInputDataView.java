package view.MainPage;

import java.sql.Date;

import controller.mainPage.MainPageInputDataController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import util.Data;
import view.ViewTemplate;

public class MainPageInputDataView extends ViewTemplate{
		
	
	BorderPane bp = new BorderPane(); 
	GridPane form1 = new GridPane(); 
	
	BorderPane outerLayout = new BorderPane();
	StackPane leftPane= new StackPane();
	
	Scene scene = new Scene(outerLayout, width * 0.5, height * 0.5);

	Label KodeCatatanLbl, KodeKandangLbl, KeteranganJenisLbl, TanggalMasukLbl, JumlahAwalJantanLbl, JumlahAwalBetinaLbl, KomentarLbl;
	TextField KodeCatatanTF, KeteranganJenis, JumlahAwalJantan, JumlahAwalBetina, Komentar;
	DatePicker TanggalMasuk; 
	Button Save;
	
	Label pageNameLbl;
	Image bgImage;
	BackgroundSize bgSize;
	Background bg;
	
	
	ComboBox<String> KodeKandangCB; 
	
	private MainPageView view;
	private Stage stage;
	

	public MainPageInputDataView(MainPageView view) { 
		this.view = view;
		init(); 
		arrangeComponent(); 
		stage = new Stage();
		stage.setTitle("Input Catatan Harian");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(MainPageView.mainStage);
		
		new MainPageInputDataController(this);
		
		Image icon = new Image("SmallCustomLogoJimmyFarm.png");
		stage.getIcons().add(icon);		
		
		stage.setScene(scene);
		stage.show(); 
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub 
		//Kode Kandang
		KodeKandangLbl = new Label("Kode Kandang*"); 
		KodeKandangCB = new ComboBox(Data.getKodeKandangData());
		//Tanggal Masuk
		TanggalMasukLbl = new Label("Tanggal Masuk*"); 
		TanggalMasuk = new DatePicker();   
		//Keterangan Jenis
		KeteranganJenisLbl = new Label("Keterangan Jenis");
		KeteranganJenis = new TextField();
		//Jumlah Awal Jantan
		JumlahAwalJantanLbl = new Label("Jumlah Awal Jantan*"); 
		JumlahAwalJantan = new TextField();  
		//Jumlah Awal Betina
		JumlahAwalBetinaLbl = new Label("Jumlah Awal Betina*"); 
		JumlahAwalBetina = new TextField();  
		//Komentar
		KomentarLbl = new Label("Komentar");
		Komentar = new TextField();
		
		
		
		pageNameLbl = new Label("Input Data Catatan Harian");
		pageNameLbl.setFont(Font.font("Inter", FontWeight.BOLD, 24));
		pageNameLbl.setWrapText(true);
		pageNameLbl.setMaxWidth(200);
		pageNameLbl.setTextAlignment(TextAlignment.CENTER);
			
		bgImage = new Image("Background2.png");
		bgSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true);
		bg = new Background(new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgSize));

		
	
		//Button Save
		Save = new Button("Save"); 
		Save.setFont(Font.font("Inter", FontWeight.BOLD, 20));
		Save.setPadding(new Insets(10, 20, 10, 16));
		Save.setStyle("-fx-background-color: #000B58; -fx-text-fill: white;");
		Save.setMinWidth(150); 
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub 
		form1.setHgap(10); 
		form1.setVgap(10);  
		form1.add(KodeKandangLbl, 1, 1); 
		form1.add(KodeKandangCB, 2, 1); 
		form1.add(TanggalMasukLbl, 1, 2);
		form1.add(TanggalMasuk, 2, 2);  
		form1.add(KeteranganJenisLbl, 1, 3); 
		form1.add(KeteranganJenis, 2, 3);
		form1.add(JumlahAwalJantanLbl, 1, 4); 
		form1.add(JumlahAwalJantan, 2, 4); 
		form1.add(JumlahAwalBetinaLbl, 1, 5); 
		form1.add(JumlahAwalBetina, 2, 5); 
		form1.add(KomentarLbl, 1, 6); 
		form1.add(Komentar, 2, 6); 
		
		bp.setBottom(Save); 
		bp.setCenter(form1);
		
		
		leftPane.getChildren().add(pageNameLbl);
		leftPane.setPrefWidth(250);
		leftPane.setBackground(bg);
		leftPane.setStyle("-fx-border-width: 0px 1px 0px 0px;"
				+ "-fx-border-color: GREY");
		leftPane.setAlignment(Pos.CENTER);
		
		
		outerLayout.setCenter(bp);
		outerLayout.setLeft(leftPane);
		
		
		bp.setPadding(new Insets(50));
		form1.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(Save, Pos.CENTER);
	}
	
	public Label getKeteranganJenisLbl() {
		return KeteranganJenisLbl;
	}

	public void setKeteranganJenisLbl(Label keteranganJenisLbl) {
		KeteranganJenisLbl = keteranganJenisLbl;
	}

	public MainPageView getView() {
		return view;
	}

	public void setView(MainPageView view) {
		this.view = view;
	}

	public BorderPane getBp() {
		return bp;
	}

	public void setBp(BorderPane bp) {
		this.bp = bp;
	}

	public GridPane getForm1() {
		return form1;
	}

	public void setForm1(GridPane form1) {
		this.form1 = form1;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}


	public Label getKodeKandangLbl() {
		return KodeKandangLbl;
	}

	public void setKodeKandangLbl(Label kodeKandangLbl) {
		KodeKandangLbl = kodeKandangLbl;
	}

	public Label getTanggalMasukLbl() {
		return TanggalMasukLbl;
	}

	public void setTanggalMasukLbl(Label tanggalMasukLbl) {
		TanggalMasukLbl = tanggalMasukLbl;
	}

	public Label getJumlahAwalJantanLbl() {
		return JumlahAwalJantanLbl;
	}

	public void setJumlahAwalJantanLbl(Label jumlahAwalJantanLbl) {
		JumlahAwalJantanLbl = jumlahAwalJantanLbl;
	}

	public Label getJumlahAwalBetinaLbl() {
		return JumlahAwalBetinaLbl;
	}

	public void setJumlahAwalBetinaLbl(Label jumlahAwalBetinaLbl) {
		JumlahAwalBetinaLbl = jumlahAwalBetinaLbl;
	}

	public Label getKomentarLbl() {
		return KomentarLbl;
	}

	public void setKomentarLbl(Label komentarLbl) {
		KomentarLbl = komentarLbl;
	}


	public Label getKodeCatatanLbl() {
		return KodeCatatanLbl;
	}

	public TextField getKodeCatatanTF() {
		return KodeCatatanTF;
	}

	public ComboBox<String> getKodeKandangCB() {
		return KodeKandangCB;
	}

	public void setKodeCatatanLbl(Label kodeCatatanLbl) {
		KodeCatatanLbl = kodeCatatanLbl;
	}

	public void setKodeCatatanTF(TextField kodeCatatanTF) {
		KodeCatatanTF = kodeCatatanTF;
	}

	public void setKodeKandangCB(ComboBox<String> kodeKandangCB) {
		KodeKandangCB = kodeKandangCB;
	}

	public TextField getKeteranganJenis() {
		return KeteranganJenis;
	}

	public void setKeteranganJenis(TextField keteranganJenis) {
		KeteranganJenis = keteranganJenis;
	}

	public TextField getJumlahAwalJantan() {
		return JumlahAwalJantan;
	}

	public void setJumlahAwalJantan(TextField jumlahAwalJantan) {
		JumlahAwalJantan = jumlahAwalJantan;
	}

	public TextField getJumlahAwalBetina() {
		return JumlahAwalBetina;
	}

	public void setJumlahAwalBetina(TextField jumlahAwalBetina) {
		JumlahAwalBetina = jumlahAwalBetina;
	}

	public TextField getKomentar() {
		return Komentar;
	}

	public void setKomentar(TextField komentar) {
		Komentar = komentar;
	}

	public DatePicker getTanggalMasuk() {
		return TanggalMasuk;
	}

	public void setTanggalMasuk(DatePicker tanggalMasuk) {
		TanggalMasuk = tanggalMasuk;
	}

	public Button getSave() {
		return Save;
	}

	public void setSave(Button save) {
		Save = save;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

}
