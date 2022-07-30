package model;

public class Queen extends ChessPiece {
    public Queen(int x, int y, String color) {
        this.setX(x);
        this.setY(y);
        this.setColor(color);
        switch (color) {
            case "black" -> {
                this.id = 6;
            }
            case "white" -> {
                this.id = 12;
            }
            default -> System.out.println("Unexpected value: " + color);
        }
    }

    @Override
    public boolean movePossible(int[][] board, int x, int y) { //a queen is basically a rook combined with a bishop
        int i = this.getX(), j = this.getY();
        int diff = Math.abs(this.getX() - x);
        if ((x >= 0 && x < 8) && (y >= 0 && y < 8) && (this.getY() != y || this.getX() != x)) { //in boundaries
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
            boolean ok = true;


            if ((this.getX() == x && (this.getY() == y - 1 || this.getY() == y + 1)) || (this.getY() == y && (this.getX() == x - 1 || this.getX() == x + 1)))
                return true;
            if (this.getX() == x && this.getY() != y) { // move on the x-axis
                if (y < this.getY()) { //go down
                    for (i = this.getY() - 1; i > y; i--) {
                        if (board[x][i] != 0) {
                            ok = false;
                            break;
                        }
                    }
                } else { //go up
                    for (i = this.getY() + 1; i < y; i++) {
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
                    for (i = this.getX() - 1; i > x; i--) {
                        if (board[i][y] != 0) {
                            ok = false;
                            break;
                        }
                    }
                } else { //go right
                    for (i = this.getX() + 1; i < x; i++) {
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
