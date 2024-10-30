package view;

import java.sql.Date;

import controller.MainPageController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.CatatanHarianUtama;
import util.execQuery;
public class MainPageView extends ViewTemplate{
	
	private Scene scene;
	public static Stage mainStage;
	private BorderPane mainLayout, TableLayout; 
	
	private GridPane sideBar, sideBarTop, sideBarBottom;

	public MainPageView(Stage stage) {
		init();
		arrangeComponent();
		this.mainStage = stage;
		
		stage.setScene(scene);
		stage.setWidth(stage.getMaxWidth());
		stage.setHeight(stage.getMaxHeight());
		stage.setTitle("Jimmy Farm Control System");
		stage.show();

		// Show the LoginView on top of the main page
		new LoginView();
		new MainPageController(this);
	}
	
	//CatatanHarianLbl = judul yang diatas tabel 
	//JFCSLbl = Jimmy Farm Control System
	
	Label CatatanHarianLbl, JFCS; 
	TableView<CatatanHarianUtama> LokasiTV, KodeKandangTV, TanggalMasukTV, KeteranganJenisTV, JumlahAwalJantanTV, JumlahAwalBetinaTV, KomentarTV;
	TableColumn<CatatanHarianUtama, String> LokasiTC, KodeKandangTC, KeteranganJenisTC, KomentarTC;
	TableColumn<CatatanHarianUtama, Date> TanggalMasukTC;
	TableColumn<CatatanHarianUtama, Integer> JumlahAwalJantanTC, JumlahAwalBetinaTC; 
	Button Update, Delete, InputData; //button
	MenuBar Home;  //menubar
	MenuItem home, LogOut; //isi menu bar 
	Menu action;//Buat action menu bar 
	
	//Daftar tabel samping
	Label DaftarTabel, CatatanHarianLbl2, MasterPakanLbl, MasterObatLbl, MasterSupplierLbl; 
	HBox CatatanHarian, MasterPakan, MasterObat, MasterSupplier;
	@Override
	public void init() {
		mainLayout = new BorderPane();
		sideBar = new GridPane();
		sideBarTop = new GridPane(); 
		sideBarBottom = new GridPane();
		scene = new Scene(mainLayout); 
		
		//column Lokasi
		LokasiTV = new TableView<CatatanHarianUtama>();
		LokasiTC = new TableColumn<CatatanHarianUtama, String>("Lokasi");
		LokasiTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, String>("Lokasi"));
		
		//column Kode Kandang 
		KodeKandangTC = new TableColumn<CatatanHarianUtama, String>("KodeKandang"); 
		KodeKandangTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, String>("KodeKandang")); 
		
		//column Tanggal Masuk 
		TanggalMasukTC = new TableColumn<CatatanHarianUtama, Date>("TanggalMasuk"); 
		TanggalMasukTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, Date>("TanggalMasuk")); 
		
		//column Keterangan Jenis 
		KeteranganJenisTC = new TableColumn<CatatanHarianUtama, String>("KeteranganJenis"); 
		KeteranganJenisTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, String>("KeteranganJenis"));
		
		//Column Jumlah Awal Jantan 
		JumlahAwalJantanTC = new TableColumn<CatatanHarianUtama, Integer>("JumlahAwalJantan"); 
		JumlahAwalJantanTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, Integer>("JumlahAwalJantan")); 
		
		//Column Jumlah Awal Betina
		JumlahAwalBetinaTC = new TableColumn<CatatanHarianUtama, Integer>("JumlahAwalBetina"); 
		JumlahAwalBetinaTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, Integer>("JumlahAwalBetina"));
		
		//Column Komentar
		KomentarTC = new TableColumn<CatatanHarianUtama, String>("Komentar"); 
		KomentarTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, String>("Komentar"));
		
		LokasiTV.getColumns().addAll(LokasiTC, KodeKandangTC, TanggalMasukTC, KeteranganJenisTC
		, JumlahAwalJantanTC, JumlahAwalBetinaTC,KomentarTC);
		
		LokasiTV.getItems().addAll(execQuery.getCatatanHarian());
		
		mainLayout.setCenter(LokasiTV);
		
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
		Home = new MenuBar();  
		action = new Menu("Action"); 
		home = new MenuItem("Home"); 
		LogOut = new MenuItem("Log Out"); 
		
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
		MasterSupplier = new HBox(); 
		MasterSupplierLbl = new Label("Master Supplier"); 
		MasterSupplier.getChildren().addAll(MasterSupplierLbl);
		
		mainLayout.setTop(Home); 
		mainLayout.setLeft(sideBar);
		
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		Home.getMenus().add(action);
		action.getItems().addAll(home, LogOut); 
		
		sideBar.add(sideBarTop, 0, 0);
		sideBar.add(sideBarBottom, 0, 1);
		
		
	}



	public Scene getScene() {
		return scene;
	}



	public static Stage getMainStage() {
		return mainStage;
	}



	public BorderPane getMainLayout() {
		return mainLayout;
	}



	public GridPane getGP1() {
		return GP1;
	}



	public GridPane getGP2() {
		return GP2;
	}



	public Label getCatatanHarianLbl() {
		return CatatanHarianLbl;
	}



	public Label getJFCS() {
		return JFCS;
	}



	public TableView<CatatanHarianUtama> getLokasiTV() {
		return LokasiTV;
	}



	public TableView<CatatanHarianUtama> getKodeKandangTV() {
		return KodeKandangTV;
	}



	public TableView<CatatanHarianUtama> getTanggalMasukTV() {
		return TanggalMasukTV;
	}



	public TableView<CatatanHarianUtama> getKeteranganJenisTV() {
		return KeteranganJenisTV;
	}



	public TableView<CatatanHarianUtama> getJumlahAwalJantanTV() {
		return JumlahAwalJantanTV;
	}



	public TableView<CatatanHarianUtama> getJumlahAwalBetinaTV() {
		return JumlahAwalBetinaTV;
	}



	public TableView<CatatanHarianUtama> getKomentarTV() {
		return KomentarTV;
	}



	public TableColumn<CatatanHarianUtama, String> getLokasiTC() {
		return LokasiTC;
	}



	public TableColumn<CatatanHarianUtama, String> getKodeKandangTC() {
		return KodeKandangTC;
	}



	public TableColumn<CatatanHarianUtama, String> getKeteranganJenisTC() {
		return KeteranganJenisTC;
	}



	public TableColumn<CatatanHarianUtama, String> getKomentarTC() {
		return KomentarTC;
	}



	public TableColumn<CatatanHarianUtama, Date> getTanggalMasukTC() {
		return TanggalMasukTC;
	}



	public TableColumn<CatatanHarianUtama, Integer> getJumlahAwalJantanTC() {
		return JumlahAwalJantanTC;
	}



	public TableColumn<CatatanHarianUtama, Integer> getJumlahAwalBetinaTC() {
		return JumlahAwalBetinaTC;
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



	public MenuBar getHome() {
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



	public void setScene(Scene scene) {
		this.scene = scene;
	}



	public static void setMainStage(Stage mainStage) {
		MainPageView.mainStage = mainStage;
	}



	public void setMainLayout(BorderPane mainLayout) {
		this.mainLayout = mainLayout;
	}



	public void setGP1(GridPane gP1) {
		GP1 = gP1;
	}



	public void setGP2(GridPane gP2) {
		GP2 = gP2;
	}



	public void setCatatanHarianLbl(Label catatanHarianLbl) {
		CatatanHarianLbl = catatanHarianLbl;
	}



	public void setJFCS(Label jFCS) {
		JFCS = jFCS;
	}



	public void setLokasiTV(TableView<CatatanHarianUtama> lokasiTV) {
		LokasiTV = lokasiTV;
	}



	public void setKodeKandangTV(TableView<CatatanHarianUtama> kodeKandangTV) {
		KodeKandangTV = kodeKandangTV;
	}



	public void setTanggalMasukTV(TableView<CatatanHarianUtama> tanggalMasukTV) {
		TanggalMasukTV = tanggalMasukTV;
	}



	public void setKeteranganJenisTV(TableView<CatatanHarianUtama> keteranganJenisTV) {
		KeteranganJenisTV = keteranganJenisTV;
	}



	public void setJumlahAwalJantanTV(TableView<CatatanHarianUtama> jumlahAwalJantanTV) {
		JumlahAwalJantanTV = jumlahAwalJantanTV;
	}



	public void setJumlahAwalBetinaTV(TableView<CatatanHarianUtama> jumlahAwalBetinaTV) {
		JumlahAwalBetinaTV = jumlahAwalBetinaTV;
	}



	public void setKomentarTV(TableView<CatatanHarianUtama> komentarTV) {
		KomentarTV = komentarTV;
	}



	public void setLokasiTC(TableColumn<CatatanHarianUtama, String> lokasiTC) {
		LokasiTC = lokasiTC;
	}



	public void setKodeKandangTC(TableColumn<CatatanHarianUtama, String> kodeKandangTC) {
		KodeKandangTC = kodeKandangTC;
	}



	public void setKeteranganJenisTC(TableColumn<CatatanHarianUtama, String> keteranganJenisTC) {
		KeteranganJenisTC = keteranganJenisTC;
	}



	public void setKomentarTC(TableColumn<CatatanHarianUtama, String> komentarTC) {
		KomentarTC = komentarTC;
	}



	public void setTanggalMasukTC(TableColumn<CatatanHarianUtama, Date> tanggalMasukTC) {
		TanggalMasukTC = tanggalMasukTC;
	}



	public void setJumlahAwalJantanTC(TableColumn<CatatanHarianUtama, Integer> jumlahAwalJantanTC) {
		JumlahAwalJantanTC = jumlahAwalJantanTC;
	}



	public void setJumlahAwalBetinaTC(TableColumn<CatatanHarianUtama, Integer> jumlahAwalBetinaTC) {
		JumlahAwalBetinaTC = jumlahAwalBetinaTC;
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



	public void setHome(MenuBar home) {
		Home = home;
	}



	public void setHome(MenuItem home) {
		this.home = home;
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
	
}
