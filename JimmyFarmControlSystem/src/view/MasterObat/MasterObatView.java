package view.MasterObat;

import java.sql.Date;

import controller.masterObat.MasterObatController;
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
import model.CatatanHarianUtama;
import model.DaftarObat;
import util.Data;
import view.TableViewTemplate;

public class MasterObatView extends TableViewTemplate{

	private Scene scene;
	private Stage ObatStage;
	private Data data = new Data();
	
	public MasterObatView() {
		// TODO Auto-generated method stub
		setSideBar();
		init();
		arrangeComponent();
		ObatStage = new Stage();
		
		ObatStage.setMaximized(true);
		ObatStage.setScene(scene);
		
		Image icon = new Image("SmallCustomLogoJimmyFarm.png");
		ObatStage.getIcons().add(icon);		
		
		ObatStage.setTitle("Jimmy Farm Control System");
		ObatStage.show();
		
		new MasterObatController(this);
	}

	Label CatatanHarianLbl, JFCS; 
	TableView<DaftarObat> TableObat;
	TableColumn<DaftarObat, String> KodeObatTC, NamaObatTC, JenisObatTC, SatuanTC, PenyakitTC, KodeSupplierTC;
	TableColumn<DaftarObat, Integer> DosisTC, JumlahPerPackTC, HargaPerPackTC, HargaPerSatuanTC; 
	Button Update, Delete, InputData; //button
	MenuBar mb;  //menubar
	MenuItem Home, LogOut; //isi menu bar 
	Menu action;//Buat action menu bar 

	TextField Search;
	
	BorderPane ButtonContainer;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		mainLayout = new BorderPane();
		TableLayout = new BorderPane();
		scene = new Scene(mainLayout);

		
		//column Kode Obat
		TableObat = new TableView<DaftarObat>();
		KodeObatTC = new TableColumn<DaftarObat, String>("Kode Obat");
		KodeObatTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, String>("kodeObat"));
		
		//column Nama Obat 
		NamaObatTC = new TableColumn<DaftarObat, String>("Nama Obat"); 
		NamaObatTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, String>("namaObat"));
		
		//column jenis obat
		JenisObatTC = new TableColumn<DaftarObat, String>("Jenis Obat");
		JenisObatTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, String>("jenisObat"));
		
		//column dosis obat
		DosisTC = new TableColumn<DaftarObat, Integer>("Dosis");
		DosisTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, Integer>("Dosis"));
		
		//column Satuan
		SatuanTC = new TableColumn<DaftarObat, String>("Satuan");
		SatuanTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, String>("Satuan"));
		
		//column Penyakit
		PenyakitTC = new TableColumn<DaftarObat, String>("Penyakit");
		PenyakitTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, String>("Penyakit"));
		
		//column Jumlah Per Pack
		JumlahPerPackTC = new TableColumn<DaftarObat, Integer>("Jumlah Per Pack");
		JumlahPerPackTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, Integer>("jumlahPerPack"));
		
		//column Harga Per Pack
		HargaPerPackTC = new TableColumn<DaftarObat, Integer>("Harga Per Pack");
		HargaPerPackTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, Integer>("hargaPerPack"));
		
		//column Harga Per Satuan
		HargaPerSatuanTC = new TableColumn<DaftarObat, Integer>("Harga Per Satuan");
		HargaPerSatuanTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, Integer>("hargaPerSatuan"));
		
		KodeSupplierTC = new TableColumn<DaftarObat, String>("Kode Supplier");
		KodeSupplierTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, String>("KodeSupplier"));
		
		//Memasukan column ke table
		TableObat.getColumns().addAll(KodeObatTC, 
		NamaObatTC, 
		JenisObatTC, 
		DosisTC, 
		SatuanTC, 
		PenyakitTC, 
		JumlahPerPackTC, 
		HargaPerPackTC, 
		HargaPerSatuanTC, 
		KodeSupplierTC); 
		
		TableObat.getItems().addAll(data.getObatData());
		
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
				
		Search = new TextField(); 
		Search.setPromptText("Search...");
		Search.setPadding(new Insets(12));
		
		JFCS = new Label("Jimmy Farm Control System");
		
		TableObat.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); 
		
		
		
		KodeObatTC.setStyle("-fx-alignment: CENTER;");
		NamaObatTC.setStyle("-fx-alignment: CENTER;");
		JenisObatTC.setStyle("-fx-alignment: CENTER;");
		DosisTC.setStyle("-fx-alignment: CENTER;");
		SatuanTC.setStyle("-fx-alignment: CENTER;");
		PenyakitTC.setStyle("-fx-alignment: CENTER;");
		JumlahPerPackTC.setStyle("-fx-alignment: CENTER;");
		HargaPerPackTC.setStyle("-fx-alignment: CENTER;"); 
		HargaPerSatuanTC.setStyle("-fx-alignment: CENTER;");
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
		
		rightBtnContainer.getChildren().addAll(Search, InputData);
		rightBtnContainer.setSpacing(15);
		
		
		ButtonContainer.setLeft(leftBtnContainer);
		ButtonContainer.setRight(rightBtnContainer);

		
		CatatanHarianLbl = new Label("Master Obat");
		CatatanHarianLbl.setFont(Font.font("Inter", FontWeight.BOLD, 35));
	
		TableLayout.setTop(CatatanHarianLbl);
		TableLayout.setCenter(TableObat);
		TableLayout.setBottom(ButtonContainer);

		
		BorderPane.setMargin(TableObat, new Insets(15, 0, 15, 0));
		BorderPane.setAlignment(CatatanHarianLbl, Pos.CENTER);
		
		
		TableLayout.setPadding(new Insets(80));
		getMasterObatLbl().setFont(Font.font("Inter", FontWeight.BOLD, 16));
		
		mainLayout.setTop(mb);
		mainLayout.setLeft(getSideBar());
		mainLayout.setCenter(TableLayout);
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Stage getObatStage() {
		return ObatStage;
	}

	public void setObatStage(Stage obatStage) {
		ObatStage = obatStage;
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

	public TableView<DaftarObat> getTableObat() {
		return TableObat;
	}

	public void setTableObat(TableView<DaftarObat> tableObat) {
		TableObat = tableObat;
	}

	public TableColumn<DaftarObat, String> getKodeObatTC() {
		return KodeObatTC;
	}

	public void setKodeObatTC(TableColumn<DaftarObat, String> kodeObatTC) {
		KodeObatTC = kodeObatTC;
	}

	public TableColumn<DaftarObat, String> getNamaObatTC() {
		return NamaObatTC;
	}

	public void setNamaObatTC(TableColumn<DaftarObat, String> namaObatTC) {
		NamaObatTC = namaObatTC;
	}

	public TableColumn<DaftarObat, String> getJenisObatTC() {
		return JenisObatTC;
	}

	public void setJenisObatTC(TableColumn<DaftarObat, String> jenisObatTC) {
		JenisObatTC = jenisObatTC;
	}

	public TableColumn<DaftarObat, String> getSatuanTC() {
		return SatuanTC;
	}

	public void setSatuanTC(TableColumn<DaftarObat, String> satuanTC) {
		SatuanTC = satuanTC;
	}

	public TableColumn<DaftarObat, String> getPenyakitTC() {
		return PenyakitTC;
	}

	public void setPenyakitTC(TableColumn<DaftarObat, String> penyakitTC) {
		PenyakitTC = penyakitTC;
	}

	public TableColumn<DaftarObat, Integer> getDosisTC() {
		return DosisTC;
	}

	public void setDosisTC(TableColumn<DaftarObat, Integer> dosisTC) {
		DosisTC = dosisTC;
	}

	public TableColumn<DaftarObat, Integer> getJumlahPerPackTC() {
		return JumlahPerPackTC;
	}

	public void setJumlahPerPackTC(TableColumn<DaftarObat, Integer> jumlahPerPackTC) {
		JumlahPerPackTC = jumlahPerPackTC;
	}

	public TableColumn<DaftarObat, Integer> getHargaPerPackTC() {
		return HargaPerPackTC;
	}

	public void setHargaPerPackTC(TableColumn<DaftarObat, Integer> hargaPerPackTC) {
		HargaPerPackTC = hargaPerPackTC;
	}

	public TableColumn<DaftarObat, Integer> getHargaPerSatuanTC() {
		return HargaPerSatuanTC;
	}

	public void setHargaPerSatuanTC(TableColumn<DaftarObat, Integer> hargaPerSatuanTC) {
		HargaPerSatuanTC = hargaPerSatuanTC;
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

	
	
	public TextField getSearch() {
		return Search;
	}

	public void setSearch(TextField search) {
		Search = search;
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

	public TableColumn<DaftarObat, String> getKodeSupplierTC() {
		return KodeSupplierTC;
	}

	public void setKodeSupplierTC(TableColumn<DaftarObat, String> kodeSupplierTC) {
		KodeSupplierTC = kodeSupplierTC;
	}
	
	
	
}
