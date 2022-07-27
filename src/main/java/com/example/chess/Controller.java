package com.example.chess;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private GridPane ChessBoard;
    @FXML
    private ImageView myPawnWhite;

    private Game game;
    private int x, y;
    private int count=1;//the first click when opening the app is not counted

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i=0;i<8;i++)
            for (int j=0;j<8;j++) {
                AnchorPane anchorPane=new AnchorPane();
                //set the chessboard design
                if (i%2==0) {
                    if (j % 2 != 0)
                        anchorPane.setBackground(new Background(new BackgroundFill(Color.color(0.411, 0.411, 0.411), null, null)));
                    else
                        anchorPane.setBackground(new Background(new BackgroundFill(Color.color(1, 0.98, 0.8), null, null)));
                }
                else{
                    if (j % 2 != 0)
                        anchorPane.setBackground(new Background(new BackgroundFill(Color.color(1, 0.98, 0.8), null, null)));
                    else
                        anchorPane.setBackground(new Background(new BackgroundFill(Color.color(0.411, 0.411, 0.411), null, null)));
                }

                GridPane.setRowIndex(anchorPane,i);
                GridPane.setColumnIndex(anchorPane,j);
                anchorPane.getChildren().add(new ImageView());
                ChessBoard.getChildren().add(anchorPane);
            }
        game=new Game();
    }

    @FXML
    public void mouseClicked(MouseEvent e){//get the indices where the mouse is clicked
        Node node= (Node) e.getTarget();
        y= GridPane.getColumnIndex(node);
        x= GridPane.getRowIndex(node);
        count++;//count to know that the piece would go from a pair of indices to another
    }

    public void getToXY(MouseEvent e){//when releasing the mouse
        int toX, toY;
        Node node= (Node) e.getTarget();
        toY= GridPane.getColumnIndex(node);
        toX= GridPane.getRowIndex(node);
        if (count==2) {//call the method from game only when we have the two pair of indices
            game.playGameMethod(x, y, toX, toY);
            count=0;//reset count to 0
        }

    }

}