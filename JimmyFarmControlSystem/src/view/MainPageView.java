package view;

import java.sql.Date;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CatatanHarianUtama;
public class MainPageView extends ViewTemplate{
	
	private Scene scene;
	public static Stage mainStage;
	private BorderPane mainLayout;

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
	@Override
	public void init() {
		mainLayout = new BorderPane();
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
	}
	
	

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
	}

}
