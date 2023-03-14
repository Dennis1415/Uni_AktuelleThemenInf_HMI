package labrithmenMain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class GameScreenController implements Initializable {
    //specifies the max bounds of the grid
    final int MIN_ROW = 0;
    final int MAX_ROW = 4;
    final int MIN_COL = 0;
    final int MAX_COL = 8;
    //saves pressed direction buttons as Strings e.g. "up" , "down" etc.
    public ArrayList<String> directionsInput = new ArrayList<String>();
    // (0|0) - (8|4)

    int xGOAL=1;
    int yGOAL=3;
    int currentLvl=1;

    int currentSteps =0;
    int currentMoves=0;

    int overallSteps =0;
    int overallMoves=0;
    int overallScore=0;
    int tempScore = 0;

    int keyboardMoves=0;

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
    @FXML
    private Button lvl1;
    @FXML
    private Button lvl2;
    @FXML
    private Button lvl3;
    @FXML
    private Button lvl4;
    @FXML
    private Button lvl5;
    @FXML
    private Button lvl6;
    @FXML
    private Text moves;
    @FXML
    private Text score;
    @FXML
    private VBox levelVbox;
    @FXML
    private Button nextButton;
    @FXML
    private Hyperlink hyperLink;


    @FXML
    private AnchorPane anchorPane;



    @FXML
    private Text lvlText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initializeLevel();
    }

    public void initializeLevel(){
        navigationBox.setVisible(false);
        currentSteps =0;
        currentMoves=0;
        moves.setText("Steps: "+ currentSteps +"\nMoves: "+currentMoves);
        inputLabel.setText("");

        switch (currentLvl) {
            case 1:
                loadLvl1();
                break;
            case 2:
                loadLvl2();
                break;
            case 3:
                loadLvl3();
            break;
            case 4:
                loadLvl4();
            break;
            case 5:
                loadLvl5();
                break;
            case 6:
                loadLvl6();
                break;
        }
    }
    @FXML
    void readKeyboardInput(KeyEvent event) {
        System.out.println("KEY PRESSED");
        KeyCode key = event.getCode();
        switch (key) {
            case W:
          //  case UP:
                up();
            keyboardMoves++;
                break;
            case A:
           // case LEFT:
                left();
                keyboardMoves++;
                break;
            case D:
           // case RIGHT:
                right();
                keyboardMoves++;
                break;
            case S:
            //case DOWN:
                down();
                keyboardMoves++;
                break;
           // case ENTER:
           //     play();
           //     break;
        }
    }

    //Searches for all the rectangles (obstacles) on the grid, saves it in a list and removes them afterwards
    public void clearGrid() {
        ArrayList<Node> nodesRemove = new ArrayList<Node>();
            for (Node node : gridPane.getChildren()) {
                if (node instanceof Rectangle) {
                    nodesRemove.add(node);
                   // gridPane.getChildren().remove(node);
                }
            }
            gridPane.getChildren().removeAll(nodesRemove);
        }


    public void loadLvl1(){
        clearGrid();
        currentLvl=1;
        lvlText.setText("Level " +currentLvl);
        initializePlayerAndGoal(2,2,5,2);

    }

    public void loadLvl2(){
        clearGrid();
        currentLvl=2;
        lvlText.setText("Level " +currentLvl);

        initializePlayerAndGoal(1,1,6,4);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,0);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,3);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,4);


    }

    public void loadLvl3(){
        currentLvl=3;

        clearGrid();
        lvlText.setText("Level " +currentLvl);


        initializePlayerAndGoal(0,0,5,4);

        gridPane.add(new Rectangle(100,100,Color.GRAY),2,0);
        gridPane.add(new Rectangle(100,100,Color.GRAY),2,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),2,2);
        gridPane.add(new Rectangle(100,100,Color.GRAY),2,4);

        gridPane.add(new Rectangle(100,100,Color.GRAY),4,0);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,3);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,4);
    }

    public void loadLvl4(){
        currentLvl=4;
        clearGrid();
        lvlText.setText("Level " +currentLvl);

        initializePlayerAndGoal(0,0,8,4);

        gridPane.add(new Rectangle(100,100,Color.GRAY),2,0);
        gridPane.add(new Rectangle(100,100,Color.GRAY),2,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),3,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),5,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),6,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),7,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),8,1);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,2);



        gridPane.add(new Rectangle(100,100,Color.GRAY),1,4);
        gridPane.add(new Rectangle(100,100,Color.GRAY),2,4);
        gridPane.add(new Rectangle(100,100,Color.GRAY),3,4);
        gridPane.add(new Rectangle(100,100,Color.GRAY),4,4);
        gridPane.add(new Rectangle(100,100,Color.GRAY),5,4);
        gridPane.add(new Rectangle(100,100,Color.GRAY),6,4);


    }

    @FXML
    void loadLvl5() {
        currentLvl=5;

        clearGrid();
        lvlText.setText("Level " +currentLvl);

        initializePlayerAndGoal(0,0,3,0);

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
    @FXML
    void loadLvl6() {
        currentLvl=6;

        clearGrid();
        lvlText.setText("Level " +currentLvl);

        initializePlayerAndGoal(0,0,5,4);

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
    public void initializePlayerAndGoal(int xPlayer, int yPlayer, int xGoal, int yGoal){
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


    @FXML
    void openLink(ActionEvent event) throws IOException {
    System.out.println("Link clicked!!");                               //insert Google Umfrage Link here!!
   ProcessBuilder processBuilder = new ProcessBuilder("cmd","/c","start","https://wd1o5l2wmjf.typeform.com/to/iFqcq91a");
   processBuilder.start();
    }


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
                   // currentSteps++; when we calculate it here - running against an obstacle isnt counted
                }
                break;

            case "down":
                if (GridPane.getRowIndex(player) + 1 <= MAX_ROW && !isOccupied(GridPane.getRowIndex(player)+1,GridPane.getColumnIndex(player))) {
                    GridPane.setRowIndex(player, GridPane.getRowIndex(player) + 1);
                   // currentSteps++;

                }
                break;
            case "left":
                if (GridPane.getColumnIndex(player) - 1 >= MIN_COL && !isOccupied(GridPane.getRowIndex(player),GridPane.getColumnIndex(player)-1)) {
                    GridPane.setColumnIndex(player, GridPane.getColumnIndex(player) - 1);
                   // currentSteps++;

                }
                break;

            case "right":
                if (GridPane.getColumnIndex(player) + 1 <= MAX_COL && !isOccupied(GridPane.getRowIndex(player),GridPane.getColumnIndex(player)+1)) {
                    GridPane.setColumnIndex(player, GridPane.getColumnIndex(player) + 1);
                   // currentSteps++;
                }
                break;
        }
    }

    @FXML
    void restartLvl(ActionEvent event) {
            initializeLevel();
    }

    @FXML
    void nextLvl(ActionEvent event) {




        currentLvl++;
        initializeLevel();
    }

    //Checks if player Node is on the goal Node
    public boolean reachedGoal() {
        if (GridPane.getColumnIndex(player) == GridPane.getColumnIndex(goal) && GridPane.getRowIndex(player) == GridPane.getRowIndex(goal)) {
            return true;
        }
        return false;
    }

    //Specifies what happens after Play-Button was pressed
    public void play() {

        for (String s : directionsInput) {
            moveCircle(s);
        }
        currentSteps +=directionsInput.size();
        currentMoves++;
        moves.setText("Steps: "+ currentSteps +"\nMoves: "+currentMoves);


        reset();

        if (reachedGoal()) {
            //hier berechnen anstelle von in nextLevel()
            overallSteps += currentSteps;
            overallMoves += currentMoves;

            overallScore+=226-(currentSteps *5)-(currentMoves*10);


            inputLabel.setText("Geschafft! Du brauchtest "+ currentSteps +" Steps und "+currentMoves +" Moves");
            navigationBox.setVisible(true);

            if(currentLvl == 6){
                overallScore += 4; // so that max score is 1000
                levelVbox.setVisible(true);

                score.setText("Score: "+overallScore);
                inputLabel.setText("Spiel durchgespielt! \n"+ overallSteps +" Steps und "+overallMoves +" Moves! "+keyboardMoves +" davon mit der Tastatur \n [BITTE GEBEN SIE DIESE INFORMATION AN UNS ZURUECK]");
                nextButton.setVisible(false);
                hyperLink.setVisible(true);
            }
            }
    }

    public void reset() {
        directionsInput.clear();
        inputLabel.setText("");
    }





}
