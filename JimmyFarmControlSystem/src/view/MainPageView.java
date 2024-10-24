package view;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainPageView extends ViewTemplate{
	
	private Scene scene;
	public static Stage mainStage;

	public MainPageView(Stage stage) {
		init();
		arrangeComponent();
		
		this.mainStage = stage;
		
		stage.setTitle("Jimmy Farm Control System"); 
		stage.show(); 
	}

	@Override
	public void init() {
		new LoginView();
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
	}

}
