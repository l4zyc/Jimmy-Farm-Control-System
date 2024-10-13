module SceneBuilderJavaFX {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;

	opens resources to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics, javafx.fxml, resources;
	
	exports resources to javafx.fxml;
	exports controller to javafx.fxml, resources;
	
	exports model to controller, resources, util;
}
