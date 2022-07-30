package model;

public class Knight extends ChessPiece {
    public Knight(int x, int y, String color) {
        this.setX(x);
        this.setY(y);
        this.setColor(color);
        switch (color) {
            case "black" -> {
                this.id = 3;
            }
            case "white" -> {
                this.id = 9;
            }
            default -> System.out.println("Unexpected value: " + color);
        }
    }

    @Override
    public boolean movePossible(int[][] board, int x, int y) {
        if ((x >= 0 && x < 8) && (y >= 0 && y < 8) && (this.getY() != y || this.getX() != x)) { //in boundaries
            if ((Math.abs(this.getX() - x) == 2 || Math.abs(this.getY() - y) == 2) && (Math.abs(this.getX() - x) + Math.abs(this.getY() - y) == 3))
                return true; //L-s on the board
        }
        return false;
    }

}

