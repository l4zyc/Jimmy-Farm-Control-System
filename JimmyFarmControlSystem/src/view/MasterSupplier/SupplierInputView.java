package view.MasterSupplier;

import java.sql.Date;

import controller.masterSupplier.SupplierInputController;
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
import view.ViewTemplate;

public class SupplierInputView extends ViewTemplate{

	BorderPane bp = new BorderPane(); 
	GridPane form1 = new GridPane();  

	Scene scene = new Scene(bp, width * 0.5, height * 0.5);

	
	private MasterSupplierView view;
	private Stage stage;
	
	public SupplierInputView(MasterSupplierView view) { 
		this.view = view;
		init(); 
		arrangeComponent(); 
		stage = new Stage();
		stage.setTitle("Input Supplier");
		
		stage.setScene(scene);
		stage.show(); 
		new SupplierInputController(this);
	}
	 
	Label NamaSupplierLbl;
	TextField NamaSupplierTF; 
	Button Save;
	@Override
	
	public void init() { 
		// TODO Auto-generated method stub
		
		NamaSupplierLbl = new Label("Nama Supplier"); 
		NamaSupplierTF = new TextField();
		
		Save = new Button("Save"); 
		Save.setFont(Font.font("Inter", 20));
		Save.setMinWidth(150); 	
	}
	
	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		form1.setHgap(10); 
		form1.setVgap(10);   
		form1.add(NamaSupplierLbl, 1, 1);
		form1.add(NamaSupplierTF, 2, 1);
		
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

	public MasterSupplierView getView() {
		return view;
	}

	public Stage getStage() {
		return stage;
	}

	public Label getNamaSupplierLbl() {
		return NamaSupplierLbl;
	}

	public TextField getNamaSupplierTF() {
		return NamaSupplierTF;
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

	public void setView(MasterSupplierView view) {
		this.view = view;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setNamaSupplierLbl(Label namaSupplierLbl) {
		NamaSupplierLbl = namaSupplierLbl;
	}

	public void setNamaSupplierTC(TextField namaSupplierTF) {
		NamaSupplierTF = namaSupplierTF;
	}

	public void setSave(Button save) {
		Save = save;
	}

}
