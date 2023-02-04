package labrithmenMain;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameScreenController implements Initializable {
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

    @FXML
    private HBox navigationBox;

    //specifies the max bounds of the grid
    final int MIN_ROW = 0;
    final int MAX_ROW = 4;
    final int MIN_COL = 0;
    final int MAX_COL = 8;

    // (0|0) - (8|4)
    int xPLAYER_START=0;
    int yPLAYER_START=0;
    int xGOAL=1;
    int yGOAL=3;

    int currentLvl=1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeLevel(xPLAYER_START,yPLAYER_START,xGOAL,yGOAL);
        initializeObstacles();
    }

    public void initializeObstacles(){
        switch (currentLvl) {
            case 1:
            gridPane.add(new Rectangle(100, 100, Color.GRAY), 0, 1);
            gridPane.add(new Rectangle(100, 100, Color.GRAY), 0, 2);
            gridPane.add(new Rectangle(100, 100, Color.GRAY), 0, 3);
            gridPane.add(new Rectangle(100, 100, Color.GRAY), 0, 4);
            break;
            case 2:
                loadLvl2();
                break;

            case 3:
                loadLvl3();
            break;

            default:
        }
    }
    public void loadLvl2(){
        gridPane.add(new Rectangle(100,100,Color.GRAY),0,3);
        gridPane.add(new Rectangle(100,100,Color.GRAY),0,4);

        gridPane.add(new Rectangle(100,100,Color.GRAY),2,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),2,0);

        gridPane.add(new Rectangle(100,100,Color.GRAY),2,2);
        gridPane.add(new Rectangle(100,100,Color.GRAY),3,2);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,2);
        gridPane.add(new Rectangle(100,100,Color.GRAY),5,2);
        gridPane.add(new Rectangle(100,100,Color.GRAY),6,2);
    }

    public void loadLvl3(){
        gridPane.add(new Rectangle(100,100,Color.GRAY),0,3);
        gridPane.add(new Rectangle(100,100,Color.GRAY),0,4);
        gridPane.add(new Rectangle(100,100,Color.GRAY),2,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),2,0);
        gridPane.add(new Rectangle(100,100,Color.GRAY),2,2);
        gridPane.add(new Rectangle(100,100,Color.GRAY),3,2);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,2);
        gridPane.add(new Rectangle(100,100,Color.GRAY),5,2);
        gridPane.add(new Rectangle(100,100,Color.GRAY),6,2);
        gridPane.add(new Rectangle(100,100,Color.GRAY),3,4);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,4);
        gridPane.add(new Rectangle(100,100,Color.GRAY),7,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),8,0);
    }


    //initializes player start position and goal etc
    public void initializeLevel(int xPlayer, int yPlayer, int xGoal, int yGoal){
        GridPane.setRowIndex(player, yPlayer);
        GridPane.setColumnIndex(player, xPlayer);

        GridPane.setRowIndex(goal, yGoal);
        GridPane.setColumnIndex(goal, xGoal);
    }

    public boolean isOccupied(int targetRow, int targetColumn){
        for(Node node : gridPane.getChildren()){
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer columnIndex = GridPane.getColumnIndex(node);
            if (rowIndex != null && rowIndex == targetRow && columnIndex != null && columnIndex == targetColumn && !((targetRow == GridPane.getRowIndex(goal)) && targetColumn == GridPane.getColumnIndex(goal))) {
                return true;
            }
        }
        return false;
    }


    //saves pressed direction buttons as Strings e.g. "up" , "down" etc.
    public ArrayList<String> directionsInput = new ArrayList<String>();

    @FXML
    public void up() {
        directionsInput.add("up");
        inputLabel.setText(directionsInput.toString());
    }

    public void down() {
        directionsInput.add("down");
        inputLabel.setText(directionsInput.toString());
    }

    public void left() {
        directionsInput.add("left");
        inputLabel.setText(directionsInput.toString());
    }

    public void right() {
        directionsInput.add("right");
        inputLabel.setText(directionsInput.toString());
    }


    //Moves player node depending on direction passed by String
    public void moveCircle(String s) {
        switch (s) {
            case "up":
                if (GridPane.getRowIndex(player) - 1 >= MIN_ROW && !isOccupied(GridPane.getRowIndex(player)-1,GridPane.getColumnIndex(player))) {
                    GridPane.setRowIndex(player, GridPane.getRowIndex(player) - 1);
                }
                break;

            case "down":
                if (GridPane.getRowIndex(player) + 1 <= MAX_ROW && !isOccupied(GridPane.getRowIndex(player)+1,GridPane.getColumnIndex(player))) {
                    GridPane.setRowIndex(player, GridPane.getRowIndex(player) + 1);
                }
                break;
            case "left":
                if (GridPane.getColumnIndex(player) - 1 >= MIN_COL && !isOccupied(GridPane.getRowIndex(player),GridPane.getColumnIndex(player)-1)) {
                    GridPane.setColumnIndex(player, GridPane.getColumnIndex(player) - 1);
                }
                break;

            case "right":
                if (GridPane.getColumnIndex(player) + 1 <= MAX_COL && !isOccupied(GridPane.getRowIndex(player),GridPane.getColumnIndex(player)+1)) {
                    GridPane.setColumnIndex(player, GridPane.getColumnIndex(player) + 1);
                }
                break;
        }
    }

    @FXML
    void restartLvl(ActionEvent event) {
            inputLabel.setText("");
            initializeLevel(xPLAYER_START,yPLAYER_START,xGOAL,yGOAL);
            navigationBox.setVisible(false);
    }

    @FXML
    void nextLvl(ActionEvent event) {
        currentLvl++;
        inputLabel.setText("");
        initializeLevel(xPLAYER_START,yPLAYER_START,xGOAL,yGOAL);
        navigationBox.setVisible(false);
        initializeObstacles();

    }

    //Checks if player Node is on the goal Node
    public boolean reachedGoal() {
        if (GridPane.getColumnIndex(player) == GridPane.getColumnIndex(goal) && GridPane.getRowIndex(player) == GridPane.getRowIndex(goal)) {
            return true;
        }
        return false;
    }

    //Specifies what happens after Play-Button was pressed
    public void play() throws InterruptedException {

        for (String s : directionsInput) {
            moveCircle(s);
        }
        if (reachedGoal()) {
            inputLabel.setText("GEWONNEN!!!!!!!!!!!!");
            navigationBox.setVisible(true);
        }
        reset();
    }

    public void reset() {
        directionsInput.clear();
       // inputLabel.setText("");
    }





}
