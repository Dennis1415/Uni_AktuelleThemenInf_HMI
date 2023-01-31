package labrithmenMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("gameScreen.fxml"));
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root));
        stage.setHeight(513);
        stage.setWidth(699);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}