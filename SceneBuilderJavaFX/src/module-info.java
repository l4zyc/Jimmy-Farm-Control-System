module mymodule {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;

	opens resources to javafx.graphics, javafx.fxml;
	exports resources to javafx.fxml;
}
