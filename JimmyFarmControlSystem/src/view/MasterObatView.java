package view;

import java.sql.Date;

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

public class MasterObatView extends ViewTemplate{

	private Scene scene;
	public static Stage ObatStage;
	private Data data = new Data();
	
	private GridPane sideBar, sideBarTop, sideBarBottom;
	
	public MasterObatView() {
		// TODO Auto-generated method stub
		init();
		arrangeComponent();
		ObatStage = new Stage();
		
		ObatStage.setMaximized(true);
		ObatStage.setScene(scene);
		ObatStage.setTitle("Jimmy Farm Control System");
		ObatStage.show();

		
	}

	Label CatatanHarianLbl, JFCS; 
	TableView<DaftarObat> TableObat;
	TableColumn<DaftarObat, String> KodeObatTC, NamaObatTC, JenisObatTC, SatuanTC, PenyakitTC;
	TableColumn<DaftarObat, Integer> DosisTC, JumlahPerPackTC, HargaPerPackTC, HargaPerSatuanTC; 
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
		sideBar = new GridPane();
		sideBarTop = new GridPane(); 
		sideBarBottom = new GridPane();
		TableLayout = new BorderPane();
		scene = new Scene(mainLayout); 
		
		//column Kode Obat
		TableObat = new TableView<DaftarObat>();
		KodeObatTC = new TableColumn<DaftarObat, String>("Kode Obat");
		KodeObatTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, String>("Kode Obat"));
		
		//column Nama Obat 
		NamaObatTC = new TableColumn<DaftarObat, String>("Nama Obat"); 
		NamaObatTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, String>("Nama Obat"));
		
		//column jenis obat
		JenisObatTC = new TableColumn<DaftarObat, String>("Jenis Obat");
		JenisObatTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, String>("Jenis Obat"));
		
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
		JumlahPerPackTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, Integer>("Jumlah Per Pack"));
		
		//column Harga Per Pack
		HargaPerPackTC = new TableColumn<DaftarObat, Integer>("Harga Per Pack");
		HargaPerPackTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, Integer>("Harga Per Pack"));
		
		//column Harga Per Satuan
		HargaPerSatuanTC = new TableColumn<DaftarObat, Integer>("Harga Per Satuan");
		HargaPerSatuanTC.setCellValueFactory(new PropertyValueFactory<DaftarObat, Integer>("Harga Per Satuan"));
		
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
		MasterSupplier = new HBox(); // Bagian Master Supplier
		MasterSupplierLbl = new Label("Master Supplier"); 
		MasterSupplier.getChildren().addAll(MasterSupplierLbl); 
		MasterKandang = new HBox(); // Bagian Master Kandang
		MasterKandangLbl = new Label("Master Kandang");  
		MasterKandang.getChildren().addAll(MasterKandangLbl); 
				
		JFCS = new Label("Jimmy Farm Control System");
		
		KodeObatTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.15));
		NamaObatTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.15));
		JenisObatTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.15));
		DosisTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.15));
		SatuanTC.prefWidthProperty().bind(TableObat.widthProperty().multiply(0.15));
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
		
		ButtonContainer.getChildren().addAll(leftBtnContainer, Delete);
		
		CatatanHarianLbl = new Label("Catatan Harian");
	
		TableLayout.setTop(CatatanHarianLbl);
		TableLayout.setCenter(TableObat);
		TableLayout.setBottom(ButtonContainer);
		
		sideBar.add(sideBarTop, 0, 0);
		sideBar.add(sideBarBottom, 0, 1);
		sideBar.setVgap(10);
		
		BorderPane.setMargin(TableObat, new Insets(15, 0, 15, 0));
		BorderPane.setAlignment(CatatanHarianLbl, Pos.CENTER);
		CatatanHarianLbl.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		
		sideBarTop.add(JFCS, 0, 1);
		
		sideBarBottom.add(DaftarTabel, 0, 0);		
		sideBarBottom.add(CatatanHarian, 0, 1);		
		sideBarBottom.add(MasterPakan, 0, 2);		
		sideBarBottom.add(MasterObat, 0, 3);		
		sideBarBottom.add(MasterSupplier, 0, 4);
		sideBarBottom.add(MasterKandang, 0, 5); 
		
		sideBarBottom.setVgap(10);
		ButtonContainer.setSpacing(10);
		
		sideBarBottom.setStyle("-fx-border-width: 2px 2px 0px 0px;"
				+ "-fx-border-color: BLACK");
		
		TableLayout.setPadding(new Insets(80));
		CatatanHarianLbl2.setFont(Font.font("Arial", FontWeight.BOLD, 10));
		Home.setDisable(true);
	}

	public Scene getScene() {
		return scene;
	}

	public static Stage getObatStage() {
		return ObatStage;
	}

	public Data getData() {
		return data;
	}

	public GridPane getSideBar() {
		return sideBar;
	}

	public GridPane getSideBarTop() {
		return sideBarTop;
	}

	public GridPane getSideBarBottom() {
		return sideBarBottom;
	}

	public Label getCatatanHarianLbl() {
		return CatatanHarianLbl;
	}

	public Label getJFCS() {
		return JFCS;
	}

	public TableView<DaftarObat> getTableObat() {
		return TableObat;
	}

	public TableColumn<DaftarObat, String> getKodeObatTC() {
		return KodeObatTC;
	}

	public TableColumn<DaftarObat, String> getNamaObatTC() {
		return NamaObatTC;
	}

	public TableColumn<DaftarObat, String> getJenisObatTC() {
		return JenisObatTC;
	}

	public TableColumn<DaftarObat, String> getSatuanTC() {
		return SatuanTC;
	}

	public TableColumn<DaftarObat, String> getPenyakitTC() {
		return PenyakitTC;
	}

	public TableColumn<DaftarObat, Integer> getDosisTC() {
		return DosisTC;
	}

	public TableColumn<DaftarObat, Integer> getJumlahPerPackTC() {
		return JumlahPerPackTC;
	}

	public TableColumn<DaftarObat, Integer> getHargaPerPackTC() {
		return HargaPerPackTC;
	}

	public TableColumn<DaftarObat, Integer> getHargaPerSatuanTC() {
		return HargaPerSatuanTC;
	}

	public Button getUpdate() {
		return Update;
	}

	public Button getDelete() {
		return Delete;
	}

	public Button getInputData() {
		return InputData;
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

	public Label getDaftarTabel() {
		return DaftarTabel;
	}

	public Label getCatatanHarianLbl2() {
		return CatatanHarianLbl2;
	}

	public Label getMasterPakanLbl() {
		return MasterPakanLbl;
	}

	public Label getMasterObatLbl() {
		return MasterObatLbl;
	}

	public Label getMasterSupplierLbl() {
		return MasterSupplierLbl;
	}

	public Label getMasterKandangLbl() {
		return MasterKandangLbl;
	}

	public HBox getCatatanHarian() {
		return CatatanHarian;
	}

	public HBox getMasterPakan() {
		return MasterPakan;
	}

	public HBox getMasterObat() {
		return MasterObat;
	}

	public HBox getMasterSupplier() {
		return MasterSupplier;
	}

	public HBox getMasterKandang() {
		return MasterKandang;
	}

	public HBox getButtonContainer() {
		return ButtonContainer;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public static void setObatStage(Stage obatStage) {
		ObatStage = obatStage;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setSideBar(GridPane sideBar) {
		this.sideBar = sideBar;
	}

	public void setSideBarTop(GridPane sideBarTop) {
		this.sideBarTop = sideBarTop;
	}

	public void setSideBarBottom(GridPane sideBarBottom) {
		this.sideBarBottom = sideBarBottom;
	}

	public void setCatatanHarianLbl(Label catatanHarianLbl) {
		CatatanHarianLbl = catatanHarianLbl;
	}

	public void setJFCS(Label jFCS) {
		JFCS = jFCS;
	}

	public void setTableObat(TableView<DaftarObat> tableObat) {
		TableObat = tableObat;
	}

	public void setKodeObatTC(TableColumn<DaftarObat, String> kodeObatTC) {
		KodeObatTC = kodeObatTC;
	}

	public void setNamaObatTC(TableColumn<DaftarObat, String> namaObatTC) {
		NamaObatTC = namaObatTC;
	}

	public void setJenisObatTC(TableColumn<DaftarObat, String> jenisObatTC) {
		JenisObatTC = jenisObatTC;
	}

	public void setSatuanTC(TableColumn<DaftarObat, String> satuanTC) {
		SatuanTC = satuanTC;
	}

	public void setPenyakitTC(TableColumn<DaftarObat, String> penyakitTC) {
		PenyakitTC = penyakitTC;
	}

	public void setDosisTC(TableColumn<DaftarObat, Integer> dosisTC) {
		DosisTC = dosisTC;
	}

	public void setJumlahPerPackTC(TableColumn<DaftarObat, Integer> jumlahPerPackTC) {
		JumlahPerPackTC = jumlahPerPackTC;
	}

	public void setHargaPerPackTC(TableColumn<DaftarObat, Integer> hargaPerPackTC) {
		HargaPerPackTC = hargaPerPackTC;
	}

	public void setHargaPerSatuanTC(TableColumn<DaftarObat, Integer> hargaPerSatuanTC) {
		HargaPerSatuanTC = hargaPerSatuanTC;
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

	public void setDaftarTabel(Label daftarTabel) {
		DaftarTabel = daftarTabel;
	}

	public void setCatatanHarianLbl2(Label catatanHarianLbl2) {
		CatatanHarianLbl2 = catatanHarianLbl2;
	}

	public void setMasterPakanLbl(Label masterPakanLbl) {
		MasterPakanLbl = masterPakanLbl;
	}

	public void setMasterObatLbl(Label masterObatLbl) {
		MasterObatLbl = masterObatLbl;
	}

	public void setMasterSupplierLbl(Label masterSupplierLbl) {
		MasterSupplierLbl = masterSupplierLbl;
	}

	public void setMasterKandangLbl(Label masterKandangLbl) {
		MasterKandangLbl = masterKandangLbl;
	}

	public void setCatatanHarian(HBox catatanHarian) {
		CatatanHarian = catatanHarian;
	}

	public void setMasterPakan(HBox masterPakan) {
		MasterPakan = masterPakan;
	}

	public void setMasterObat(HBox masterObat) {
		MasterObat = masterObat;
	}

	public void setMasterSupplier(HBox masterSupplier) {
		MasterSupplier = masterSupplier;
	}

	public void setMasterKandang(HBox masterKandang) {
		MasterKandang = masterKandang;
	}

	public void setButtonContainer(HBox buttonContainer) {
		ButtonContainer = buttonContainer;
	}

	
	
}
