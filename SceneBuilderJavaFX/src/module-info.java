module mymodule {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;

	opens resources to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics, javafx.fxml, resources;
	
	exports resources to javafx.fxml;
	exports controller to javafx.fxml, resources;
}
