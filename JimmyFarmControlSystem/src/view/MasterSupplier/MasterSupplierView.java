package view.MasterSupplier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;

import controller.masterSupplier.MasterSupplierController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.CatatanHarianUtama;
import model.DaftarPakan;
import model.DaftarSupplier;
import util.Data;
import view.TableViewTemplate;

public class MasterSupplierView extends TableViewTemplate{

	private Scene scene;
	public Stage SupplierStage;
	
	public MasterSupplierView() {
		// TODO Auto-generated method stub
		init();
		arrangeComponent();
		SupplierStage = new Stage();
		

		SupplierStage.setMaximized(true);
		SupplierStage.setScene(scene);
		
		Image icon = new Image("SmallCustomLogoJimmyFarm.png");
		SupplierStage.getIcons().add(icon);		
		
		SupplierStage.setTitle("Jimmy Farm Control System");
		SupplierStage.show();
		
		new MasterSupplierController(this);
	}
	Image image; 
	ImageView image1;
	Label titleLbl, JFCS; 
	TableView<DaftarSupplier> TableSupplier;
	TableColumn<DaftarSupplier, String> KodeSupplierTC, NamaSupplierTC;
	Button Update, Delete, InputData; //button
	MenuBar mb;  //menubar
	MenuItem Home, LogOut; //isi menu bar 
	Menu action;//Buat action menu bar  
	BorderPane ButtonContainer;
	FileInputStream inputstream; 
	TextField Search1;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		mainLayout = new BorderPane();
		TableLayout = new BorderPane();
		scene = new Scene(mainLayout);  
		
		//Column Kode Pakan
		TableSupplier = new TableView<DaftarSupplier>();
		KodeSupplierTC = new TableColumn<DaftarSupplier, String>("Kode Supplier");
		KodeSupplierTC.setCellValueFactory(new PropertyValueFactory<DaftarSupplier, String>("KodeSupplier")); 
		
		//Column Nama Pakan 
		NamaSupplierTC = new TableColumn<DaftarSupplier, String>("Nama Supplier");
		NamaSupplierTC.setCellValueFactory(new PropertyValueFactory<DaftarSupplier, String>("NamaSupplier"));
		
		TableSupplier.getColumns().addAll(KodeSupplierTC, NamaSupplierTC); 
		TableSupplier.getItems().addAll(data.getMasterSupplierData());
		
		//Bagian button update 
		Update = new Button("Update"); 
		Update.setFont(Font.font("Inter", FontWeight.BOLD, 16));
		Update.setPadding(new Insets(10, 20, 10, 20));
		Update.setMinWidth(50); 
		Update.setStyle("-fx-background-color: #227B94; -fx-text-fill: white;");
		
		//Bagian button Delete 
		Delete = new Button("Delete"); 
		Delete.setFont(Font.font("Inter", FontWeight.BOLD, 16));
		Delete.setPadding(new Insets(10, 20, 10, 20));
		Delete.setMinWidth(50); 
		Delete.setStyle("-fx-background-color: #AF1740; -fx-text-fill: white;");

		
		//Bagian button Input Data 
		InputData = new Button("Input Data"); 
		InputData.setFont(Font.font("Inter", FontWeight.BOLD, 16));
		InputData.setPadding(new Insets(10, 20, 10, 20));
		InputData.setStyle("-fx-background-color: #000B58; -fx-text-fill: white;");
		InputData.setMinWidth(100);

								
		//Bagian Menubar
		mb = new MenuBar();  
		action = new Menu("Action"); 
		Home = new MenuItem("Home"); 
		LogOut = new MenuItem("Log Out"); 
				
		ButtonContainer = new BorderPane();
				
		JFCS = new Label("Jimmy Farm Control System");
		
		Search1 = new TextField(); 
		Search1.setPromptText("Search...");
		Search1.setPadding(new Insets(12));
		
		KodeSupplierTC.prefWidthProperty().bind(TableSupplier.widthProperty().multiply(0.15));
		NamaSupplierTC.prefWidthProperty().bind(TableSupplier.widthProperty().multiply(0.15));
		
		TableSupplier.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		KodeSupplierTC.setStyle("-fx-alignment: CENTER;");
		NamaSupplierTC.setStyle("-fx-alignment: CENTER;");
		
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
		mb.getMenus().add(action);
		action.getItems().addAll(Home, LogOut); 
		
		HBox leftBtnContainer = new HBox();
		HBox rightBtnContainer = new HBox();
		leftBtnContainer.getChildren().addAll(Update, Delete);
		leftBtnContainer.setSpacing(15);
		
		rightBtnContainer.getChildren().addAll(Search1, InputData);
		rightBtnContainer.setSpacing(15);
		
		
		ButtonContainer.setLeft(leftBtnContainer);
		ButtonContainer.setRight(rightBtnContainer);

		
		titleLbl = new Label("Master Supplier");
		titleLbl.setFont(Font.font("Inter", FontWeight.BOLD, 35));
		TableLayout.setTop(titleLbl);
		TableLayout.setCenter(TableSupplier);
		TableLayout.setBottom(ButtonContainer);
		
		
		BorderPane.setMargin(TableSupplier, new Insets(15, 0, 15, 0));
		BorderPane.setAlignment(titleLbl, Pos.CENTER);
		
			
		
		TableLayout.setPadding(new Insets(80));
		getMasterSupplierLbl().setFont(Font.font("Arial", FontWeight.BOLD, 16));
		
		mainLayout.setLeft(getSideBar());
		mainLayout.setTop(mb);
		mainLayout.setCenter(TableLayout);
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Stage getSupplierStage() {
		return SupplierStage;
	}

	public void setSupplierStage(Stage supplierStage) {
		SupplierStage = supplierStage;
	}

	public Label getTitleLbl() {
		return titleLbl;
	}

	public void setTitleLbl(Label titleLbl) {
		this.titleLbl = titleLbl;
	}

	public Label getJFCS() {
		return JFCS;
	}

	public void setJFCS(Label jFCS) {
		JFCS = jFCS;
	}

	public TableView<DaftarSupplier> getTableSupplier() {
		return TableSupplier;
	}

	public void setTableSupplier(TableView<DaftarSupplier> tableSupplier) {
		TableSupplier = tableSupplier;
	}

	public TableColumn<DaftarSupplier, String> getKodeSupplierTC() {
		return KodeSupplierTC;
	}

	public void setKodeSupplierTC(TableColumn<DaftarSupplier, String> kodeSupplierTC) {
		KodeSupplierTC = kodeSupplierTC;
	}

	public TableColumn<DaftarSupplier, String> getNamaSupplierTC() {
		return NamaSupplierTC;
	}

	public void setNamaSupplierTC(TableColumn<DaftarSupplier, String> namaSupplierTC) {
		NamaSupplierTC = namaSupplierTC;
	}

	public Button getUpdate() {
		return Update;
	}

	public void setUpdate(Button update) {
		Update = update;
	}

	public Button getDelete() {
		return Delete;
	}

	public void setDelete(Button delete) {
		Delete = delete;
	}

	public Button getInputData() {
		return InputData;
	}

	public void setInputData(Button inputData) {
		InputData = inputData;
	}

	public MenuBar getMb() {
		return mb;
	}

	public void setMb(MenuBar mb) {
		this.mb = mb;
	}

	public MenuItem getHome() {
		return Home;
	}

	public void setHome(MenuItem home) {
		Home = home;
	}

	public MenuItem getLogOut() {
		return LogOut;
	}

	public void setLogOut(MenuItem logOut) {
		LogOut = logOut;
	}

	public Menu getAction() {
		return action;
	}

	public void setAction(Menu action) {
		this.action = action;
	}

	public BorderPane getButtonContainer() {
		return ButtonContainer;
	}

	public void setButtonContainer(BorderPane buttonContainer) {
		ButtonContainer = buttonContainer;
	}

	public Image getImage() {
		return image;
	}

	public ImageView getImage1() {
		return image1;
	}

	public FileInputStream getInputstream() {
		return inputstream;
	}

	public TextField getSearch1() {
		return Search1;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setImage1(ImageView image1) {
		this.image1 = image1;
	}

	public void setInputstream(FileInputStream inputstream) {
		this.inputstream = inputstream;
	}

	public void setSearch1(TextField search1) {
		Search1 = search1;
	}
	
	
	
}
