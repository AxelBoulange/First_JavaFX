/**
 * 
 */
/**
 * 
 */
module app {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;

    opens app to javafx.fxml;
    opens view to javafx.fxml;
    exports app;
}
