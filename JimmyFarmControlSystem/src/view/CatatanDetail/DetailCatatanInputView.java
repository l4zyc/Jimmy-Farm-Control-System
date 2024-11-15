package view.CatatanDetail;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.ViewTemplate;
import view.MainPage.MainPageView;


public class DetailCatatanInputView extends ViewTemplate{

	BorderPane bp = new BorderPane(); 
	GridPane form1 = new GridPane(); 

	Scene scene = new Scene(bp, width * 0.5, height * 0.5);

	Label KematianJantanLbl, KematianBetinaLbl, KodePakanLbl, JumlahPakanLbl, JumlahObatLbl, KodeObatLbl, JumlahProduksiTelurLbl, BiayaVariabelLbl, KomentarKematianLbl;
	TextField KematianJantanTF, KematianBetinaTF, JumlahPakanTF, JumlahObatTF, JumlahProduksiTelurTF, BiayaVariabelTF; 
	TextArea KomentarKematianTA;
	Button Save;
	
	ComboBox KodePakanCB, KodeObatCB;
	
	private Stage stage;
	
	public DetailCatatanInputView() {
		init(); 
		arrangeComponent(); 
		stage = new Stage();
		stage.setTitle("Input Catatan Harian Detail");
		
		stage.setScene(scene);
		stage.show(); 
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub 
		//Kematian Jantan
		KematianJantanLbl = new Label("Kematian Jantan*"); 
		KematianJantanTF = new TextField();  
		//Kematian Betina
		KematianBetinaLbl = new Label("Kematian Betina*"); 
		KematianBetinaTF = new TextField();   
		//Kode Pakan
		KodePakanLbl = new Label("Kode Pakan*"); 
		KodePakanCB = new ComboBox(data.getKodePakanData());
		//Jumlah Pakan
		JumlahPakanLbl = new Label("Jumlah Pakan*"); 
		JumlahPakanTF = new TextField(); 
		//Kode Obat
		KodeObatLbl = new Label("Kode Obat"); 
		KodeObatCB = new ComboBox(data.getKodeObatData());  
		//Jumlah Obat
		JumlahObatLbl = new Label("Jumlah Obat"); 
		JumlahObatTF = new TextField(); 
		//Jumlah Produksi Telur
		JumlahProduksiTelurLbl = new Label("Jumlah Produksi Telur"); 
		JumlahProduksiTelurTF = new TextField(); 
		//Biata Variabel
		BiayaVariabelLbl = new Label("Biaya Variabel"); 
		BiayaVariabelTF = new TextField();
		//Komentar Kematian
		KomentarKematianLbl = new Label("Komentar");
		KomentarKematianTA = new TextArea();
		
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
		form1.add(KematianJantanLbl, 1, 1); 
		form1.add(KematianJantanTF, 2, 1); 
		form1.add(KematianBetinaLbl, 1, 2);
		form1.add(KematianBetinaTF, 2, 2);  
		form1.add(KodePakanLbl , 1, 3); 
		form1.add(KodePakanCB , 2, 3);
		form1.add(JumlahPakanLbl, 1, 4); 
		form1.add(JumlahPakanTF, 2, 4);  
		form1.add(KodeObatLbl, 1, 5); 
		form1.add(KodeObatCB, 2, 5);
		form1.add(JumlahObatLbl, 1, 6); 
		form1.add(JumlahObatTF, 2, 6); 
		form1.add(JumlahProduksiTelurLbl, 1, 7); 
		form1.add(JumlahProduksiTelurTF, 2, 7); 
		form1.add(BiayaVariabelLbl, 1, 8); 
		form1.add(BiayaVariabelTF , 2, 8);  
		form1.add(KomentarKematianLbl, 1, 9); 
		form1.add(KomentarKematianTA, 2, 9); 
	
		bp.setBottom(Save); 
		bp.setCenter(form1);
		
		KomentarKematianTA.setMaxWidth(150);
		
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

	public Scene getScene() {
		return scene;
	}

	public Label getKematianJantanLbl() {
		return KematianJantanLbl;
	}

	public Label getKematianBetinaLbl() {
		return KematianBetinaLbl;
	}

	public Label getKodePakanLbl() {
		return KodePakanLbl;
	}

	public Label getJumlahPakanLbl() {
		return JumlahPakanLbl;
	}

	public Label getJumlahObatLbl() {
		return JumlahObatLbl;
	}

	public Label getKodeObatLbl() {
		return KodeObatLbl;
	}

	public Label getJumlahProduksiTelurLbl() {
		return JumlahProduksiTelurLbl;
	}

	public Label getBiayaVariabelLbl() {
		return BiayaVariabelLbl;
	}

	public Label getKomentarKematianLbl() {
		return KomentarKematianLbl;
	}

	public TextField getKematianJantanTF() {
		return KematianJantanTF;
	}

	public TextField getKematianBetinaTF() {
		return KematianBetinaTF;
	}

	public TextField getJumlahPakanTF() {
		return JumlahPakanTF;
	}

	public TextField getJumlahObatTF() {
		return JumlahObatTF;
	}

	public TextField getJumlahProduksiTelurTF() {
		return JumlahProduksiTelurTF;
	}

	public TextField getBiayaVariabelTF() {
		return BiayaVariabelTF;
	}

	public TextArea getKomentarKematianTA() {
		return KomentarKematianTA;
	}

	public Button getSave() {
		return Save;
	}

	public ComboBox getKodePakanCB() {
		return KodePakanCB;
	}

	public ComboBox getKodeObatCB() {
		return KodeObatCB;
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

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public void setKematianJantanLbl(Label kematianJantanLbl) {
		KematianJantanLbl = kematianJantanLbl;
	}

	public void setKematianBetinaLbl(Label kematianBetinaLbl) {
		KematianBetinaLbl = kematianBetinaLbl;
	}

	public void setKodePakanLbl(Label kodePakanLbl) {
		KodePakanLbl = kodePakanLbl;
	}

	public void setJumlahPakanLbl(Label jumlahPakanLbl) {
		JumlahPakanLbl = jumlahPakanLbl;
	}

	public void setJumlahObatLbl(Label jumlahObatLbl) {
		JumlahObatLbl = jumlahObatLbl;
	}

	public void setKodeObatLbl(Label kodeObatLbl) {
		KodeObatLbl = kodeObatLbl;
	}

	public void setJumlahProduksiTelurLbl(Label jumlahProduksiTelurLbl) {
		JumlahProduksiTelurLbl = jumlahProduksiTelurLbl;
	}

	public void setBiayaVariabelLbl(Label biayaVariabelLbl) {
		BiayaVariabelLbl = biayaVariabelLbl;
	}

	public void setKomentarKematianLbl(Label komentarKematianLbl) {
		KomentarKematianLbl = komentarKematianLbl;
	}

	public void setKematianJantanTF(TextField kematianJantanTF) {
		KematianJantanTF = kematianJantanTF;
	}

	public void setKematianBetinaTF(TextField kematianBetinaTF) {
		KematianBetinaTF = kematianBetinaTF;
	}

	public void setJumlahPakanTF(TextField jumlahPakanTF) {
		JumlahPakanTF = jumlahPakanTF;
	}

	public void setJumlahObatTF(TextField jumlahObatTF) {
		JumlahObatTF = jumlahObatTF;
	}

	public void setJumlahProduksiTelurTF(TextField jumlahProduksiTelurTF) {
		JumlahProduksiTelurTF = jumlahProduksiTelurTF;
	}

	public void setBiayaVariabelTF(TextField biayaVariabelTF) {
		BiayaVariabelTF = biayaVariabelTF;
	}

	public void setKomentarKematianTA(TextArea komentarKematianTA) {
		KomentarKematianTA = komentarKematianTA;
	}

	public void setSave(Button save) {
		Save = save;
	}

	public void setKodePakanCB(ComboBox kodePakanCB) {
		KodePakanCB = kodePakanCB;
	}

	public void setKodeObatCB(ComboBox kodeObatCB) {
		KodeObatCB = kodeObatCB;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	
	
}
