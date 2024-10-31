module JimmyFarmControlSystem {
	requires javafx.graphics;  
	requires javafx.controls;
	requires java.sql;
	requires javafx.base;
	exports main;
	opens main to java.sql;
	opens model to javafx.base;
	opens controller to view;
}