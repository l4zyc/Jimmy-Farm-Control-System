package view.CatatanDetail;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	TextField KematianJantanTF, KematianBetinaTF, KodePakanTF, JumlahPakanTF, JumlahObatTF, KodeObatTF, JumlahProduksiTelurTF, BiayaVariabelTF; 
	TextArea KomentarKematianTA;
	Button Save;
	
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
		KodePakanTF = new TextField();
		//Jumlah Pakan
		JumlahPakanLbl = new Label("Jumlah Pakan*"); 
		JumlahPakanTF = new TextField(); 
		//Kode Obat
		KodeObatLbl = new Label("Kode Obat"); 
		KodeObatTF = new TextField(); 
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
		form1.add(KodePakanTF , 2, 3);
		form1.add(JumlahPakanLbl, 1, 4); 
		form1.add(JumlahPakanTF, 2, 4); 
		form1.add(JumlahObatLbl, 1, 5); 
		form1.add(JumlahObatTF, 2, 5); 
		form1.add(JumlahProduksiTelurLbl, 1, 6); 
		form1.add(JumlahProduksiTelurTF, 2, 6); 
		form1.add(BiayaVariabelLbl, 1, 7); 
		form1.add(BiayaVariabelTF , 2, 7);  
		form1.add(KomentarKematianLbl, 1, 8); 
		form1.add(KomentarKematianTA, 2, 8); 
	
		bp.setBottom(Save); 
		bp.setCenter(form1);
		
		KomentarKematianTA.setMaxWidth(150);
		
		bp.setPadding(new Insets(50));
		form1.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(Save, Pos.CENTER);
	}

}
