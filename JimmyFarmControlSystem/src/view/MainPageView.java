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
public class MainPageView extends TableViewTemplate{
	
	private Scene scene;
	public static Stage mainStage;
	private Data data = new Data();
	
	public MainPageView() {
		setSideBar();
		
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
	
	Label CatatanHarianLbl;
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
	HBox ButtonContainer;
	@Override
	public void init() {
		mainLayout = new BorderPane();
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
		mainLayout.setLeft(getSideBar());
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
		
		
		BorderPane.setMargin(Table, new Insets(15, 0, 15, 0));
		BorderPane.setAlignment(CatatanHarianLbl, Pos.CENTER);
		CatatanHarianLbl.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		getSideBarCatatanHarianLbl().setFont(Font.font("Arial", FontWeight.BOLD, 20));
	
		
		TableLayout.setPadding(new Insets(80));

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


	public Label getCatatanHarianLbl() {
		return CatatanHarianLbl;
	}

	public void setCatatanHarianLbl(Label catatanHarianLbl) {
		CatatanHarianLbl = catatanHarianLbl;
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
	
	
	
}
