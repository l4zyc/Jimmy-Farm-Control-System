package view.MasterPakan;

import java.sql.Date;

import controller.masterPakan.MasterPakanController;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;
import model.CatatanHarianUtama;
import model.DaftarPakan;
import util.Data;
import util.reusableMethod;
import view.TableViewTemplate;


public class MasterPakanView extends TableViewTemplate{

	private Scene scene;
	public Stage PakanStage;
	private Data data = new Data();
	
	
	public MasterPakanView() {
		// TODO Auto-generated method stub
		init();
		arrangeComponent();
		PakanStage = new Stage();
		
		Image icon = new Image("SmallCustomLogoJimmyFarm.png");
		PakanStage.getIcons().add(icon);		
		
		PakanStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				if (reusableMethod.confirmationAlert("Exit", "Are you sure you want to quit ?").get().equals(ButtonType.CANCEL)) {
					event.consume();
				}
			}
		});
		
		PakanStage.setMaximized(true);
		PakanStage.setScene(scene);
		PakanStage.setTitle("Jimmy Farm Control System");
		PakanStage.show();
		
		new MasterPakanController(this);
	}

	Label CatatanHarianLbl, JFCS; 
	TableView<DaftarPakan> TablePakan;
	TableColumn<DaftarPakan, String> KodePakanTC, NamaPakanTC, JenisPakanTC, KodeSupplierTC;
	TableColumn<DaftarPakan, Integer> HargaTC; 
	Button Update, Delete, InputData; //button
	 
	TextField Search;
	
	BorderPane ButtonContainer;
	
	MenuBar mb;  //menubar
	MenuItem Home, LogOut; //isi menu bar 
	Menu action;//Buat action menu bar 

	@Override
	public void init() {
		// TODO Auto-generated method stub
		mainLayout = new BorderPane();
		TableLayout = new BorderPane();
		scene = new Scene(mainLayout); 

		
		//Column Kode Pakan
		TablePakan = new TableView<DaftarPakan>();
		KodePakanTC = new TableColumn<DaftarPakan, String>("Kode Pakan");
		KodePakanTC.setCellValueFactory(new PropertyValueFactory<DaftarPakan, String>("kodePakan")); 
		
		//Column Nama Pakan
		NamaPakanTC = new TableColumn<DaftarPakan, String>("Nama Pakan");
		NamaPakanTC.setCellValueFactory(new PropertyValueFactory<DaftarPakan, String>("namaPakan")); 
		
		//Column Jenis Pakan
		JenisPakanTC = new TableColumn<DaftarPakan, String>("Jenis Pakan");
		JenisPakanTC.setCellValueFactory(new PropertyValueFactory<DaftarPakan, String>("jenisPakan")); 
		
		//Column Harga
		HargaTC = new TableColumn<DaftarPakan, Integer>("Harga");
		HargaTC.setCellValueFactory(new PropertyValueFactory<DaftarPakan, Integer>("Harga")); 
		
		KodeSupplierTC = new TableColumn<DaftarPakan, String>("Kode Supplier");
		KodeSupplierTC.setCellValueFactory(new PropertyValueFactory<DaftarPakan, String>("KodeSupplier")); 
	
		
		TablePakan.getColumns().addAll(KodePakanTC, 
		NamaPakanTC, 
		JenisPakanTC, 
		HargaTC, KodeSupplierTC); 
		
		TablePakan.getItems().addAll(data.getMasterPakanData());
		
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

			
		Search = new TextField(); 
		Search.setPromptText("Search...");
		Search.setPadding(new Insets(5));
		
						
		ButtonContainer = new BorderPane();
		
		mb = new MenuBar();  
		action = new Menu("Action"); 
		Home = new MenuItem("Home"); 
		LogOut = new MenuItem("Log Out"); 
		
		JFCS = new Label("Jimmy Farm Control System");
		
		KodePakanTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.20));
		NamaPakanTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.20));
		JenisPakanTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.20));
		HargaTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.20));
		KodeSupplierTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.20));
		
		TablePakan.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		KodePakanTC.setStyle("-fx-alignment: CENTER;");
		NamaPakanTC.setStyle("-fx-alignment: CENTER;");
		JenisPakanTC.setStyle("-fx-alignment: CENTER;");
		HargaTC.setStyle("-fx-alignment: CENTER;");
		KodeSupplierTC.setStyle("-fx-alignment: CENTER;");
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
		
		rightBtnContainer.getChildren().addAll(InputData);
		rightBtnContainer.setSpacing(15);
		
		
		ButtonContainer.setLeft(leftBtnContainer);
		ButtonContainer.setRight(rightBtnContainer);

		
		CatatanHarianLbl = new Label("Master Pakan");
		CatatanHarianLbl.setFont(Font.font("Inter", FontWeight.BOLD, 35));
		
		HBox TitleContainer = new HBox(); 
		TitleContainer.getChildren().addAll(CatatanHarianLbl, Search);
		TitleContainer.setAlignment(Pos.TOP_RIGHT); 
		TitleContainer.setSpacing(350);
		
		
		TableLayout.setTop(TitleContainer);
		TableLayout.setCenter(TablePakan);
		TableLayout.setBottom(ButtonContainer);
		
		BorderPane.setMargin(TablePakan, new Insets(15, 0, 15, 0));
		BorderPane.setAlignment(CatatanHarianLbl, Pos.CENTER);
	
		
		TableLayout.setPadding(new Insets(80));
		getMasterPakanLbl().setFont(Font.font("Inter", FontWeight.BOLD, 16));
		
		mainLayout.setTop(mb);
		mainLayout.setCenter(TableLayout);
		mainLayout.setLeft(getSideBar());
	}


	public Scene getScene() {
		return scene;
	}

	

	public TextField getSearch() {
		return Search;
	}


	public void setSearch(TextField search) {
		Search = search;
	}


	public void setScene(Scene scene) {
		this.scene = scene;
	}


	public Stage getPakanStage() {
		return PakanStage;
	}


	public void setPakanStage(Stage pakanStage) {
		PakanStage = pakanStage;
	}


	public Data getData() {
		return data;
	}


	public void setData(Data data) {
		this.data = data;
	}


	public Label getCatatanHarianLbl() {
		return CatatanHarianLbl;
	}


	public void setCatatanHarianLbl(Label catatanHarianLbl) {
		CatatanHarianLbl = catatanHarianLbl;
	}


	public Label getJFCS() {
		return JFCS;
	}


	public void setJFCS(Label jFCS) {
		JFCS = jFCS;
	}


	public TableView<DaftarPakan> getTablePakan() {
		return TablePakan;
	}


	public void setTablePakan(TableView<DaftarPakan> tablePakan) {
		TablePakan = tablePakan;
	}


	public TableColumn<DaftarPakan, String> getKodePakanTC() {
		return KodePakanTC;
	}


	public void setKodePakanTC(TableColumn<DaftarPakan, String> kodePakanTC) {
		KodePakanTC = kodePakanTC;
	}


	public TableColumn<DaftarPakan, String> getNamaPakanTC() {
		return NamaPakanTC;
	}


	public void setNamaPakanTC(TableColumn<DaftarPakan, String> namaPakanTC) {
		NamaPakanTC = namaPakanTC;
	}


	public TableColumn<DaftarPakan, String> getJenisPakanTC() {
		return JenisPakanTC;
	}


	public void setJenisPakanTC(TableColumn<DaftarPakan, String> jenisPakanTC) {
		JenisPakanTC = jenisPakanTC;
	}


	public TableColumn<DaftarPakan, Integer> getHargaTC() {
		return HargaTC;
	}


	public void setHargaTC(TableColumn<DaftarPakan, Integer> hargaTC) {
		HargaTC = hargaTC;
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


	public BorderPane getButtonContainer() {
		return ButtonContainer;
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


	public TableColumn<DaftarPakan, String> getKodeSupplierTC() {
		return KodeSupplierTC;
	}


	public void setKodeSupplierTC(TableColumn<DaftarPakan, String> kodeSupplierTC) {
		KodeSupplierTC = kodeSupplierTC;
	}
	
	

}
