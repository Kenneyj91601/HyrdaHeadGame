module com.example.kmjbwy_lab9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kmjbwy_lab9 to javafx.fxml;
    exports com.example.kmjbwy_lab9;
}