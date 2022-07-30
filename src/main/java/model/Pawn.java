package model;

public class Pawn extends ChessPiece {
    public Pawn(int x, int y, String color) {
        this.setX(x);
        this.setY(y);
        this.setColor(color);
        switch (color) {
            case "black" -> {
                this.id = 1;
            }
            case "white" -> {
                this.id = 7;
            }
            default -> System.out.println("Unexpected value: " + color);
        }
    }

    @Override
    public boolean movePossible(int[][] board, int x, int y) {
        switch (color) {
            case "black" -> {
                if (this.getX() == 6 && this.getX()-x==2) { //if at the starting position, it can move 2 positions in front
                    if (y == this.getY() && board[x][y] == 0 && board[x+1][y] == 0) return true;
                }
                if ((x == this.getX() - 1 && x >= 0 && x < 8) && (y >= 0 && y < 8)) { //one step forward at a time in any direction
                    if (y == this.getY() && board[x][y] == 0)  return true;//forward if no piece in front
                    if ((y == this.getY() - 1 || y == this.getY() + 1) && board[x][y] != 0) { //to the sides to attack
                        if (board[x][y] >= 7 && board[x][y] <= 12) return true;
                    }
                }
            }
            case "white" -> { //same but for white
                if (this.getX() == 1 && this.getX()-x==-2) { //if at the starting position, it can move 2 positions in front
                    if (y == this.getY() && board[x][y] == 0 && board[x-1][y] == 0) return true;
                }
                if ((x == this.getX() + 1 && x >= 0 && x < 8) && (y >= 0 && y < 8)) {
                    if (y == this.getY() && board[x][y] == 0) return true;
                    if ((y == this.getY() - 1 || y == this.getY() + 1) && board[x][y] != 0) {
                        if (board[x][y] >= 1 && board[x][y] <= 6) return true;
                    }
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + color);
        }
        return false;
    }

}
