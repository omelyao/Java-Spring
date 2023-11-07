module com.example.mod6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mod6 to javafx.fxml;
    exports com.example.mod6;
}