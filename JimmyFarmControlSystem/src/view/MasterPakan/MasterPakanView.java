package view.MasterPakan;

import java.sql.Date;

import controller.masterPakan.MasterPakanController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.CatatanHarianUtama;
import model.DaftarPakan;
import util.Data;
import view.TableViewTemplate;


public class MasterPakanView extends TableViewTemplate{

	private Scene scene;
	public Stage PakanStage;
	private Data data = new Data();
	
	
	public MasterPakanView() {
		// TODO Auto-generated method stub
		setSideBar();
		init();
		arrangeComponent();
		PakanStage = new Stage();
		
		PakanStage.setMaximized(true);
		PakanStage.setScene(scene);
		PakanStage.setTitle("Jimmy Farm Control System");
		PakanStage.show();
		
		new MasterPakanController(this);
	}

	Label CatatanHarianLbl, JFCS; 
	TableView<DaftarPakan> TablePakan;
	TableColumn<DaftarPakan, String> KodePakanTC, NamaPakanTC, JenisPakanTC;
	TableColumn<DaftarPakan, Integer> HargaTC; 
	Button Update, Delete, InputData; //button
	MenuBar mb;  //menubar
	MenuItem Home, LogOut; //isi menu bar 
	Menu action;//Buat action menu bar 
	
	//Daftar tabel samping
	Label DaftarTabel, CatatanHarianLbl2, MasterPakanLbl, MasterObatLbl, MasterSupplierLbl, MasterKandangLbl; 
	HBox CatatanHarian, MasterPakan, MasterObat, MasterSupplier, MasterKandang, ButtonContainer;
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		mainLayout = new BorderPane();
		TableLayout = new BorderPane();
		scene = new Scene(mainLayout); 
		
		//Column Kode Pakan
		TablePakan = new TableView<DaftarPakan>();
		KodePakanTC = new TableColumn<DaftarPakan, String>("Kode Pakan");
		KodePakanTC.setCellValueFactory(new PropertyValueFactory<DaftarPakan, String>("Kode Pakan")); 
		
		//Column Nama Pakan
		NamaPakanTC = new TableColumn<DaftarPakan, String>("Nama Pakan");
		NamaPakanTC.setCellValueFactory(new PropertyValueFactory<DaftarPakan, String>("Nama Pakan")); 
		
		//Column Jenis Pakan
		JenisPakanTC = new TableColumn<DaftarPakan, String>("Jenis Pakan");
		JenisPakanTC.setCellValueFactory(new PropertyValueFactory<DaftarPakan, String>("Jenis Pakan")); 
		
		//Column Harga
		HargaTC = new TableColumn<DaftarPakan, Integer>("Harga");
		HargaTC.setCellValueFactory(new PropertyValueFactory<DaftarPakan, Integer>("Harga")); 
		
		TablePakan.getColumns().addAll(KodePakanTC, 
		NamaPakanTC, 
		JenisPakanTC, 
		HargaTC); 
		
		//Bagian button update 
		Update = new Button("Update"); 
		Update.setFont(Font.font("Inter", 20)); 
		Update.setMinWidth(50); 
						
		//Bagian button Delete 
		Delete = new Button("Delete"); 
		Delete.setFont(Font.font("Inter", 20)); 
		Delete.setMinWidth(50); 
						
		//Bagian button Input Data 
		InputData = new Button("Input Data"); 
		InputData.setFont(Font.font("Inter", 20));
		InputData.setMinWidth(50);
						
		//Bagian Menubar
		mb = new MenuBar();  
		action = new Menu("Action"); 
		Home = new MenuItem("Home"); 
		LogOut = new MenuItem("Log Out"); 
						
		ButtonContainer = new HBox();
		
		//Bagian Daftar Tabel
		DaftarTabel = new Label("Daftar Tabel");  
		CatatanHarian = new HBox(); //Bagian Catatan Harian 
		CatatanHarianLbl2 = new Label("Catatan Harian");
		CatatanHarian.getChildren().addAll(CatatanHarianLbl2);  
		MasterPakan = new HBox(); //Bagian Master Pakan 
		MasterPakanLbl = new Label("Master Pakan");
		MasterPakan.getChildren().addAll(MasterPakanLbl);  
		MasterObat = new HBox(); //Bagian Master Obat
		MasterObatLbl = new Label("Master Obat");
		MasterObat.getChildren().addAll(MasterObatLbl);  
		MasterSupplier = new HBox(); //Bagian Master Supplier
		MasterSupplierLbl = new Label("Master Supplier"); 
		MasterSupplier.getChildren().addAll(MasterSupplierLbl);  
		MasterKandang = new HBox(); // Bagian Master Kandang
		MasterKandangLbl = new Label("Master Kandang");  
		MasterKandang.getChildren().addAll(MasterKandangLbl); 
		
		JFCS = new Label("Jimmy Farm Control System");
		
		KodePakanTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.20));
		NamaPakanTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.20));
		JenisPakanTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.20));
		HargaTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.20));
		
		KodePakanTC.setStyle("-fx-alignment: CENTER;");
		NamaPakanTC.setStyle("-fx-alignment: CENTER;");
		JenisPakanTC.setStyle("-fx-alignment: CENTER;");
		HargaTC.setStyle("-fx-alignment: CENTER;");
	}


	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
		mb.getMenus().add(action);
		action.getItems().addAll(Home, LogOut); 
		
		HBox leftBtnContainer = new HBox();
		leftBtnContainer.getChildren().addAll(InputData, Update);
		
		ButtonContainer.getChildren().addAll(leftBtnContainer, Delete);
		
		CatatanHarianLbl = new Label("Catatan Harian");
	
		TableLayout.setTop(CatatanHarianLbl);
		TableLayout.setCenter(TablePakan);
		TableLayout.setBottom(ButtonContainer);
		
		BorderPane.setMargin(TablePakan, new Insets(15, 0, 15, 0));
		BorderPane.setAlignment(CatatanHarianLbl, Pos.CENTER);
		CatatanHarianLbl.setFont(Font.font("Arial", FontWeight.BOLD, 30));
	
	
		ButtonContainer.setSpacing(10);
		
		
		TableLayout.setPadding(new Insets(80));
		getMasterPakanLbl().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Home.setDisable(true);
		
		mainLayout.setCenter(TableLayout);
		mainLayout.setLeft(getSideBar());
	}


	public Scene getScene() {
		return scene;
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


	public Label getDaftarTabel() {
		return DaftarTabel;
	}


	public void setDaftarTabel(Label daftarTabel) {
		DaftarTabel = daftarTabel;
	}


	public Label getCatatanHarianLbl2() {
		return CatatanHarianLbl2;
	}


	public void setCatatanHarianLbl2(Label catatanHarianLbl2) {
		CatatanHarianLbl2 = catatanHarianLbl2;
	}


	public Label getMasterPakanLbl() {
		return MasterPakanLbl;
	}


	public void setMasterPakanLbl(Label masterPakanLbl) {
		MasterPakanLbl = masterPakanLbl;
	}


	public Label getMasterObatLbl() {
		return MasterObatLbl;
	}


	public void setMasterObatLbl(Label masterObatLbl) {
		MasterObatLbl = masterObatLbl;
	}


	public Label getMasterSupplierLbl() {
		return MasterSupplierLbl;
	}


	public void setMasterSupplierLbl(Label masterSupplierLbl) {
		MasterSupplierLbl = masterSupplierLbl;
	}


	public Label getMasterKandangLbl() {
		return MasterKandangLbl;
	}


	public void setMasterKandangLbl(Label masterKandangLbl) {
		MasterKandangLbl = masterKandangLbl;
	}


	public HBox getCatatanHarian() {
		return CatatanHarian;
	}


	public void setCatatanHarian(HBox catatanHarian) {
		CatatanHarian = catatanHarian;
	}


	public HBox getMasterPakan() {
		return MasterPakan;
	}


	public void setMasterPakan(HBox masterPakan) {
		MasterPakan = masterPakan;
	}


	public HBox getMasterObat() {
		return MasterObat;
	}


	public void setMasterObat(HBox masterObat) {
		MasterObat = masterObat;
	}


	public HBox getMasterSupplier() {
		return MasterSupplier;
	}


	public void setMasterSupplier(HBox masterSupplier) {
		MasterSupplier = masterSupplier;
	}


	public HBox getMasterKandang() {
		return MasterKandang;
	}


	public void setMasterKandang(HBox masterKandang) {
		MasterKandang = masterKandang;
	}


	public HBox getButtonContainer() {
		return ButtonContainer;
	}


	public void setButtonContainer(HBox buttonContainer) {
		ButtonContainer = buttonContainer;
	}
	
	

}
