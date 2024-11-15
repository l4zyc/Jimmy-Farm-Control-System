package view.CatatanDetail;

import view.TableViewTemplate;
import java.sql.Date;

import controller.detailCatatan.DetailCatatanController;
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
	
	Label titleLbl;
	TableView<CatatanHarianDetail> table;
	
	TableColumn<CatatanHarianDetail, Integer> jantanTC, betinaTC;
	Button Update, Delete, InputData;
	HBox ButtonContainer;
	String kode;

	public CatatanHarianDetailView(String kodeCatatan) {
		this.kode = kodeCatatan;
		init();
		arrangeComponent();
		stage = new Stage();
		
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.setTitle("Jimmy Farm Control System Detail");
		stage.show();
		
		new DetailCatatanController(this);
	}

	@Override
	public void init() {
		mainLayout = new BorderPane();
		TableLayout = new BorderPane();
		scene = new Scene(mainLayout); 
		
		table = new TableView<>();

		// Main Columns
		TableColumn<CatatanHarianDetail, Date> tanggalTC = new TableColumn<>("Tanggal");
		tanggalTC.setCellValueFactory(new PropertyValueFactory<>("tanggalCatatan"));

		TableColumn<CatatanHarianDetail, String> umurTC = new TableColumn<>("Umur");
		umurTC.setCellValueFactory(new PropertyValueFactory<>("umur"));

		TableColumn<CatatanHarianDetail, Integer> mingguTC = new TableColumn<>("Minggu");
		mingguTC.setCellValueFactory(new PropertyValueFactory<>("minggu"));

		// Nested Columns for "Jantan"
		TableColumn<CatatanHarianDetail, Integer> kematianJantanTC = new TableColumn<>("Kematian");
		kematianJantanTC.setCellValueFactory(new PropertyValueFactory<>("kematianJantan"));

		TableColumn<CatatanHarianDetail, Integer> sisaJantanTC = new TableColumn<>("Sisa");
		sisaJantanTC.setCellValueFactory(new PropertyValueFactory<>("sisaJantan"));

		TableColumn<CatatanHarianDetail, Integer> jantanTC = new TableColumn<>("Jantan");
		jantanTC.getColumns().addAll(kematianJantanTC, sisaJantanTC);

		// Nested Columns for "Betina"
		TableColumn<CatatanHarianDetail, Integer> kematianBetinaTC = new TableColumn<>("Kematian");
		kematianBetinaTC.setCellValueFactory(new PropertyValueFactory<>("kematianBetina"));

		TableColumn<CatatanHarianDetail, Integer> sisaBetinaTC = new TableColumn<>("Sisa");
		sisaBetinaTC.setCellValueFactory(new PropertyValueFactory<>("sisaBetina"));

		TableColumn<CatatanHarianDetail, Integer> betinaTC = new TableColumn<>("Betina");
		betinaTC.getColumns().addAll(kematianBetinaTC, sisaBetinaTC);

		// Additional Main Columns
		TableColumn<CatatanHarianDetail, Integer> totalSisaTC = new TableColumn<>("Total Sisa");
		totalSisaTC.setCellValueFactory(new PropertyValueFactory<>("totalSisa"));

		// Nested Columns for "Perbandingan Jantan Betina"
		TableColumn<CatatanHarianDetail, Integer> perbandinganJantanTC = new TableColumn<>("Jantan Ratio");
		perbandinganJantanTC.setCellValueFactory(new PropertyValueFactory<>("perbandinganJantan"));

		TableColumn<CatatanHarianDetail, Integer> perbandinganBetinaTC = new TableColumn<>("Betina Ratio");
		perbandinganBetinaTC.setCellValueFactory(new PropertyValueFactory<>("perbandinganBetina"));

		TableColumn<CatatanHarianDetail, Integer> perbandinganJantanBetinaNestedTC = new TableColumn<>("Perbandingan Jantan Betina");
		perbandinganJantanBetinaNestedTC.getColumns().addAll(perbandinganJantanTC, perbandinganBetinaTC);

		// Remaining Columns
		TableColumn<CatatanHarianDetail, String> kodePakanTC = new TableColumn<>("Kode Pakan");
		kodePakanTC.setCellValueFactory(new PropertyValueFactory<>("kodePakan"));

		TableColumn<CatatanHarianDetail, String> jumlahPakanTC = new TableColumn<>("Jumlah Pakan");
		jumlahPakanTC.setCellValueFactory(new PropertyValueFactory<>("jumlahPakan"));

		TableColumn<CatatanHarianDetail, String> pakanPerEkorTC = new TableColumn<>("Pakan per ekor");
		pakanPerEkorTC.setCellValueFactory(new PropertyValueFactory<>("pakanPerEkor"));

		TableColumn<CatatanHarianDetail, String> kodeObatTC = new TableColumn<>("Kode Obat");
		kodeObatTC.setCellValueFactory(new PropertyValueFactory<>("kodeObat"));

		TableColumn<CatatanHarianDetail, String> jumlahObatTC = new TableColumn<>("Jumlah Obat");
		jumlahObatTC.setCellValueFactory(new PropertyValueFactory<>("jumlahObat"));

		TableColumn<CatatanHarianDetail, String> produksiTelurTC = new TableColumn<>("Produksi Telur");
		produksiTelurTC.setCellValueFactory(new PropertyValueFactory<>("produksiTelur"));

		TableColumn<CatatanHarianDetail, String> persentaseProduksiTC = new TableColumn<>("Persentase Produksi");
		persentaseProduksiTC.setCellValueFactory(new PropertyValueFactory<>("persentaseProduksi"));

		TableColumn<CatatanHarianDetail, String> biayaVariabelTC = new TableColumn<>("Biaya Variabel");
		biayaVariabelTC.setCellValueFactory(new PropertyValueFactory<>("biayaVariabel"));

		TableColumn<CatatanHarianDetail, String> komentarTC = new TableColumn<>("Komentar Kematian");
		komentarTC.setCellValueFactory(new PropertyValueFactory<>("komentarKematian"));

		// Add all columns to the table
		table.getColumns().addAll(
		    tanggalTC, umurTC, mingguTC, jantanTC, betinaTC, totalSisaTC, perbandinganJantanBetinaNestedTC,
		    kodePakanTC, jumlahPakanTC, pakanPerEkorTC, kodeObatTC, jumlahObatTC, 
		    produksiTelurTC, persentaseProduksiTC, biayaVariabelTC, komentarTC
		);

		table.getItems().addAll(data.getSpecificCatatanHarianDetail(kode));

		titleLbl = new Label("Detail Catatan Harian" + kode);
		
		// Button configuration
		Update = new Button("Update");
		Update.setFont(Font.font("Inter", 20));
		Update.setMinWidth(50);

		Delete = new Button("Delete");
		Delete.setFont(Font.font("Inter", 20));
		Delete.setMinWidth(50);

		InputData = new Button("Input Data");
		InputData.setFont(Font.font("Inter", 20));
		InputData.setMinWidth(50);

		ButtonContainer = new HBox();
		HBox leftBtnContainer = new HBox();
		leftBtnContainer.getChildren().addAll(InputData, Update);
		
		ButtonContainer.getChildren().addAll(leftBtnContainer, Delete);

		// Set widths of table columns dynamically based on Table width
		double columnWidth = 0.15;
		double columnWidthNested = 0.12;

		// Main Columns
		tanggalTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		umurTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		mingguTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested));
		kematianJantanTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested));
		sisaJantanTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		kematianBetinaTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested));
		sisaBetinaTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		totalSisaTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		perbandinganJantanBetinaNestedTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested));
		kodePakanTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		jumlahPakanTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		pakanPerEkorTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		kodeObatTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		jumlahObatTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		produksiTelurTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		persentaseProduksiTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		biayaVariabelTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		komentarTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));

		// Set alignment for each column
		String alignmentStyle = "-fx-alignment: CENTER;";
		
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		tanggalTC.setStyle(alignmentStyle);
		umurTC.setStyle(alignmentStyle);
		mingguTC.setStyle(alignmentStyle);
		kematianJantanTC.setStyle(alignmentStyle);
		sisaJantanTC.setStyle(alignmentStyle);
		kematianBetinaTC.setStyle(alignmentStyle);
		sisaBetinaTC.setStyle(alignmentStyle);
		totalSisaTC.setStyle(alignmentStyle);
		perbandinganJantanBetinaNestedTC.setStyle(alignmentStyle);
		kodePakanTC.setStyle(alignmentStyle);
		pakanPerEkorTC.setStyle(alignmentStyle);
		kodeObatTC.setStyle(alignmentStyle);
		jumlahObatTC.setStyle(alignmentStyle);
		produksiTelurTC.setStyle(alignmentStyle);
		persentaseProduksiTC.setStyle(alignmentStyle);
		biayaVariabelTC.setStyle(alignmentStyle);
		komentarTC.setStyle(alignmentStyle);
		TableLayout.setCenter(table);
		TableLayout.setTop(titleLbl);
		TableLayout.setBottom(ButtonContainer);
		
		mainLayout.setTop(getMb()); 
		mainLayout.setCenter(TableLayout);
		mainLayout.setLeft(getSideBar());
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
		TableLayout.setPadding(new Insets(50));
		BorderPane.setMargin(table, new Insets(15, 0, 15, 0));
		BorderPane.setAlignment(titleLbl, Pos.CENTER);
		titleLbl.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		
		ButtonContainer.setSpacing(20);
		
		getSideBarCatatanHarianLbl().setFont(Font.font("Arial", FontWeight.BOLD, 20));
	}

	public TableView<CatatanHarianDetail> getTable() {
		return table;
	}

	public void setTable(TableView<CatatanHarianDetail> table) {
		this.table = table;
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
	
}
