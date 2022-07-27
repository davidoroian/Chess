package com.example.chess;

public class King extends ChessPiece {
    public King(int x, int y, String color) {
        this.setX(x);
        this.setY(y);
        this.setColor(color);
        switch (color) {
            case "black" -> {
                this.id = 5;
            }
            case "white" -> {
                this.id = 11;
            }
            default -> System.out.println("Unexpected value: " + color);
        }

    }

    @Override
    public boolean movePossible(int[][] board, int x, int y) {
        if ((Math.abs(this.getX()) - x == Math.abs(this.getY()) - y) && Math.abs(this.getY()) - y == 1) return true;
        if ((Math.abs(this.getX() - x) == 1 && this.getY() == y) || (Math.abs(this.getY() - y) == 1 && this.getX() == x)) return true;
        return false;
    }
}
