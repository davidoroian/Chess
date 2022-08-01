package model;

import java.util.*;

public class Game {
    static Scanner in = new Scanner(System.in);
    ChessBoard chessBoard = new ChessBoard(); //empty board
    Pawn[] blackPawn = new Pawn[8];  //black pawns
    Pawn[] whitePawn = new Pawn[8];   //white pawns
    Rook[] blackRook = new Rook[2]; // black rooks
    Rook[] whiteRook = new Rook[2]; // white rooks
    Knight[] blackKnight = new Knight[2]; // black knights
    Knight[] whiteKnight = new Knight[2]; // white rooks
    Bishop[] blackBishop = new Bishop[2]; // black bishops
    Bishop[] whiteBishop = new Bishop[2]; // white bishops
    King blackKing = new King(7, 3, "black"); //black king
    King whiteKing = new King(0, 3, "white"); // white king
    Queen blackQueen = new Queen(7, 4, "black"); //black queen
    Queen whiteQueen = new Queen(0, 4, "white"); //white queen
    Map<Integer, Integer> takenPieces = new HashMap<>();//map to store the id of the pieces and the number of pieces that are taken
    boolean validMove;//to notice if the move is valid

    public Game() {
        //Game game=new Game();

        //chessBoard.displayBoard();
        for (int i = 1; i <= 12; i++) {
            takenPieces.put(i, 0);
        }

        for (int i = 0; i < 8; i++) {
            blackPawn[i] = new Pawn(6, i, "black");
            chessBoard.placePiece(blackPawn[i]);
        }


        for (int i = 0; i < 8; i++) {
            whitePawn[i] = new Pawn(1, i, "white");
            chessBoard.placePiece(whitePawn[i]);
        }


        blackRook[0] = new Rook(7, 0, "black");
        chessBoard.placePiece(blackRook[0]);
        blackRook[1] = new Rook(7, 7, "black");
        chessBoard.placePiece(blackRook[1]);

        whiteRook[0] = new Rook(0, 0, "white");
        chessBoard.placePiece(whiteRook[0]);
        whiteRook[1] = new Rook(0, 7, "white");
        chessBoard.placePiece(whiteRook[1]);

        blackKnight[0] = new Knight(7, 1, "black");
        chessBoard.placePiece(blackKnight[0]);
        blackKnight[1] = new Knight(7, 6, "black");
        chessBoard.placePiece(blackKnight[1]);

        whiteKnight[0] = new Knight(0, 1, "white");
        chessBoard.placePiece(whiteKnight[0]);
        whiteKnight[1] = new Knight(0, 6, "white");
        chessBoard.placePiece(whiteKnight[1]);

        blackBishop[0] = new Bishop(7, 2, "black");
        chessBoard.placePiece(blackBishop[0]);
        blackBishop[1] = new Bishop(7, 5, "black");
        chessBoard.placePiece(blackBishop[1]);

        whiteBishop[0] = new Bishop(0, 2, "white");
        chessBoard.placePiece(whiteBishop[0]);
        whiteBishop[1] = new Bishop(0, 5, "white");
        chessBoard.placePiece(whiteBishop[1]);

        chessBoard.placePiece(blackKing);

        chessBoard.placePiece(whiteKing);

        chessBoard.placePiece(blackQueen);

        chessBoard.placePiece(whiteQueen);

        chessBoard.displayBoard();
    }


    public void playGameMethod(int pieceX, int pieceY, int toX, int toY) {
        int takenID = -1;//get the (eventual) ID of the piece that is taken by the piece. if  it remains -1, no piece is taken
        validMove=false;

        switch (chessBoard.getBoard()[pieceX][pieceY]) { //getting the id of the piece, so I know what piece I want to move
            case 1 -> {
                for (int i = 0; i < 8; i++) {
                    if (blackPawn[i].getX() == pieceX && blackPawn[i].getY() == pieceY) {//finding the right black pawn
                        blackPawn[i].move(chessBoard.getBoard(), toX, toY);//moving the pawn
                        takenID = blackPawn[i].getTakenID();//update the ID of the taken piece
                        if (toX == 0) {
                            replacePiece(1, 0, toY);
                        }
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < 2; i++) {
                    if (blackRook[i].getX() == pieceX && blackRook[i].getY() == pieceY) { //finding the right black rook
                        blackRook[i].move(chessBoard.getBoard(), toX, toY);   //moving the rook
                        takenID = blackRook[i].getTakenID();
                    }
                }
            }
            case 3 -> {
                for (int i = 0; i < 2; i++) {
                    if (blackKnight[i].getX() == pieceX && blackKnight[i].getY() == pieceY) { //finding the right black knight
                        blackKnight[i].move(chessBoard.getBoard(), toX, toY);   //moving the knight
                        takenID = blackKnight[i].getTakenID();
                    }
                }
            }
            case 4 -> {
                for (int i = 0; i < 2; i++) {
                    if (blackBishop[i].getX() == pieceX && blackBishop[i].getY() == pieceY) { //finding the right black bishop
                        blackBishop[i].move(chessBoard.getBoard(), toX, toY);   //moving the bishop
                        takenID = blackBishop[i].getTakenID();
                    }
                }
            }
            case 5 -> {
                blackKing.move(chessBoard.getBoard(), toX, toY);
                takenID = blackKing.getTakenID();
            }
            case 6 -> {
                blackQueen.move(chessBoard.getBoard(), toX, toY);
                takenID = blackQueen.getTakenID();
            }
            case 7 -> {
                for (int i = 0; i < 8; i++) {
                    if (whitePawn[i].getX() == pieceX && whitePawn[i].getY() == pieceY) { //finding the right white pawn
                        whitePawn[i].move(chessBoard.getBoard(), toX, toY);   //moving the pawn
                        takenID = whitePawn[i].getTakenID();
                        if (toX == 7) {
                            replacePiece(7, 7, toY);
                        }
                    }
                }
            }
            case 8 -> {
                for (int i = 0; i < 2; i++) {
                    if (whiteRook[i].getX() == pieceX && whiteRook[i].getY() == pieceY) { //finding the right white rook
                        whiteRook[i].move(chessBoard.getBoard(), toX, toY);   //moving the rook
                        takenID = whiteRook[i].getTakenID();
                    }
                }
            }
            case 9 -> {
                for (int i = 0; i < 2; i++) {
                    if (whiteKnight[i].getX() == pieceX && whiteKnight[i].getY() == pieceY) { //finding the right white knight
                        whiteKnight[i].move(chessBoard.getBoard(), toX, toY);   //moving the knight
                        takenID = whiteKnight[i].getTakenID();
                    }
                }
            }
            case 10 -> {
                for (int i = 0; i < 2; i++) {
                    if (whiteBishop[i].getX() == pieceX && whiteBishop[i].getY() == pieceY) { //finding the right white bishop
                        whiteBishop[i].move(chessBoard.getBoard(), toX, toY);   //moving the bishop
                        takenID = whiteBishop[i].getTakenID();
                    }
                }
            }
            case 11 -> {
                whiteKing.move(chessBoard.getBoard(), toX, toY);
                takenID = whiteKing.getTakenID();
            }
            case 12 -> {
                whiteQueen.move(chessBoard.getBoard(), toX, toY);
                takenID = whiteQueen.getTakenID();
            }
            default -> throw new IllegalStateException("Unexpected value: " + chessBoard.getBoard()[pieceX][pieceY]);
        }
        if (takenID != -1 && takenID!=0)//verify if a piece was taken
            takenPieces.put(takenID, takenPieces.get(takenID) + 1);
        if (takenID!=-1)
            validMove=true;

        chessBoard.displayBoard();

        for (Integer x : takenPieces.values())//display the values from the map
            System.out.print(x + " ");
        System.out.println("\n");
    }

    public void replacePiece(int pawnID, int x, int y) {
        int id;
        System.out.print("Enter the id of the piece you want back: ");
        id = in.nextInt();
        if (pawnID == 1) {
            if (id < 6) {
                if (takenPieces.get(id)!=0) {
                    chessBoard.getBoard()[x][y] = id;
                    takenPieces.put(id, takenPieces.get(id) - 1);
                } else {
                    System.out.println("Piece is still in the game");
                }
            } else {
                System.out.println("That is an enemy piece!");
            }
        }
        if (pawnID == 7) {
            if (id > 6) {
                if (takenPieces.get(id)!=0) {
                    chessBoard.getBoard()[x][y] = id;
                    takenPieces.put(id, takenPieces.get(id) - 1);
                } else {
                    System.out.println("Piece is still in the game");
                }
            } else {
                System.out.println("That is an enemy piece!");
            }
        }
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public boolean isValidMove() {
        return validMove;
    }
}
