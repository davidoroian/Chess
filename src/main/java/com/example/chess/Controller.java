package com.example.chess;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.Game;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private GridPane ChessBoard;

    private Game game;
    private int x, y;
    private int count=1;//the first click when opening the app is not counted

    //images for every piece
    Image blackBishop=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\BlackBishop.png");
    Image whiteBishop=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\WhiteBishop.png");
    Image blackKing=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\BlackKing.png");
    Image whiteKing=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\WhiteKing.png");
    Image blackKnight=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\BlackKnight.png");
    Image whiteKnight=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\WhiteKnight.png");
    Image blackPawn=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\BlackPawn.png");
    Image whitePawn=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\WhitePawn.png");
    Image blackQueen=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\BlackQueen.png");
    Image whiteQueen=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\WhiteQueen.png");
    Image blackRook=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\BlackRook.png");
    Image whiteRook=new Image("C:\\Users\\Admin\\Desktop\\ChessApp\\src\\main\\resources\\ChessPieces\\WhiteRook.png");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//init the board with pieces
        game=new Game();
        for (int i=0;i<8;i++)
            for (int j=0;j<8;j++) {
                //put the anchorpane and the imageview in the grid
                AnchorPane anchorPane = putAnchorPane(j,i);
                ImageView imageView = getImage(i,j,game);
                ChessBoard.add(anchorPane,j,i);
                ChessBoard.add(imageView,j,i);
            }
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
            if (game.isValidMove()){//change image only if the move is valid
                ImageView imageView=getImage(toX,toY,game);
                AnchorPane anchorPane= putAnchorPane(x,y);
                AnchorPane anchorPane1= putAnchorPane(toX,toY);
                ChessBoard.add(anchorPane,y,x);
                ChessBoard.add(anchorPane1,toY,toX);
                ChessBoard.add(imageView,toY,toX);
            }
        }

    }

    public ImageView getImage(int x, int y, Game game){//method to get the image based on the id of the piece
        ImageView imageView=new ImageView();
        switch (game.getChessBoard().getBoard()[x][y]) {
            case 1 -> imageView = new ImageView(blackPawn);
            case 2 -> imageView = new ImageView(blackRook);
            case 3 -> imageView = new ImageView(blackKnight);
            case 4 -> imageView = new ImageView(blackBishop);
            case 5 -> imageView = new ImageView(blackKing);
            case 6 -> imageView = new ImageView(blackQueen);
            case 7 -> imageView = new ImageView(whitePawn);
            case 8 -> imageView = new ImageView(whiteRook);
            case 9 -> imageView = new ImageView(whiteKnight);
            case 10 -> imageView = new ImageView(whiteBishop);
            case 11 -> imageView = new ImageView(whiteKing);
            case 12 -> imageView = new ImageView(whiteQueen);
        }
        return imageView;
    }

    public AnchorPane putAnchorPane(int i, int j){//method to put the corresponding anchorpane color based on board
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
        return anchorPane;
    }
}