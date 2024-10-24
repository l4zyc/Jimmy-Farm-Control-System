package view;

import javafx.stage.Screen;
import javafx.stage.Stage;

public abstract class viewTemplate {
	
	protected Stage stage;
	private Double width, height;

	public viewTemplate() {
		this.width = Screen.getPrimary().getBounds().getWidth();
		this.height = Screen.getPrimary().getBounds().getHeight();
	}
	
	public abstract void init();
	public abstract void arrangeComponent();

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
}
