package view;

import javafx.stage.Screen;

public abstract class ViewTemplate {
	
	protected Double width = Screen.getPrimary().getBounds().getWidth();
	protected Double height = Screen.getPrimary().getBounds().getHeight(); 

	public ViewTemplate() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void init();
	public abstract void arrangeComponent();

}
