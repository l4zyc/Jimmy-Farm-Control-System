package view;

import java.util.Optional;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainPageView extends viewTemplate{

	private Scene scene;
	private BorderPane mainLayout;
	public static Stage currStage;
	
	public MainPageView() {
		start();
		new LoginView();
	}
	
	public void start() {
		init();
		arrangeComponent();
		Scene scene = new Scene(mainLayout, this.getWidth(), this.getHeight());
 
		stage.setScene(scene);
		stage.setTitle("Jimmy Farm Control System");
		stage.show();
		stage.setResizable(false);
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Do you want to Quit ?");
				alert.setTitle("Exit");
				
				Optional<ButtonType> close = alert.showAndWait();
				
				if(close.get().equals(ButtonType.CANCEL)) {
					event.consume();
				}
			}
		});
	}
	
	@Override
	public void init() {
		stage = new Stage();
		mainLayout = new BorderPane();
	}

	@Override
	public void arrangeComponent() {
		// TODO Auto-generated method stub
		
	}

}
