module com.example.javafx_design {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_design to javafx.fxml;
    exports com.example.javafx_design;
}