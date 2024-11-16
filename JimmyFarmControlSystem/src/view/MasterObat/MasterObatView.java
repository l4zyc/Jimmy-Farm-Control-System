package view.MasterObat;

import java.sql.Date;

import controller.masterObat.MasterObatController;
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
		ObatStage.setTitle("Jimmy Farm Control System");
		ObatStage.show();
		
		new MasterObatController(this);
	}

	Label CatatanHarianLbl, JFCS; 
	TableView<DaftarObat> TableObat;
	TableColumn<DaftarObat, String> KodeObatTC, NamaObatTC, JenisObatTC, SatuanTC, PenyakitTC;
	TableColumn<DaftarObat, Integer> DosisTC, JumlahPerPackTC, HargaPerPackTC, HargaPerSatuanTC; 
	Button Update, Delete, InputData; //button
	MenuBar mb;  //menubar
	MenuItem Home, LogOut; //isi menu bar 
	Menu action;//Buat action menu bar 

	TextField Search;
	
	HBox ButtonContainer;
	
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
		
		//Memasukan column ke table
		TableObat.getColumns().addAll(KodeObatTC, 
		NamaObatTC, 
		JenisObatTC, 
		DosisTC, 
		SatuanTC, 
		PenyakitTC, 
		JumlahPerPackTC, 
		HargaPerPackTC, 
		HargaPerSatuanTC); 
		
		TableObat.getItems().addAll(data.getObatData());
		
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
				
		Search = new TextField(); 
		Search.setPromptText("Search...");
		
		JFCS = new Label("Jimmy Farm Control System");
		
		KodeObatTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.05));
		NamaObatTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.10));
		JenisObatTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.10));
		DosisTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.05));
		SatuanTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.10));
		PenyakitTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.15));
		JumlahPerPackTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.15));
		HargaPerPackTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.15));
		HargaPerSatuanTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.15));
		
		KodeObatTC.setStyle("-fx-alignment: CENTER;");
		NamaObatTC.setStyle("-fx-alignment: CENTER;");
		JenisObatTC.setStyle("-fx-alignment: CENTER;");
		DosisTC.setStyle("-fx-alignment: CENTER;");
		SatuanTC.setStyle("-fx-alignment: CENTER;");
		PenyakitTC.setStyle("-fx-alignment: CENTER;");
		JumlahPerPackTC.setStyle("-fx-alignment: CENTER;");
		HargaPerPackTC.setStyle("-fx-alignment: CENTER;"); 
		HargaPerSatuanTC.setStyle("-fx-alignment: CENTER;");
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
	
		mb.getMenus().add(action);
		action.getItems().addAll(Home, LogOut); 
		
		HBox leftBtnContainer = new HBox();
		leftBtnContainer.getChildren().addAll(InputData, Update);
		
		ButtonContainer.getChildren().addAll(leftBtnContainer, Delete, Search);
		
		CatatanHarianLbl = new Label("Master Obat");
	
		TableLayout.setTop(CatatanHarianLbl);
		TableLayout.setCenter(TableObat);
		TableLayout.setBottom(ButtonContainer);

		
		BorderPane.setMargin(TableObat, new Insets(15, 0, 15, 0));
		BorderPane.setAlignment(CatatanHarianLbl, Pos.CENTER);
		CatatanHarianLbl.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		
		
		TableLayout.setPadding(new Insets(80));
		getMasterObatLbl().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		
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

	public HBox getButtonContainer() {
		return ButtonContainer;
	}

	public void setButtonContainer(HBox buttonContainer) {
		ButtonContainer = buttonContainer;
	}
	
}
