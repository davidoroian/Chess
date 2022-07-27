package com.example.chess;

public class ChessBoard {
    int[][] board;

    public ChessBoard() {
        this.board = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
                if (board[i][j] >= 10) System.out.print(" ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

    public <T extends ChessPiece> void placePiece(T piece) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == piece.getX() && j == piece.getY()) {
                    board[i][j] = piece.id;
                }
            }
        }
    }
}
