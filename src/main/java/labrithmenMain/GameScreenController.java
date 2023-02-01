package labrithmenMain;

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
    private Circle player;
    @FXML
    private Polygon goal;
    @FXML
    private Button playButton;
    @FXML
    private Button resetButton;

    @FXML
    private Label inputLabel;

    //specifies the max bounds of the grid
    final int MIN_ROW = 0;
    final int MAX_ROW = 4;
    final int MIN_COL = 0;
    final int MAX_COL = 8;


    //initializes player start position and goal etc
    public void initializeLevel(){

    }

    //saves pressed direction buttons as Strings e.g. "up" , "down" etc.
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

    //Moves player node depending on direction passed by String
    public void moveCircle(String s) {
        switch (s) {
            case "up":
                if (GridPane.getRowIndex(player) - 1 >= MIN_ROW) {
                    GridPane.setRowIndex(player, GridPane.getRowIndex(player) - 1);
                }
                break;

            case "down":
                if (GridPane.getRowIndex(player) + 1 <= MAX_ROW) {
                    GridPane.setRowIndex(player, GridPane.getRowIndex(player) + 1);
                }
                break;
            case "left":
                if (GridPane.getColumnIndex(player) - 1 >= MIN_COL) {
                    GridPane.setColumnIndex(player, GridPane.getColumnIndex(player) - 1);
                }
                break;

            case "right":
                if (GridPane.getColumnIndex(player) + 1 <= MAX_COL) {
                    GridPane.setColumnIndex(player, GridPane.getColumnIndex(player) + 1);
                }
                break;
        }
    }

    //Checks if player Node is on the goal Node
    public boolean reachedGoal(Node player, Node goal) {
        if (GridPane.getColumnIndex(player) == GridPane.getColumnIndex(goal) && GridPane.getRowIndex(player) == GridPane.getRowIndex(goal)) {
            return true;
        }
        return false;
    }

    //Specifies what happens after Play-Button was pressed
    public void play() throws InterruptedException {

        for (String s : buttonInput) {
            moveCircle(s);
        }
        if (reachedGoal(player, goal)) {
            System.out.println("GEWONNEN!!!!!!!!!!!!");
        }
        reset();
    }


    public void reset() {
        buttonInput.clear();
        inputLabel.setText("");
    }
}
