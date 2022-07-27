package com.example.chess;

public abstract class ChessPiece {
    private int x, y;
    String color;
    int id;
    int takenID;

    public ChessPiece() {
    }

    public ChessPiece(int x, int y, String color, int id) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.id = id;
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

    public void setTakenID(int takenID){this.takenID=takenID;}

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
        if (movePossible(board, x, y)) {
            if (board[x][y] == 0) {
                this.takenID=-1;//no piece is taken
                int temp = board[this.getX()][this.getY()];
                board[this.getX()][this.getY()] = board[x][y];
                board[x][y] = temp;
            } else {
                switch (color) {
                    case "black" -> {
                        if (board[x][y] >= 7 && board[x][y] <= 12) {
                            this.takenID=board[x][y];//get the ID of the piece taken
                            board[x][y] = board[this.getX()][this.getY()];
                            board[this.getX()][this.getY()] = 0;
                        } else {
                            System.out.println("\nFriendly fire!!\n");
                        }
                    }
                    case "white" -> {
                        if (board[x][y] >= 1 && board[x][y] <= 6) {
                            this.takenID=board[x][y];
                            board[x][y] = board[this.getX()][this.getY()];
                            board[this.getX()][this.getY()] = 0;
                        } else {
                            System.out.println("\nFriendly fire!!\n");
                        }

                    }
                    default -> throw new IllegalStateException("Unexpected value: " + color);
                }
            }

            this.setX(x);   //we update the coordinates of the piece
            this.setY(y);

        } else {
            System.out.println("\nMove was not possible!!\n");
        }
    }
};
