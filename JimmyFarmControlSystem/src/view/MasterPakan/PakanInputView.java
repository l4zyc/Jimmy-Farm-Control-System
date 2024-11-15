package view.MasterPakan;

import java.sql.Date;

import controller.masterPakan.PakanInputController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.ViewTemplate;

public class PakanInputView extends ViewTemplate{

	BorderPane bp = new BorderPane(); 
	GridPane form1 = new GridPane(); 

	Scene scene = new Scene(bp, width * 0.5, height * 0.5);

	Label KodePakanLbl, NamaPakanLbl, JenisPakanLbl, HargaLbl;
	TextField KodePakanTF, NamaPakanTF, HargaTF;
	Button Save;
	
	ComboBox JenisPakanCB; 
	String JenisPakanS[] = {"Pakan Grower", "Pakan Starter", "Pakan Layer"}; 
	
	private MasterPakanView view;
	private Stage stage;
	
	public PakanInputView(MasterPakanView view) { 
		this.view = view;
		init(); 
		arrangeComponent(); 
		stage = new Stage();
		stage.setTitle("Input Pakan");
		
		stage.setScene(scene);
		stage.show(); 
		
		new PakanInputController(this);
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		//Nama Obat
		KodePakanLbl = new Label("Kode Pakan*"); 
		KodePakanTF = new TextField();  
		//Tanggal Masuk
		NamaPakanLbl = new Label("Nama Pakan*"); 
		NamaPakanTF = new TextField();   
		//Keterangan Jenis
		JenisPakanLbl = new Label("Jenis Pakan*");
		JenisPakanCB = new ComboBox(FXCollections.observableArrayList(JenisPakanS));
		//Jumlah Awal Jantan
		HargaLbl = new Label("Harga*"); 
		HargaTF = new TextField();  
		
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
		form1.add(KodePakanLbl, 1, 1); 
		form1.add(KodePakanTF, 2, 1); 
		form1.add(NamaPakanLbl, 1, 2);
		form1.add(NamaPakanTF, 2, 2);  
		form1.add(JenisPakanLbl, 1, 3); 
		form1.add(JenisPakanCB, 2, 3);
		form1.add(HargaLbl, 1, 4); 
		form1.add(HargaTF, 2, 4); 
		
		
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

	public Label getKodePakanLbl() {
		return KodePakanLbl;
	}

	public Label getNamaPakanLbl() {
		return NamaPakanLbl;
	}

	public Label getJenisPakanLbl() {
		return JenisPakanLbl;
	}

	public Label getHargaLbl() {
		return HargaLbl;
	}

	public TextField getKodePakanTF() {
		return KodePakanTF;
	}

	public TextField getNamaPakanTF() {
		return NamaPakanTF;
	}


	public TextField getHargaTF() {
		return HargaTF;
	}

	public Button getSave() {
		return Save;
	}

	public MasterPakanView getView() {
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

	public void setKodePakanLbl(Label kodePakanLbl) {
		KodePakanLbl = kodePakanLbl;
	}

	public void setNamaPakanLbl(Label namaPakanLbl) {
		NamaPakanLbl = namaPakanLbl;
	}

	public void setJenisPakanLbl(Label jenisPakanLbl) {
		JenisPakanLbl = jenisPakanLbl;
	}

	public void setHargaLbl(Label hargaLbl) {
		HargaLbl = hargaLbl;
	}

	public void setKodePakanTF(TextField kodePakanTF) {
		KodePakanTF = kodePakanTF;
	}

	public void setNamaPakanTF(TextField namaPakanTF) {
		NamaPakanTF = namaPakanTF;
	}
	
	
	
	public ComboBox getJenisPakanCB() {
		return JenisPakanCB;
	}

	public String[] getJenisPakanS() {
		return JenisPakanS;
	}

	public void setJenisPakanCB(ComboBox jenisPakanCB) {
		JenisPakanCB = jenisPakanCB;
	}

	public void setJenisPakanS(String[] jenisPakanS) {
		JenisPakanS = jenisPakanS;
	}

	public void setHargaTF(TextField hargaTF) {
		HargaTF = hargaTF;
	}

	public void setSave(Button save) {
		Save = save;
	}

	public void setView(MasterPakanView view) {
		this.view = view;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
	
}
