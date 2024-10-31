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
	MenuBar mb;  //menubar
	MenuItem Home, LogOut; //isi menu bar 
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
		mb = new MenuBar();  
		action = new Menu("Action"); 
		Home = new MenuItem("Home"); 
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
		
		mainLayout.setTop(mb); 
		mainLayout.setLeft(sideBar);
		
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		mb.getMenus().add(action);
		action.getItems().addAll(Home, LogOut); 
		
		sideBar.add(sideBarTop, 0, 0);
		sideBar.add(sideBarBottom, 0, 1);
		
		
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public static Stage getMainStage() {
		return mainStage;
	}

	public static void setMainStage(Stage mainStage) {
		MainPageView.mainStage = mainStage;
	}

	public BorderPane getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(BorderPane mainLayout) {
		this.mainLayout = mainLayout;
	}

	public BorderPane getTableLayout() {
		return TableLayout;
	}

	public void setTableLayout(BorderPane tableLayout) {
		TableLayout = tableLayout;
	}

	public GridPane getSideBar() {
		return sideBar;
	}

	public void setSideBar(GridPane sideBar) {
		this.sideBar = sideBar;
	}

	public GridPane getSideBarTop() {
		return sideBarTop;
	}

	public void setSideBarTop(GridPane sideBarTop) {
		this.sideBarTop = sideBarTop;
	}

	public GridPane getSideBarBottom() {
		return sideBarBottom;
	}

	public void setSideBarBottom(GridPane sideBarBottom) {
		this.sideBarBottom = sideBarBottom;
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

	public TableView<CatatanHarianUtama> getLokasiTV() {
		return LokasiTV;
	}

	public void setLokasiTV(TableView<CatatanHarianUtama> lokasiTV) {
		LokasiTV = lokasiTV;
	}

	public TableView<CatatanHarianUtama> getKodeKandangTV() {
		return KodeKandangTV;
	}

	public void setKodeKandangTV(TableView<CatatanHarianUtama> kodeKandangTV) {
		KodeKandangTV = kodeKandangTV;
	}

	public TableView<CatatanHarianUtama> getTanggalMasukTV() {
		return TanggalMasukTV;
	}

	public void setTanggalMasukTV(TableView<CatatanHarianUtama> tanggalMasukTV) {
		TanggalMasukTV = tanggalMasukTV;
	}

	public TableView<CatatanHarianUtama> getKeteranganJenisTV() {
		return KeteranganJenisTV;
	}

	public void setKeteranganJenisTV(TableView<CatatanHarianUtama> keteranganJenisTV) {
		KeteranganJenisTV = keteranganJenisTV;
	}

	public TableView<CatatanHarianUtama> getJumlahAwalJantanTV() {
		return JumlahAwalJantanTV;
	}

	public void setJumlahAwalJantanTV(TableView<CatatanHarianUtama> jumlahAwalJantanTV) {
		JumlahAwalJantanTV = jumlahAwalJantanTV;
	}

	public TableView<CatatanHarianUtama> getJumlahAwalBetinaTV() {
		return JumlahAwalBetinaTV;
	}

	public void setJumlahAwalBetinaTV(TableView<CatatanHarianUtama> jumlahAwalBetinaTV) {
		JumlahAwalBetinaTV = jumlahAwalBetinaTV;
	}

	public TableView<CatatanHarianUtama> getKomentarTV() {
		return KomentarTV;
	}

	public void setKomentarTV(TableView<CatatanHarianUtama> komentarTV) {
		KomentarTV = komentarTV;
	}

	public TableColumn<CatatanHarianUtama, String> getLokasiTC() {
		return LokasiTC;
	}

	public void setLokasiTC(TableColumn<CatatanHarianUtama, String> lokasiTC) {
		LokasiTC = lokasiTC;
	}

	public TableColumn<CatatanHarianUtama, String> getKodeKandangTC() {
		return KodeKandangTC;
	}

	public void setKodeKandangTC(TableColumn<CatatanHarianUtama, String> kodeKandangTC) {
		KodeKandangTC = kodeKandangTC;
	}

	public TableColumn<CatatanHarianUtama, String> getKeteranganJenisTC() {
		return KeteranganJenisTC;
	}

	public void setKeteranganJenisTC(TableColumn<CatatanHarianUtama, String> keteranganJenisTC) {
		KeteranganJenisTC = keteranganJenisTC;
	}

	public TableColumn<CatatanHarianUtama, String> getKomentarTC() {
		return KomentarTC;
	}

	public void setKomentarTC(TableColumn<CatatanHarianUtama, String> komentarTC) {
		KomentarTC = komentarTC;
	}

	public TableColumn<CatatanHarianUtama, Date> getTanggalMasukTC() {
		return TanggalMasukTC;
	}

	public void setTanggalMasukTC(TableColumn<CatatanHarianUtama, Date> tanggalMasukTC) {
		TanggalMasukTC = tanggalMasukTC;
	}

	public TableColumn<CatatanHarianUtama, Integer> getJumlahAwalJantanTC() {
		return JumlahAwalJantanTC;
	}

	public void setJumlahAwalJantanTC(TableColumn<CatatanHarianUtama, Integer> jumlahAwalJantanTC) {
		JumlahAwalJantanTC = jumlahAwalJantanTC;
	}

	public TableColumn<CatatanHarianUtama, Integer> getJumlahAwalBetinaTC() {
		return JumlahAwalBetinaTC;
	}

	public void setJumlahAwalBetinaTC(TableColumn<CatatanHarianUtama, Integer> jumlahAwalBetinaTC) {
		JumlahAwalBetinaTC = jumlahAwalBetinaTC;
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
	
	
	
}
