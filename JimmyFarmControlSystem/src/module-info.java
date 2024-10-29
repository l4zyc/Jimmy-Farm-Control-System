/**
 * 
 */
/**
 * 
 */
module JimmyFarmControlSystem {
	requires javafx.graphics;  
	requires javafx.controls;
	requires java.sql;
	exports main;
	opens main to java.sql;
	opens model to javafx.base;
}