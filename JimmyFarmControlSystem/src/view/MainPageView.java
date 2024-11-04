package view;

import java.sql.Date;

import controller.MainPageController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.CatatanHarianUtama;
import util.Data;
public class MainPageView extends ViewTemplate{
	
	private Scene scene;
	public static Stage mainStage;
	private Data data = new Data();
	
	private GridPane sideBar, sideBarTop, sideBarBottom;

	public MainPageView() {
		init();
		arrangeComponent();
		mainStage = new Stage();
		
		mainStage.setMaximized(true);
		mainStage.setScene(scene);
		mainStage.setTitle("Jimmy Farm Control System");
		mainStage.show();

		new MainPageController(this);
	}
	
	//CatatanHarianLbl = judul yang diatas tabel 
	//JFCSLbl = Jimmy Farm Control System
	
	Label CatatanHarianLbl, JFCS; 
	TableView<CatatanHarianUtama> Table;
	TableColumn<CatatanHarianUtama, String> KodeCatatanTC, KodeKandangTC, KeteranganJenisTC, KomentarTC;
	TableColumn<CatatanHarianUtama, Date> TanggalMasukTC;
	TableColumn<CatatanHarianUtama, Integer> JumlahAwalJantanTC, JumlahAwalBetinaTC; 
	Button Update, Delete, InputData; //button
	MenuBar mb;  //menubar
	MenuItem Home, LogOut; //isi menu bar 
	Menu action;//Buat action menu bar 
	
	//Daftar tabel samping
	Label DaftarTabel, CatatanHarianLbl2, MasterPakanLbl, MasterObatLbl, MasterSupplierLbl, MasterKandangLbl; 
	HBox CatatanHarian, MasterPakan, MasterObat, MasterSupplier, MasterKandang, ButtonContainer;
	@Override
	public void init() {
		mainLayout = new BorderPane();
		sideBar = new GridPane();
		sideBarTop = new GridPane(); 
		sideBarBottom = new GridPane();
		TableLayout = new BorderPane();
		scene = new Scene(mainLayout); 
		
		//column Lokasi
		Table = new TableView<CatatanHarianUtama>();
		KodeCatatanTC = new TableColumn<CatatanHarianUtama, String>("Kode Catatan");
		KodeCatatanTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, String>("kodeCatatan"));
		
		//column Kode Kandang 
		KodeKandangTC = new TableColumn<CatatanHarianUtama, String>("Kode Kandang"); 
		KodeKandangTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, String>("KodeKandang")); 
		
		//column Tanggal Masuk 
		TanggalMasukTC = new TableColumn<CatatanHarianUtama, Date>("Tanggal Masuk"); 
		TanggalMasukTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, Date>("TanggalMasuk")); 
		
		//column Keterangan Jenis 
		KeteranganJenisTC = new TableColumn<CatatanHarianUtama, String>("Keterangan Jenis"); 
		KeteranganJenisTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, String>("KeteranganJenis"));
		
		//Column Jumlah Awal Jantan 
		JumlahAwalJantanTC = new TableColumn<CatatanHarianUtama, Integer>("Jumlah Awal Jantan"); 
		JumlahAwalJantanTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, Integer>("JumlahAwalJantan")); 
		
		//Column Jumlah Awal Betina
		JumlahAwalBetinaTC = new TableColumn<CatatanHarianUtama, Integer>("Jumlah Awal Betina"); 
		JumlahAwalBetinaTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, Integer>("JumlahAwalBetina"));
		
		//Column Komentar
		KomentarTC = new TableColumn<CatatanHarianUtama, String>("Komentar"); 
		KomentarTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianUtama, String>("Komentar"));
		
		Table.getColumns().addAll(KodeCatatanTC, KodeKandangTC, TanggalMasukTC, KeteranganJenisTC
		, JumlahAwalJantanTC, JumlahAwalBetinaTC,KomentarTC);
		
		Table.getItems().addAll(data.getCatatanHarian());
		
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
		
		KodeCatatanTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		KodeKandangTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		JumlahAwalBetinaTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.12));
		JumlahAwalJantanTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.12));
		KeteranganJenisTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		KomentarTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		TanggalMasukTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		
		KodeCatatanTC.setStyle("-fx-alignment: CENTER;");
		KodeKandangTC.setStyle("-fx-alignment: CENTER;");
		JumlahAwalBetinaTC.setStyle("-fx-alignment: CENTER;");
		JumlahAwalJantanTC.setStyle("-fx-alignment: CENTER;");
		KeteranganJenisTC.setStyle("-fx-alignment: CENTER;");
		KomentarTC.setStyle("-fx-alignment: CENTER;");
		TanggalMasukTC.setStyle("-fx-alignment: CENTER;");
		
		mainLayout.setTop(mb); 
		mainLayout.setCenter(TableLayout);
		mainLayout.setLeft(sideBar);
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
		TableLayout.setCenter(Table);
		TableLayout.setBottom(ButtonContainer);
		
		sideBar.add(sideBarTop, 0, 0);
		sideBar.add(sideBarBottom, 0, 1);
		sideBar.setVgap(10);
		
		BorderPane.setMargin(Table, new Insets(15, 0, 15, 0));
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

	public Data getData() {
		return data;
	}

	public TableColumn<CatatanHarianUtama, String> getKodeCatatanTC() {
		return KodeCatatanTC;
	}

	public Label getMasterKandangLbl() {
		return MasterKandangLbl;
	}

	public HBox getMasterKandang() {
		return MasterKandang;
	}

	public HBox getButtonContainer() {
		return ButtonContainer;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setKodeCatatanTC(TableColumn<CatatanHarianUtama, String> kodeCatatanTC) {
		KodeCatatanTC = kodeCatatanTC;
	}

	public void setMasterKandangLbl(Label masterKandangLbl) {
		MasterKandangLbl = masterKandangLbl;
	}

	public void setMasterKandang(HBox masterKandang) {
		MasterKandang = masterKandang;
	}

	public void setButtonContainer(HBox buttonContainer) {
		ButtonContainer = buttonContainer;
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

	public TableView<CatatanHarianUtama> getTable() {
		return Table;
	}

	public void setTable(TableView<CatatanHarianUtama> Table) {
		this.Table = Table;
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
