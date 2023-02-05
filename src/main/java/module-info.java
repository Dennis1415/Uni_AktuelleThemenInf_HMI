module com.example.labrithmen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    //requires java.desktop;


    opens labrithmenMain to javafx.fxml;
    exports labrithmenMain;
}