package view.CatatanDetail;

import view.TableViewTemplate;
import java.sql.Date;

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
import model.CatatanHarianDetail;
import model.CatatanHarianUtama;
import util.Data;
import view.TableViewTemplate;
import view.login.LoginView;


public class CatatanHarianDetailView extends TableViewTemplate{
	
	private Scene scene;
	public Stage stage;
	
	Label CatatanHarianLbl;
	TableView<CatatanHarianDetail> Table;
	TableColumn<CatatanHarianDetail, String> KodePakanTC, KodeObatTC, KomentarTC;
	TableColumn<CatatanHarianDetail, Date> TanggalTC;
	TableColumn<CatatanHarianDetail, Integer> UmurTC, MingguTC, KematianJantanTC, KematianBetinaTC, JumlahPakanTC, JumlahObatTC, ProduksiTelurTC, BiayaVariabelTC; 
	TableColumn<CatatanHarianDetail, Integer> SisaJantanTC, SisaBetinaTC, SisaTotalTC, PakanPerEkorTC;
	TableColumn<CatatanHarianDetail, Double> PerbandinganJantanBetinaTC, PersentaseProduksiTC;
	Button Update, Delete, InputData;
	HBox ButtonContainer;

	public CatatanHarianDetailView() {
		init();
		arrangeComponent();
		stage = new Stage();
		
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.setTitle("Jimmy Farm Control System Detail");
		stage.show();
	}

	@Override
	public void init() {
		mainLayout = new BorderPane();
		TableLayout = new BorderPane();
		scene = new Scene(mainLayout); 

		Table = new TableView<CatatanHarianDetail>();
		//column Tanggal Masuk 
		TanggalTC = new TableColumn<CatatanHarianDetail, Date>("Tanggal"); 
		TanggalTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Date>("Tanggal")); 

		//column Umur
		UmurTC = new TableColumn<CatatanHarianDetail, Integer>("Umur");
		UmurTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Umur"));
		
		//column Minggu 
		MingguTC = new TableColumn<CatatanHarianDetail, Integer>("Minggu");
		MingguTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Minggu"));

		//column Kematian Jantan
		KematianJantanTC = new TableColumn<CatatanHarianDetail, Integer>("Kematian Jantan"); 
		KematianJantanTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Kematian Jantan")); 
		
		//column sisa Jantan
		SisaJantanTC = new TableColumn<CatatanHarianDetail, Integer>("Sisa Jantan"); 
		SisaJantanTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Sisa Jantan")); 

		//column Kematian Betina
		KematianBetinaTC = new TableColumn<CatatanHarianDetail, Integer>("Kematian Betina"); 
		KematianBetinaTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Kematian Betina")); 
		
		//column sisa Betina
		SisaBetinaTC = new TableColumn<CatatanHarianDetail, Integer>("Sisa Betina"); 
		SisaBetinaTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Sisa Betina")); 

		//column Total Sisa
		SisaTotalTC = new TableColumn<CatatanHarianDetail, Integer>("Total Sisa"); 
		SisaTotalTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Total Sisa")); 
		
		//column Perbandingan Jantan Betina
		PerbandinganJantanBetinaTC = new TableColumn<CatatanHarianDetail, Double>("Perbandingan Jantan Betina"); 
		PerbandinganJantanBetinaTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Double>("PPerbandingan Jantan Betina"));
		
		//column Kode Pakan 
		KodePakanTC = new TableColumn<CatatanHarianDetail, String>("Kode Pakan"); 
		KodePakanTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, String>("Kode Pakan"));
		
		//column Jumlah Pakan
		JumlahPakanTC = new TableColumn<CatatanHarianDetail, Integer>("Jumlah Pakan"); 
		JumlahPakanTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Jumlah Pakan")); 

		//column Pakan per ekor
		PakanPerEkorTC = new TableColumn<CatatanHarianDetail, Integer>("Pakan per ekor"); 
		PakanPerEkorTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Pakan per ekor"));

		//column Kode Obat 
		KodeObatTC = new TableColumn<CatatanHarianDetail, String>("Kode Obat"); 
		KodeObatTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, String>("Kode Obat"));
		
		//column Jumlah Obat
		JumlahObatTC = new TableColumn<CatatanHarianDetail, Integer>("Jumlah Obat"); 
		JumlahObatTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Jumlah Obat")); 

		//column Produksi Telur
		ProduksiTelurTC = new TableColumn<CatatanHarianDetail, Integer>("Produksi Telur"); 
		ProduksiTelurTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Produksi Telur")); 		
		
		//column persentase produksi
		PersentaseProduksiTC = new TableColumn<CatatanHarianDetail, Double>("Persentase Produksi"); 
		PersentaseProduksiTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Double>("Persentase Produksi")); 		
		
		//column Biaya Variabel
		BiayaVariabelTC = new TableColumn<CatatanHarianDetail, Integer>("Biaya Variabel"); 
		BiayaVariabelTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, Integer>("Biaya Variabel")); 		

		//column Komentar
		KomentarTC = new TableColumn<CatatanHarianDetail, String>("Komentar"); 
		KomentarTC.setCellValueFactory(new PropertyValueFactory<CatatanHarianDetail, String>("Komentar")); 				

		Table.getColumns().addAll(TanggalTC, UmurTC, MingguTC, KematianJantanTC, SisaJantanTC, KematianBetinaTC
		, SisaBetinaTC, SisaTotalTC, PerbandinganJantanBetinaTC, 
		KodePakanTC, JumlahPakanTC, PakanPerEkorTC, KodeObatTC, JumlahObatTC, 
		ProduksiTelurTC, PersentaseProduksiTC, BiayaVariabelTC, KomentarTC);
		
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
		
		
		ButtonContainer = new HBox();
		
		
		TanggalTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		UmurTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		MingguTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.12));
		KematianJantanTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.12));
		SisaJantanTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		KematianBetinaTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		SisaBetinaTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		SisaTotalTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));		
		PerbandinganJantanBetinaTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		KodePakanTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		JumlahPakanTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		PakanPerEkorTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		KodeObatTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		JumlahObatTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		ProduksiTelurTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		PersentaseProduksiTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		BiayaVariabelTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		KomentarTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));

	
		TanggalTC.setStyle("-fx-alignment: CENTER;");
		UmurTC.setStyle("-fx-alignment: CENTER;");
		MingguTC.setStyle("-fx-alignment: CENTER;");
		KematianJantanTC.setStyle("-fx-alignment: CENTER;");
		SisaJantanTC.setStyle("-fx-alignment: CENTER;");
		KematianBetinaTC.setStyle("-fx-alignment: CENTER;");
		SisaBetinaTC.setStyle("-fx-alignment: CENTER;");
		SisaTotalTC.setStyle("-fx-alignment: CENTER;");
		PerbandinganJantanBetinaTC.setStyle("-fx-alignment: CENTER;");
		KodePakanTC.setStyle("-fx-alignment: CENTER;");
		PakanPerEkorTC.setStyle("-fx-alignment: CENTER;");
		KodeObatTC.setStyle("-fx-alignment: CENTER;");
		JumlahObatTC.setStyle("-fx-alignment: CENTER;");
		ProduksiTelurTC.setStyle("-fx-alignment: CENTER;");
		PersentaseProduksiTC.setStyle("-fx-alignment: CENTER;");
		BiayaVariabelTC.setStyle("-fx-alignment: CENTER;");
		KomentarTC.setStyle("-fx-alignment: CENTER;");

		mainLayout.setTop(getMb()); 
		mainLayout.setCenter(TableLayout);
		mainLayout.setLeft(getSideBar());
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
	}

}
