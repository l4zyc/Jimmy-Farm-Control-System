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
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.DaftarSupplier;
import view.ViewTemplate;

public class SupplierInputView extends ViewTemplate{

	BorderPane bp = new BorderPane(); 
	GridPane form1 = new GridPane();  

	BorderPane outerLayout = new BorderPane();
	StackPane leftPane= new StackPane();

	
	Scene scene = new Scene(outerLayout, width * 0.5, height * 0.5);

	Label pageNameLbl;
	Image bgImage;
	BackgroundSize bgSize;
	Background bg;
	
	private MasterSupplierView view;
	private Stage stage;
	
	public SupplierInputView(MasterSupplierView view) { 
		this.view = view;
		init(); 
		arrangeComponent(); 
		stage = new Stage();
		stage.setTitle("Input Supplier");
		
		Image icon = new Image("SmallCustomLogoJimmyFarm.png");
		stage.getIcons().add(icon);		
		
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
		
		
		pageNameLbl = new Label("Input Data Master Supplier");
		pageNameLbl.setFont(Font.font("Inter", FontWeight.BOLD, 24));
		pageNameLbl.setWrapText(true);
		pageNameLbl.setMaxWidth(200);
		pageNameLbl.setTextAlignment(TextAlignment.CENTER);
					
		bgImage = new Image("Background2.png");
		bgSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true);
		bg = new Background(new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgSize));
		
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
		form1.add(NamaSupplierLbl, 1, 1);
		form1.add(NamaSupplierTF, 2, 1);
		
		bp.setBottom(Save); 
		bp.setCenter(form1);
		
		bp.setPadding(new Insets(50));
		form1.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(Save, Pos.CENTER); 
		
		leftPane.getChildren().add(pageNameLbl);
		leftPane.setPrefWidth(250);
		leftPane.setBackground(bg);
		leftPane.setStyle("-fx-border-width: 0px 1px 0px 0px;"
				+ "-fx-border-color: GREY");
		leftPane.setAlignment(Pos.CENTER);
				
				
		outerLayout.setCenter(bp);
		outerLayout.setLeft(leftPane);
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
