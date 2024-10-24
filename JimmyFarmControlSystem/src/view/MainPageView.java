package view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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

	@Override
	public void init() {
		mainLayout = new BorderPane();
		scene = new Scene(mainLayout);
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
	}

}
