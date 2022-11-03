module com.example.seguimiento_13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seguimiento_13 to javafx.fxml;
    exports com.example.seguimiento_13;

    opens com.example.seguimiento_13.control to javafx.fxml;
    exports com.example.seguimiento_13.control;
}