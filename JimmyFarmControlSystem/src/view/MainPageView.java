package view;

import java.sql.Date;

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
public class MainPageView extends ViewTemplate{
	
	private Scene scene;
	public static Stage mainStage;
	private BorderPane mainLayout; 
	private GridPane GP1, GP2;

	public MainPageView(Stage stage) {
		init();
		arrangeComponent();
		this.mainStage = stage;
		
		stage.setScene(scene);
		stage.setTitle("Jimmy Farm Control System");
		stage.show();

		// Show the LoginView on top of the main page
		new LoginView();
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
		GP1 = new GridPane(); 
		GP2 = new GridPane();
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
		mainLayout.setBottom(GP1);
		mainLayout.setLeft(GP2);
		
	}
	
	

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		Home.getMenus().add(action);
		action.getItems().addAll(home, LogOut); 
		
		GP1.setVgap(5); 
		GP1.setHgap(5); 
		
		GP2.setVgap(5); 
		GP2.setHgap(5);
		GP2.add(Update, 1, 10); 
		GP2.add(Delete, 2, 10); 
		GP2.add(InputData, 10, 10);  
		GP2.add(DaftarTabel, 1, 1); 
		GP2.add(CatatanHarian, 1, 2); 
		GP2.add(MasterPakan, 1, 3); 
		GP2.add(MasterObat, 1, 4); 
		GP2.add(MasterSupplier, 1, 5);
		
		
	}

}
