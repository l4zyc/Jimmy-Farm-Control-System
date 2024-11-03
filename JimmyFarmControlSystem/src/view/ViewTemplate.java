package view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;

public abstract class ViewTemplate {
	
	protected Double width = Screen.getPrimary().getBounds().getWidth();
	protected Double height = Screen.getPrimary().getBounds().getHeight();
	
	protected BorderPane mainLayout, TableLayout;

	public ViewTemplate() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void init();
	public abstract void arrangeComponent();

	public BorderPane getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(BorderPane mainLayout) {
		this.mainLayout = mainLayout;
	}

	public BorderPane getTableLayout() {
		return TableLayout;
	}

	public void setTableLayout(BorderPane tableLayout) {
		TableLayout = tableLayout;
	}

}
