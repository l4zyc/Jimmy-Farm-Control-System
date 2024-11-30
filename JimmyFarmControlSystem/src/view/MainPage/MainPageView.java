package view.MainPage;

import java.sql.Date;

import controller.mainPage.MainPageController;
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
import model.CatatanHarianUtama;
import util.Data;
import util.reusableMethod;
import view.TableViewTemplate;
import view.login.LoginView;
public class MainPageView extends TableViewTemplate{
	
	private Scene scene;
	public static Stage mainStage;
	private Data data = new Data();
	
	public MainPageView() {
		

		init();
		arrangeComponent();
		mainStage = new Stage();
		
		mainStage.setMaximized(true);
		mainStage.setScene(scene);
		
		Image icon = new Image("SmallCustomLogoJimmyFarm.png");
		mainStage.getIcons().add(icon);		
		
		mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				if (reusableMethod.confirmationAlert("Exit", "Are you sure you want to quit ?").get().equals(ButtonType.CANCEL)) {
					event.consume();
				}
			}
		});
		
		mainStage.setTitle("Jimmy Farm Control System");
		mainStage.show();

		new MainPageController(this);
	}
	
	//CatatanHarianLbl = judul yang diatas tabel 
	//JFCSLbl = Jimmy Farm Control System
	
	Label CatatanHarianLbl; 
	TextField Search;
	TableView<CatatanHarianUtama> Table;
	TableColumn<CatatanHarianUtama, String> KodeCatatanTC, KodeKandangTC, KeteranganJenisTC, KomentarTC;
	TableColumn<CatatanHarianUtama, Date> TanggalMasukTC;
	TableColumn<CatatanHarianUtama, Integer> JumlahAwalJantanTC, JumlahAwalBetinaTC; 
	Button Update, Delete, InputData, CatatanHarianDetail;
	
	//Daftar tabel samping
	Label DaftarTabel, CatatanHarianLbl2, MasterPakanLbl, MasterObatLbl, MasterSupplierLbl, MasterKandangLbl; 
	BorderPane ButtonContainer;
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
		
		Search = new TextField(); 
		Search.setPromptText("Search...");
		Search.setPadding(new Insets(5));
		
		//Bagian catatan Harian Detail
		CatatanHarianDetail = new Button("Catatan Harian Detail"); 
		CatatanHarianDetail.setFont(Font.font("Inter", FontWeight.BOLD, 16));
		CatatanHarianDetail.setPadding(new Insets(10, 20, 10, 20));
		CatatanHarianDetail.setStyle("-fx-background-color: #006A67; -fx-text-fill: white;");
		
		ButtonContainer = new BorderPane();
		
		
		KodeCatatanTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		KodeKandangTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		JumlahAwalBetinaTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.12));
		JumlahAwalJantanTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.12));
		KeteranganJenisTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		KomentarTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		TanggalMasukTC.prefWidthProperty().bind(Table.widthProperty().multiply(0.15));
		
		Table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		KodeCatatanTC.setStyle("-fx-alignment: CENTER;");
		KodeKandangTC.setStyle("-fx-alignment: CENTER;");
		JumlahAwalBetinaTC.setStyle("-fx-alignment: CENTER;");
		JumlahAwalJantanTC.setStyle("-fx-alignment: CENTER;");
		KeteranganJenisTC.setStyle("-fx-alignment: CENTER;");
		KomentarTC.setStyle("-fx-alignment: CENTER;");
		TanggalMasukTC.setStyle("-fx-alignment: CENTER;");
		
		mainLayout.setTop(getMb()); 
		mainLayout.setCenter(TableLayout);
		mainLayout.setLeft(getSideBar());
	}

	@Override
	public void arrangeComponent() {
		HBox leftBtnContainer = new HBox();
		HBox rightBtnContainer = new HBox();
		HBox TitleContainer = new HBox();
		leftBtnContainer.getChildren().addAll(Update, Delete);
		leftBtnContainer.setSpacing(15);
		
		rightBtnContainer.getChildren().addAll(CatatanHarianDetail, InputData);
		rightBtnContainer.setSpacing(15);
		
		CatatanHarianLbl = new Label("Catatan Harian");
		CatatanHarianLbl.setFont(Font.font("Inter", FontWeight.BOLD, 35));
		
		TitleContainer.getChildren().addAll(CatatanHarianLbl, Search); 
		TitleContainer.setAlignment(Pos.TOP_RIGHT);
		TitleContainer.setSpacing(375);
		
		ButtonContainer.setLeft(leftBtnContainer);
		ButtonContainer.setRight(rightBtnContainer);
		
		TableLayout.setTop(TitleContainer);
		TableLayout.setCenter(Table);
		TableLayout.setBottom(ButtonContainer);
		
		
		BorderPane.setMargin(Table, new Insets(15, 0, 15, 0));
		BorderPane.setAlignment(TitleContainer, Pos.CENTER); 
		BorderPane.setAlignment(CatatanHarianLbl, Pos.CENTER);
		getSideBarCatatanHarianLbl().setFont(Font.font("Inter", FontWeight.BOLD, 16));
	
		
		TableLayout.setPadding(new Insets(80));

	}

	public Data getData() {
		return data;
	}

	public TableColumn<CatatanHarianUtama, String> getKodeCatatanTC() {
		return KodeCatatanTC;
	}
	
	
	
	public TextField getSearch() {
		return Search;
	}

	public void setSearch(TextField search) {
		Search = search;
	}

	public Label getMasterKandangLbl() {
		return MasterKandangLbl;
	}


	public BorderPane getButtonContainer() {
		return ButtonContainer;
	}
	
	public Button getCatatanHarianDetail() {
		return CatatanHarianDetail;
	}

	public void setCatatanHarianDetail(Button catatanHarianDetail) {
		CatatanHarianDetail = catatanHarianDetail;
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


	public void setButtonContainer(BorderPane buttonContainer) {
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
