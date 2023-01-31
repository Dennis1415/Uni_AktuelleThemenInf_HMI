module com.example.labrithmen {
    requires javafx.controls;
    requires javafx.fxml;


    opens labrithmenMain to javafx.fxml;
    exports labrithmenMain;
}