module SceneBuilderJavaFX {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;

	opens resources to javafx.graphics, javafx.fxml;
	exports resources to javafx.fxml;
}
