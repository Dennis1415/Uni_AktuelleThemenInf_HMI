package labrithmenMain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;

public class GameScreenController {
    @FXML
    private GridPane gridPane;
    @FXML
    private Circle myCircle;
    @FXML
    private Polygon goal;
    @FXML
    private Button playButton;
    @FXML
    private Button resetButton;

    @FXML
    private Label inputLabel;

   final int  minRow=0;
   final int maxRow=4;

    final  int minCol=0;
    final  int maxCol=8;


    public ArrayList<String> buttonInput = new ArrayList<String>();


    @FXML
    public void up() {
        buttonInput.add("up");
        inputLabel.setText(buttonInput.toString());
    }

    public void down() {
        buttonInput.add("down");
        inputLabel.setText(buttonInput.toString());
    }

    public void left() {
        buttonInput.add("left");
        inputLabel.setText(buttonInput.toString());
    }

    public void right() {
        buttonInput.add("right");
        inputLabel.setText(buttonInput.toString());
    }






    public void moveCircle(String s) {
        switch (s) {
            case "up":
                if(GridPane.getRowIndex(myCircle)-1 >= minRow) {
                    GridPane.setRowIndex(myCircle, GridPane.getRowIndex(myCircle) - 1);}
                break;

            case "down":
                if(GridPane.getRowIndex(myCircle)+1 <= maxRow) {
                GridPane.setRowIndex(myCircle, GridPane.getRowIndex(myCircle) + 1);}
                break;
            case "left":
                if(GridPane.getColumnIndex(myCircle)-1 >= minCol) {
                GridPane.setColumnIndex(myCircle, GridPane.getColumnIndex(myCircle) - 1);}
                break;

            case "right":
                if(GridPane.getColumnIndex(myCircle)+1 <= maxCol) {
                    GridPane.setColumnIndex(myCircle, GridPane.getColumnIndex(myCircle) + 1);}
                break;
        }
    }

    public boolean reachedGoal(Node player, Node goal){
        if(GridPane.getColumnIndex(player) == GridPane.getColumnIndex(goal) && GridPane.getRowIndex(player) == GridPane.getRowIndex(goal)){
            return true;
        }
        return false;
    }
    public void play() throws InterruptedException {

        for (String s : buttonInput) {
            moveCircle(s);

        }
        if(reachedGoal(myCircle,goal)){
            System.out.println("GEWONENEENENEN");
        }
        reset();
    }

    public void reset() {
        buttonInput.clear();
        inputLabel.setText("");
    }
}
