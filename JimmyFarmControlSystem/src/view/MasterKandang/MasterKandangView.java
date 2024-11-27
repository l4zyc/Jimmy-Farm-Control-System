package view.MasterKandang;

import controller.masterKandang.MasterKandangController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.MsKandang;
import util.Data;
import view.TableViewTemplate;

public class MasterKandangView extends TableViewTemplate{

	private Scene scene;
	private Stage KandangStage;
	
	public MasterKandangView() { 
		setSideBar();
		init();
		arrangeComponent();
		KandangStage = new Stage();
		
		KandangStage.setMaximized(true);
		KandangStage.setScene(scene);
		
		Image icon = new Image("SmallCustomLogoJimmyFarm.png");
		KandangStage.getIcons().add(icon);		
		
		KandangStage.setTitle("Jimmy Farm Control System");
		KandangStage.show();
		
		new MasterKandangController(this);
	}
	
	Label CatatanHarianLbl, JFCS; 
	TableView<MsKandang> TableKandang;
	TableColumn<MsKandang, String> KodeKandangTC, LokasiTC;
	Button Update, Delete, InputData; //button
	BorderPane ButtonContainer;
	
	TextField Search;
	
	MenuBar mb;  //menubar
	MenuItem Home, LogOut; //isi menu bar 
	Menu action;//Buat action menu bar 
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		mainLayout = new BorderPane();
		TableLayout = new BorderPane();
		scene = new Scene(mainLayout);  

		
		//Column Kode Kandang
		TableKandang = new TableView<MsKandang>();
		KodeKandangTC = new TableColumn<MsKandang, String>("Kode Kandang");
		KodeKandangTC.setCellValueFactory(new PropertyValueFactory<MsKandang, String>("KodeKandang")); 
				
		//Column Nama Kandang 
		LokasiTC = new TableColumn<MsKandang, String>("Lokasi");
		LokasiTC.setCellValueFactory(new PropertyValueFactory<MsKandang, String>("Lokasi"));
				
		TableKandang.getColumns().addAll(KodeKandangTC, LokasiTC); 
		TableKandang.getItems().addAll(data.getMasterKandangData());
		
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
										
		ButtonContainer = new BorderPane();
						
		//Bagian Menubar
		mb = new MenuBar();  
		action = new Menu("Action"); 
		Home = new MenuItem("Home"); 
		LogOut = new MenuItem("Log Out"); 
		
		Search = new TextField(); 
		Search.setPromptText("Search...");
		Search.setPadding(new Insets(12));

		
		JFCS = new Label("Jimmy Farm Control System"); 
		
		TableKandang.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); 
		
		KodeKandangTC.setStyle("-fx-alignment: CENTER;");
		LokasiTC.setStyle("-fx-alignment: CENTER;");
		
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
		mb.getMenus().add(action); 
		action.getItems().addAll(Home, LogOut);
		
		ButtonContainer = new BorderPane();
		HBox leftBtnContainer = new HBox();
		leftBtnContainer.getChildren().addAll(Update, Delete);
		leftBtnContainer.setSpacing(15);
		
		HBox rightBtnContainer = new HBox();
		rightBtnContainer.getChildren().addAll(Search, InputData);
		rightBtnContainer.setSpacing(15);
		
		ButtonContainer.setLeft(leftBtnContainer);
		ButtonContainer.setRight(rightBtnContainer);
		ButtonContainer.setPadding(new Insets(10));
		
		CatatanHarianLbl = new Label("Master Kandang");
		CatatanHarianLbl.setFont(Font.font("Inter", FontWeight.BOLD, 35));
		
		TableLayout.setTop(CatatanHarianLbl);
		TableLayout.setCenter(TableKandang);
		TableLayout.setBottom(ButtonContainer);
		
		BorderPane.setMargin(TableKandang, new Insets(15, 0, 15, 0));
		BorderPane.setAlignment(CatatanHarianLbl, Pos.CENTER);
		
		
		TableLayout.setPadding(new Insets(80));
		getMasterKandangLbl().setFont(Font.font("Inter", FontWeight.BOLD, 16));
		
		mainLayout.setTop(getMb());
		mainLayout.setCenter(TableLayout);
		mainLayout.setLeft(getSideBar());
	}

	public Scene getScene() {
		return scene;
	}

	public Stage getKandangStage() {
		return KandangStage;
	}

	public Data getData() {
		return data;
	}


	public Label getCatatanHarianLbl() {
		return CatatanHarianLbl;
	}

	public Label getJFCS() {
		return JFCS;
	}

	public TableView<MsKandang> getTableKandang() {
		return TableKandang;
	}

	public TableColumn<MsKandang, String> getKodeKandangTC() {
		return KodeKandangTC;
	}

	public TableColumn<MsKandang, String> getLokasiTC() {
		return LokasiTC;
	}

	public Button getUpdate() {
		return Update;
	}
	
	public TextField getSearch() {
		return Search;
	}

	public void setSearch(TextField search) {
		Search = search;
	}

	public Button getDelete() {
		return Delete;
	}

	public Button getInputData() {
		return InputData;
	}

	public BorderPane getButtonContainer() {
		return ButtonContainer;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public void setKandangStage(Stage kandangStage) {
		KandangStage = kandangStage;
	}

	public void setData(Data data) {
		this.data = data;
	}


	public void setCatatanHarianLbl(Label catatanHarianLbl) {
		CatatanHarianLbl = catatanHarianLbl;
	}

	public void setJFCS(Label jFCS) {
		JFCS = jFCS;
	}

	public void setTableKandang(TableView<MsKandang> tableKandang) {
		TableKandang = tableKandang;
	}

	public void setKodeKandangTC(TableColumn<MsKandang, String> kodeKandangTC) {
		KodeKandangTC = kodeKandangTC;
	}

	public void setLokasiTC(TableColumn<MsKandang, String> lokasiTC) {
		LokasiTC = lokasiTC;
	}

	public void setUpdate(Button update) {
		Update = update;
	}

	public void setDelete(Button delete) {
		Delete = delete;
	}

	public void setInputData(Button inputData) {
		InputData = inputData;
	}

	public void setButtonContainer(BorderPane buttonContainer) {
		ButtonContainer = buttonContainer;
	}

	public MenuBar getMb() {
		return mb;
	}

	public MenuItem getHome() {
		return Home;
	}

	public MenuItem getLogOut() {
		return LogOut;
	}

	public Menu getAction() {
		return action;
	}

	public void setMb(MenuBar mb) {
		this.mb = mb;
	}

	public void setHome(MenuItem home) {
		Home = home;
	}

	public void setLogOut(MenuItem logOut) {
		LogOut = logOut;
	}

	public void setAction(Menu action) {
		this.action = action;
	}

	
	
}
