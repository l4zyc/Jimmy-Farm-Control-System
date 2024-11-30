package view.CatatanDetail;

import view.TableViewTemplate;
import java.sql.Date;

import controller.detailCatatan.DetailCatatanController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.CatatanHarianDetail;
import model.CatatanHarianUtama;
import util.Data;
import util.reusableMethod;
import view.TableViewTemplate;
import view.login.LoginView;


public class CatatanHarianDetailView extends TableViewTemplate{
	
	private Scene scene;
	public Stage stage;
	
	Label titleLbl, Back;
	TableView<CatatanHarianDetail> table;
	
	TableColumn<CatatanHarianDetail, Integer> jantanTC, betinaTC;
	Button Update, Delete, InputData;
	BorderPane ButtonContainer;
	String kode;
	TextField Search2;
	public CatatanHarianDetailView(String kodeCatatan) {
		this.kode = kodeCatatan;
		init();
		arrangeComponent();
		stage = new Stage();
		
		stage.setMaximized(true);
		stage.setScene(scene);
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				if (reusableMethod.confirmationAlert("Exit", "Are you sure you want to quit ?").get().equals(ButtonType.CANCEL)) {
					event.consume();
				}
			}
		});
		
		Image icon = new Image("SmallCustomLogoJimmyFarm.png");
		stage.getIcons().add(icon);		
		
		stage.setTitle("Jimmy Farm Control System");
		stage.show();
		
		new DetailCatatanController(this, kodeCatatan);
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
		
		TableColumn<CatatanHarianDetail, Integer> penjualanJantanTC = new TableColumn<>("Penjualan");
		penjualanJantanTC.setCellValueFactory(new PropertyValueFactory<>("penjualanJantan"));
		
		TableColumn<CatatanHarianDetail, Integer> afkirJantanTC = new TableColumn<>("Afkir");
		afkirJantanTC.setCellValueFactory(new PropertyValueFactory<>("afkirJantan")); 
		
		TableColumn<CatatanHarianDetail, Integer> pindahJantanTC = new TableColumn<>("Pindah");
		pindahJantanTC.setCellValueFactory(new PropertyValueFactory<>("PindahJantan"));

		TableColumn<CatatanHarianDetail, Integer> sisaJantanTC = new TableColumn<>("Sisa");
		sisaJantanTC.setCellValueFactory(new PropertyValueFactory<>("sisaJantan"));

		TableColumn<CatatanHarianDetail, Integer> jantanTC = new TableColumn<>("Jantan");
		jantanTC.getColumns().addAll(kematianJantanTC, penjualanJantanTC, afkirJantanTC, pindahJantanTC, sisaJantanTC);

		// Nested Columns for "Betina"
		TableColumn<CatatanHarianDetail, Integer> kematianBetinaTC = new TableColumn<>("Kematian");
		kematianBetinaTC.setCellValueFactory(new PropertyValueFactory<>("kematianBetina"));
		
		TableColumn<CatatanHarianDetail, Integer> penjualanBetinaTC = new TableColumn<>("Penjualan");
		penjualanBetinaTC.setCellValueFactory(new PropertyValueFactory<>("penjualanBetina"));
		
		TableColumn<CatatanHarianDetail, Integer> afkirBetinaTC = new TableColumn<>("Afkir");
		afkirBetinaTC.setCellValueFactory(new PropertyValueFactory<>("afkirBetina")); 
		
		TableColumn<CatatanHarianDetail, Integer> pindahBetinaTC = new TableColumn<>("Pindah");
		pindahBetinaTC.setCellValueFactory(new PropertyValueFactory<>("PindahBetina"));
		
		TableColumn<CatatanHarianDetail, Integer> sisaBetinaTC = new TableColumn<>("Sisa");
		sisaBetinaTC.setCellValueFactory(new PropertyValueFactory<>("sisaBetina"));

		TableColumn<CatatanHarianDetail, Integer> betinaTC = new TableColumn<>("Betina");
		betinaTC.getColumns().addAll(kematianBetinaTC, penjualanBetinaTC, afkirBetinaTC, pindahBetinaTC, sisaBetinaTC);

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

		titleLbl = new Label("Detail Catatan Harian " + kode);
		
		//Bagian button update 
		Update = new Button("Update"); 
		Update.setFont(Font.font("Inter", FontWeight.BOLD, 16));
		Update.setPadding(new Insets(10, 20, 10, 20));
		Update.setMinWidth(50); 
		Update.setStyle("-fx-background-color: #227B94; -fx-text-fill: white;");
		
		//Bagian button Delete 
		Delete = new Button("Delete"); 
		Delete.setFont(Font.font("Inter", FontWeight.BOLD, 16));
		Delete.setPadding(new Insets(10, 20, 10, 20));
		Delete.setMinWidth(50); 
		Delete.setStyle("-fx-background-color: #AF1740; -fx-text-fill: white;");

		
		//Bagian button Input Data 
		InputData = new Button("Input Data"); 
		InputData.setFont(Font.font("Inter", FontWeight.BOLD, 16));
		InputData.setPadding(new Insets(10, 20, 10, 20));
		InputData.setStyle("-fx-background-color: #000B58; -fx-text-fill: white;");
		InputData.setMinWidth(100);

		
		//Label Back 
		Back = new Label("< Back"); 
		Back.setFont(Font.font("Inter", FontWeight.BOLD, 20)); 
		
		Search2 = new TextField(); 
		Search2.setPromptText("Search...");
		Search2.setPadding(new Insets(5));
		
		ButtonContainer = new BorderPane();
		HBox leftBtnContainer = new HBox();
		leftBtnContainer.getChildren().addAll(Update, Delete);
		leftBtnContainer.setSpacing(15);
		
		HBox rightBtnContainer = new HBox();
		rightBtnContainer.getChildren().addAll(InputData);
		rightBtnContainer.setSpacing(15);
		
		ButtonContainer.setLeft(leftBtnContainer);
		ButtonContainer.setRight(rightBtnContainer);
		ButtonContainer.setPadding(new Insets(10));
		
		HBox TitleContainer = new HBox(); 
		TitleContainer.getChildren().addAll(Back, titleLbl, Search2);
		TitleContainer.setSpacing(310);
		TitleContainer.setAlignment(Pos.CENTER);
		// Set widths of table columns dynamically based on Table width
		double columnWidth = 0.15;
		double columnWidthNested = 0.12;

		// Main Columns
		tanggalTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		umurTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		mingguTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested)); 
		//=================
		kematianJantanTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested)); 
		penjualanJantanTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested));
		afkirJantanTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested)); 
		pindahJantanTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested)); 
		sisaJantanTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth));
		//=================
		kematianBetinaTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested)); 
		penjualanBetinaTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested));
		afkirBetinaTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested)); 
		pindahBetinaTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidthNested));
		sisaBetinaTC.prefWidthProperty().bind(table.widthProperty().multiply(columnWidth)); 
		//=================
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
		//============
		kematianJantanTC.setStyle(alignmentStyle); 
		penjualanJantanTC.setStyle(alignmentStyle); 
		afkirJantanTC.setStyle(alignmentStyle);  
		pindahJantanTC.setStyle(alignmentStyle); 
		sisaJantanTC.setStyle(alignmentStyle);
		//============
		kematianBetinaTC.setStyle(alignmentStyle); 
		penjualanBetinaTC.setStyle(alignmentStyle); 
		afkirBetinaTC.setStyle(alignmentStyle);  
		pindahBetinaTC.setStyle(alignmentStyle); 
		sisaBetinaTC.setStyle(alignmentStyle); 
		//============
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
		TableLayout.setTop(TitleContainer);
		TableLayout.setBottom(ButtonContainer);
		
		mainLayout.setTop(getMb()); 
		mainLayout.setCenter(TableLayout);
		mainLayout.setLeft(getSideBar());
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
		TableLayout.setPadding(new Insets(20));
		BorderPane.setMargin(table, new Insets(15, 0, 15, 0));
		BorderPane.setAlignment(titleLbl, Pos.CENTER);
		titleLbl.setFont(Font.font("Inter", FontWeight.BOLD, 35));
		
		
		getSideBarCatatanHarianLbl().setFont(Font.font("Inter", FontWeight.BOLD, 16));
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

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public Scene getScene() {
		return scene;
	}

	public Stage getStage() {
		return stage;
	}

	public Label getTitleLbl() {
		return titleLbl;
	}

	
	
	public Label getBack() {
		return Back;
	}

	public void setBack(Label back) {
		Back = back;
	}

	public TableColumn<CatatanHarianDetail, Integer> getJantanTC() {
		return jantanTC;
	}

	public TableColumn<CatatanHarianDetail, Integer> getBetinaTC() {
		return betinaTC;
	}

	public BorderPane getButtonContainer() {
		return ButtonContainer;
	}

	public TextField getSearch2() {
		return Search2;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setTitleLbl(Label titleLbl) {
		this.titleLbl = titleLbl;
	}

	public void setJantanTC(TableColumn<CatatanHarianDetail, Integer> jantanTC) {
		this.jantanTC = jantanTC;
	}

	public void setBetinaTC(TableColumn<CatatanHarianDetail, Integer> betinaTC) {
		this.betinaTC = betinaTC;
	}

	public void setButtonContainer(BorderPane buttonContainer) {
		ButtonContainer = buttonContainer;
	}

	public void setSearch2(TextField search2) {
		Search2 = search2;
	}
	
	
	
	
}
