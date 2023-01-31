module com.example.labrithmen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.labrithmen to javafx.fxml;
    exports com.example.labrithmen;
}