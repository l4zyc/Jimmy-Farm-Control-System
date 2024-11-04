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
import model.DaftarSupplier;
import util.Data;

public class MasterSupplierView extends TableViewTemplate{

	private Scene scene;
	public static Stage SupplierStage;
	private Data data = new Data();
	
	private GridPane sideBar, sideBarTop, sideBarBottom;
	
	public MasterSupplierView() {
		// TODO Auto-generated method stub
		init();
		arrangeComponent();
		SupplierStage = new Stage();
		
		SupplierStage.setMaximized(true);
		SupplierStage.setScene(scene);
		SupplierStage.setTitle("Jimmy Farm Control System");
		SupplierStage.show();
	}

	Label CatatanHarianLbl, JFCS; 
	TableView<DaftarSupplier> TableSupplier;
	TableColumn<DaftarSupplier, String> KodeSupplierTC, NamaSupplierTC;
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
		TableSupplier = new TableView<DaftarSupplier>();
		KodeSupplierTC = new TableColumn<DaftarSupplier, String>("Kode Supplier");
		KodeSupplierTC.setCellValueFactory(new PropertyValueFactory<DaftarSupplier, String>("Kode Supplier")); 
		
		//Column Nama Pakan 
		NamaSupplierTC = new TableColumn<DaftarSupplier, String>("Nama Supplier");
		NamaSupplierTC.setCellValueFactory(new PropertyValueFactory<DaftarSupplier, String>("Nama Supplier"));
		
		TableSupplier.getColumns().addAll(KodeSupplierTC, NamaSupplierTC); 
		
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
		
		KodeSupplierTC.prefWidthProperty().bind(TableSupplier.widthProperty().multiply(0.15));
		NamaSupplierTC.prefWidthProperty().bind(TableSupplier.widthProperty().multiply(0.15));
		
		KodeSupplierTC.setStyle("-fx-alignment: CENTER;");
		NamaSupplierTC.setStyle("-fx-alignment: CENTER;");
		
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
		TableLayout.setCenter(TableSupplier);
		TableLayout.setBottom(ButtonContainer);
		
		sideBar.add(sideBarTop, 0, 0);
		sideBar.add(sideBarBottom, 0, 1);
		sideBar.setVgap(10);
		
		BorderPane.setMargin(TableSupplier, new Insets(15, 0, 15, 0));
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
