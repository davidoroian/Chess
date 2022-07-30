package model;

public class Rook extends ChessPiece {
    public Rook(int x, int y, String color) {
        this.setX(x);
        this.setY(y);
        this.setColor(color);
        switch (color) {
            case "black" -> {
                this.id = 2;
            }
            case "white" -> {
                this.id = 8;
            }
            default -> System.out.println("Unexpected value: " + color);
        }
    }

    @Override
    public boolean movePossible(int[][] board, int x, int y) {
        boolean ok = true;

        if ((x >= 0 && x < 8) && (y >= 0 && y < 8) && (this.getY() != y || this.getX() != x)) { //in boundaries
            if ((this.getX() == x && (this.getY() == y - 1 || this.getY() == y + 1)) || (this.getY() == y && (this.getX() == x - 1 || this.getX() == x + 1)))
                return true;
            if (this.getX() == x && this.getY() != y) { // move on the x-axis
                if (y < this.getY()) { //go down
                    for (int i = this.getY() - 1; i > y; i--) {
                        if (board[x][i] != 0) {
                            ok = false;
                            break;
                        }
                    }
                } else { //go up
                    for (int i = this.getY() + 1; i < y; i++) {
                        if (board[x][i] != 0) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok) return true;
            }
            if (this.getX() != x && this.getY() == y) { // move on the y-axis
                if (x < this.getX()) { //go left
                    for (int i = this.getX() - 1; i > x; i--) {
                        if (board[i][y] != 0) {
                            ok = false;
                            break;
                        }
                    }
                } else { //go right
                    for (int i = this.getX() + 1; i < x; i++) {
                        if (board[i][y] != 0) {
                            ok = false;
                            break;
                        }
                    }
                }
                return ok;
            }
        }
        return false;
    }
}
