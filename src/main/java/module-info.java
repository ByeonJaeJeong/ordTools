module com.jeong.ordtool {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.google.gson;
    requires java.logging;

    opens com.jeong.ordtool.Controller to javafx.fxml;
    exports com.jeong.ordtool;

    opens com.jeong.ordtool.Entity to com.google.gson;
}