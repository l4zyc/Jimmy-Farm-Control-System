package view.MasterKandang;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private Data data = new Data();
	
	private GridPane sideBar, sideBarTop, sideBarBottom;
	
	public MasterKandangView() { 
		setSideBar();
		init();
		arrangeComponent();
		KandangStage = new Stage();
		
		KandangStage.setMaximized(true);
		KandangStage.setScene(scene);
		KandangStage.setTitle("Jimmy Farm Control System");
		KandangStage.show();
	}
	
	Label CatatanHarianLbl, JFCS; 
	TableView<MsKandang> TableKandang;
	TableColumn<MsKandang, String> KodeKandangTC, LokasiTC;
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
		
		//Column Kode Kandang
		TableKandang = new TableView<MsKandang>();
		KodeKandangTC = new TableColumn<MsKandang, String>("Kode Kandang");
		KodeKandangTC.setCellValueFactory(new PropertyValueFactory<MsKandang, String>("Kode Kandang")); 
				
		//Column Nama Kandang 
		LokasiTC = new TableColumn<MsKandang, String>("Lokasi");
		LokasiTC.setCellValueFactory(new PropertyValueFactory<MsKandang, String>("Lokasi"));
				
		TableKandang.getColumns().addAll(KodeKandangTC, LokasiTC); 
		
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
		
		KodeKandangTC.prefWidthProperty().bind(TableKandang.widthProperty().multiply(0.15));
		LokasiTC.prefWidthProperty().bind(TableKandang.widthProperty().multiply(0.15));
		
		KodeKandangTC.setStyle("-fx-alignment: CENTER;");
		LokasiTC.setStyle("-fx-alignment: CENTER;");
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
		TableLayout.setCenter(TableKandang);
		TableLayout.setBottom(ButtonContainer);
		
		sideBar.add(sideBarTop, 0, 0);
		sideBar.add(sideBarBottom, 0, 1);
		sideBar.setVgap(10);
		
		BorderPane.setMargin(TableKandang, new Insets(15, 0, 15, 0));
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
		getMasterKandangLbl().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		
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

	public void setKandangStage(Stage kandangStage) {
		KandangStage = kandangStage;
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
