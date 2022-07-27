package com.example.chess;

public class Bishop extends ChessPiece {
    public Bishop(int x, int y, String color) {
        this.setX(x);
        this.setY(y);
        this.setColor(color);
        switch (color) {
            case "black" -> {
                this.id = 4;
            }
            case "white" -> {
                this.id = 10;
            }
            default -> System.out.println("Unexpected value: " + color);
        }
    }

    @Override
    public boolean movePossible(int[][] board, int x, int y) {
        int i = this.getX(), j = this.getY();
        int diff = Math.abs(this.getX() - x);

        if (Math.abs(this.getX() - x) == Math.abs(this.getY() - y)) {
            if (Math.abs(this.getX() - x) == 1) return true;
            else {
                if (x < this.getX() && y > this.getY()) { //NE
                    i--;
                    j++;
                    while (Math.abs(this.getX() - i) < diff) {
                        if (board[i][j] != 0) return false;
                        i--;
                        j++;
                    }
                    return true;
                }

                if (x > this.getX() && y > this.getY()) { //SE
                    i++;
                    j++;
                    while (Math.abs(this.getX() - i) < diff) {
                        if (board[i][j] != 0) return false;
                        i++;
                        j++;
                    }
                    return true;
                }

                if (x < this.getX() && y < this.getY()) { //NV
                    i--;
                    j--;
                    while (Math.abs(this.getX() - i) < diff) {
                        if (board[i][j] != 0) return false;
                        i--;
                        j--;
                    }
                    return true;
                }

                if (x > this.getX() && y < this.getY()) { //SV
                    i++;
                    j--;
                    while (Math.abs(this.getX() - i) < diff) {
                        if (board[i][j] != 0) return false;
                        i++;
                        j--;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
