package view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;

public abstract class ViewTemplate {
	
	protected Double width = Screen.getPrimary().getBounds().getWidth();
	protected Double height = Screen.getPrimary().getBounds().getHeight();
	private GridPane sideBar, sideBarTop, sideBarBottom;
	
	public ViewTemplate() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void init();
	public abstract void arrangeComponent();

}
