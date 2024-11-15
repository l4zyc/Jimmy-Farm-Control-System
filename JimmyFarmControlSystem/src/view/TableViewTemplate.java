package view;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public abstract class TableViewTemplate extends ViewTemplate{
	protected BorderPane mainLayout, TableLayout;
	private GridPane sideBar, sideBarTop, sideBarBottom;
	private Label JFCS; 
	private HBox CatatanHarian, MasterPakan, MasterObat, MasterSupplier, MasterKandang;
	private Label DaftarTabel, SideBarCatatanHarianLbl, MasterPakanLbl, MasterObatLbl, MasterSupplierLbl, MasterKandangLbl; 
	
	private MenuBar mb;
	private MenuItem Home, LogOut; //isi menu bar 
	private Menu action;//Buat action menu bar 
	
	public TableViewTemplate() {
		setSideBar();
		setMenuBar();
	}
	
	public void setMenuBar() {
		mb = new MenuBar();  
		action = new Menu("Action"); 
		Home = new MenuItem("Home"); 
		LogOut = new MenuItem("Log Out"); 
		mb.getMenus().add(action);
		action.getItems().addAll(Home, LogOut); 
	}
	
	public void setSideBar() {
		sideBar = new GridPane();
		sideBarTop = new GridPane(); 
		sideBarBottom = new GridPane();
		
		sideBar.add(sideBarTop, 0, 0);
		sideBar.add(sideBarBottom, 0, 1);
		sideBar.setVgap(10);
		
		DaftarTabel = new Label("Daftar Tabel");  
		CatatanHarian = new HBox(); //Bagian Catatan Harian 
		SideBarCatatanHarianLbl = new Label("Catatan Harian");
		CatatanHarian.getChildren().addAll(SideBarCatatanHarianLbl);  
		
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
		
		sideBarTop.add(JFCS, 0, 1);
		
		sideBarBottom.add(DaftarTabel, 0, 0);		
		sideBarBottom.add(CatatanHarian, 0, 1);		
		sideBarBottom.add(MasterPakan, 0, 2);		
		sideBarBottom.add(MasterObat, 0, 3);		
		sideBarBottom.add(MasterSupplier, 0, 4);
		sideBarBottom.add(MasterKandang, 0, 5); 
		
		sideBarBottom.setVgap(10);
		
		sideBar.setStyle("-fx-border-width: 2px 2px 0px 0px;"
				+ "-fx-border-color: BLACK");
		sideBarBottom.setStyle("-fx-border-width: 2px 0px 0px 0px;"
				+ "-fx-border-color: BLACK");
		
		sideBarBottom.setMinWidth(200);
		sideBar.setMinWidth(200);
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

	public Label getJFCS() {
		return JFCS;
	}

	public void setJFCS(Label jFCS) {
		JFCS = jFCS;
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

	public Label getDaftarTabel() {
		return DaftarTabel;
	}

	public void setDaftarTabel(Label daftarTabel) {
		DaftarTabel = daftarTabel;
	}

	public Label getSideBarCatatanHarianLbl() {
		return SideBarCatatanHarianLbl;
	}

	public void setSideBarCatatanHarianLbl(Label sideBarCatatanHarianLbl) {
		SideBarCatatanHarianLbl = sideBarCatatanHarianLbl;
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
	
	
	
	
	
}
