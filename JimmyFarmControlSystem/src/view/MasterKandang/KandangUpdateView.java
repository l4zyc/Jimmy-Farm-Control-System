package view.MasterKandang;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.DaftarSupplier;
import model.MsKandang;
import view.ViewTemplate;

public class KandangUpdateView extends ViewTemplate{ 
	
	BorderPane bp = new BorderPane(); 
	GridPane form1 = new GridPane(); 

	Scene scene = new Scene(bp, width * 0.5, height * 0.5);

	
	private MasterKandangView view;
	private Stage stage; 
	private MsKandang kandang;  
	
	public KandangUpdateView(MasterKandangView view, MsKandang kandang) { 
		
		this.view = view;
		this.kandang = kandang;
		init(); 
		arrangeComponent(); 
		stage = new Stage();
		stage.setTitle("Input Supplier*");
		
		stage.setScene(scene);
		stage.show(); 
		
		
	}
	
	Label KodeKandangLbl, LokasiLbl;
	TextField KodeKandangTF, LokasiTF; 
	Button Save;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		KodeKandangLbl = new Label("Kode Kandang*"); 
		KodeKandangTF = new TextField(); 
		
		LokasiLbl = new Label("Lokasi*"); 
		LokasiTF = new TextField();
		
		Save = new Button("Save"); 
		Save.setFont(Font.font("Inter", 20));
		Save.setMinWidth(150); 	
	}
	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		form1.setHgap(10); 
		form1.setVgap(10);   
		form1.add(KodeKandangLbl, 1, 1);
		form1.add(KodeKandangTF, 2, 1);
		form1.add(KodeKandangLbl, 1, 2);
		form1.add(KodeKandangTF, 2, 2); 
		
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
	public MasterKandangView getView() {
		return view;
	}
	public Stage getStage() {
		return stage;
	}
	public MsKandang getKandang() {
		return kandang;
	}
	public Label getKodeKandangLbl() {
		return KodeKandangLbl;
	}
	public Label getLokasiLbl() {
		return LokasiLbl;
	}
	public TextField getKodeKandangTF() {
		return KodeKandangTF;
	}
	public TextField getLokasiTF() {
		return LokasiTF;
	}
	public Button getSave() {
		return Save;
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
	public void setView(MasterKandangView view) {
		this.view = view;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public void setKandang(MsKandang kandang) {
		this.kandang = kandang;
	}
	public void setKodeKandangLbl(Label kodeKandangLbl) {
		KodeKandangLbl = kodeKandangLbl;
	}
	public void setLokasiLbl(Label lokasiLbl) {
		LokasiLbl = lokasiLbl;
	}
	public void setKodeKandangTF(TextField kodeKandangTF) {
		KodeKandangTF = kodeKandangTF;
	}
	public void setLokasiTF(TextField lokasiTF) {
		LokasiTF = lokasiTF;
	}
	public void setSave(Button save) {
		Save = save;
	}
	
	
	
}
