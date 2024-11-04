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
import model.DaftarPakan;
import util.Data;


public class MasterPakanView extends TableViewTemplate{

	private Scene scene;
	public static Stage PakanStage;
	private Data data = new Data();
	
	private GridPane sideBar, sideBarTop, sideBarBottom;
	
	
	public MasterPakanView() {
		// TODO Auto-generated method stub

		init();
		arrangeComponent();
		PakanStage = new Stage();
		
		PakanStage.setMaximized(true);
		PakanStage.setScene(scene);
		PakanStage.setTitle("Jimmy Farm Control System");
		PakanStage.show();
		
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
		sideBar = new GridPane();
		sideBarTop = new GridPane(); 
		sideBarBottom = new GridPane();
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
		
		KodePakanTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.15));
		NamaPakanTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.15));
		JenisPakanTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.15));
		HargaTC.prefWidthProperty().bind(TablePakan.widthProperty().multiply(0.15));
		
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
		
		sideBar.add(sideBarTop, 0, 0);
		sideBar.add(sideBarBottom, 0, 1);
		sideBar.setVgap(10);
		
		BorderPane.setMargin(TablePakan, new Insets(15, 0, 15, 0));
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

}
