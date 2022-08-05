package model;

public abstract class ChessPiece {
    private int x, y;
    String color;
    int id;
    int takenID;
    boolean hasMoved;


    public ChessPiece() {
    }

    public int getX() {
        return x;
    }

    public int getId() {
        return id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getTakenID(){return takenID;}

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract boolean movePossible(int[][] board, int x, int y);

    public void move(int[][] board, int x, int y) {
        hasMoved=false;
        if (movePossible(board, x, y)) {
            if (board[x][y] == 0) {
                this.takenID=0;//no piece is taken
                int temp = board[this.getX()][this.getY()];
                board[this.getX()][this.getY()] = board[x][y];
                board[x][y] = temp;
                this.setX(x);
                this.setY(y);
                hasMoved=true;
            } else {
                switch (color) {
                    case "black" -> {
                        if (board[x][y] >= 7 && board[x][y] <= 12) {
                            this.takenID=board[x][y];//get the ID of the piece taken
                            board[x][y] = board[this.getX()][this.getY()];
                            board[this.getX()][this.getY()] = 0;
                            this.setX(x);
                            this.setY(y);
                            hasMoved=true;
                        } else {
                            System.out.println("\nFriendly fire!!\n");
                        }
                    }
                    case "white" -> {
                        if (board[x][y] >= 1 && board[x][y] <= 6) {
                            this.takenID=board[x][y];
                            board[x][y] = board[this.getX()][this.getY()];
                            board[this.getX()][this.getY()] = 0;
                            this.setX(x);
                            this.setY(y);
                            hasMoved=true;
                        } else {
                            System.out.println("\nFriendly fire!!\n");
                        }

                    }
                    default -> throw new IllegalStateException("Unexpected value: " + color);
                }
            }
        }
    }
};
