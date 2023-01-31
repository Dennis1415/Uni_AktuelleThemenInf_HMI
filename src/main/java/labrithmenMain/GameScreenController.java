package labrithmenMain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class GameScreenController {
    @FXML private GridPane gridPane;
    @FXML private Circle myCircle;
    @FXML private Button playButton;
    @FXML private Button resetButton;



   @FXML private Button ex1;
   @FXML private Button ex2;
   @FXML private Button ex3;
   @FXML private Button ex4;
   @FXML private Button ex5;



    private double x;
    private double y;
    public int counter = 0;

    @FXML
    public void up(ActionEvent e){
        if(counter == 0){
            ex1.setText("up");
            counter++;
        }else if(counter == 1){
            ex2.setText("up");
            counter++;
        }else if(counter == 2){
            ex3.setText("up");
            counter++;
        }else if(counter == 3){
            ex4.setText("up");
            counter++;
        }else if(counter == 4){
            ex5.setText("up");
            counter++;
        }
        System.out.print(e.toString());
        //myCircle.setCenterY(y-=10);
        }
    public void down(ActionEvent e){
        //myCircle.setCenterY(y+=36.5);
        if(counter == 0){
            ex1.setText("down");
            counter++;
        }else if(counter == 1){
            ex2.setText("down");
            counter++;
        }else if(counter == 2){
            ex3.setText("down");
            counter++;
        }else if(counter == 3){
            ex4.setText("down");
            counter++;
        }else if(counter == 4){
            ex5.setText("down");
            counter++;
        }
    }
    public void left(ActionEvent e){
        //myCircle.setCenterX(x-=10);
        if(counter == 0){
            ex1.setText("left");
            counter++;
        }else if(counter == 1){
            ex2.setText("left");
            counter++;
        }else if(counter == 2){
            ex3.setText("left");
            counter++;
        }else if(counter == 3){
            ex4.setText("left");
            counter++;
        }else if(counter == 4){
            ex5.setText("left");
            counter++;
        }
    }
    public void right(ActionEvent e){
        //myCircle.setCenterX(x+=36.5);
        if(counter == 0){
            ex1.setText("right");
            counter++;
        }else if(counter == 1){
            ex2.setText("right");
            counter++;
        }else if(counter == 2){
            ex3.setText("right");
            counter++;
        }else if(counter == 3){
            ex4.setText("right");
            counter++;
        }else if(counter == 4){
            ex5.setText("right");
            counter++;
        }
    }
    public void play(ActionEvent e){
        String[] text = {ex1.getText(), ex2.getText(), ex3.getText(), ex4.getText(), ex5.getText()};
        for(int i = 0; i < text.length; i++){
                if(text[i] == "up"){
                    GridPane.setRowIndex(myCircle,GridPane.getRowIndex(myCircle)-1);
                }else if(text[i] == "down"){
                    GridPane.setRowIndex(myCircle,GridPane.getRowIndex(myCircle)+1);
                }else if(text[i] == "left"){
                    GridPane.setColumnIndex(myCircle,GridPane.getColumnIndex(myCircle)-1);
                }else if(text[i] == "right"){
                    GridPane.setColumnIndex(myCircle,GridPane.getColumnIndex(myCircle)+1);
                }
            }
        reset();
        }
    public void reset(){
        counter = 0;
        ex1.setText("");
        ex2.setText("");
        ex3.setText("");
        ex4.setText("");
        ex5.setText("");
    }
}
