package com.company;

import java.util.Scanner;

public class Chess {
    private Piece[][] board;

    // set up the board for the start of the game
    public Chess() {
        board = new Piece[8][8];
        // create the pieces
        for (int c=0; c<8; c++){
            board[1][c] = new Piece(1,c,false);
            board[6][c] = new Piece(6,c,true);
        }
        board[0][4] = new King(0,4,false);
    }

    //print the current board layout
    public void display(){
        for (int r=0; r<8; r++){
            for (int c=0; c<8 ;c++){
                if (board[r][c] != null) {
                    System.out.print(board[r][c].getSymbol() + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    //take s chess cords e.g. AB and returns the piece at that loc or null
    public Piece getPieceAt(String position){
        int row = ChessUtils.getRowFromPosition(position);
        int column = ChessUtils.getColumnFromPosition(position);
        return board[row][column];
    }

    // take input from the user for a chess move and validate
    public void move(){
        Scanner input = new Scanner(System.in);
        boolean validMove = false;

        System.out.print("Enter the piece to move: ");
        String startPosition = input.nextLine();

        System.out.print("Enter the square to move to: ");
        String endPosition = input.nextLine();

        Piece toMove = getPieceAt(startPosition);
        if(toMove != null){
            validMove = toMove.isValidMove(endPosition);
        }
        if (validMove) {
            System.out.println(toMove.getSymbol() + " moves to " + endPosition);
            int startRow = ChessUtils.getRowFromPosition(startPosition);
            int startColumn = ChessUtils.getColumnFromPosition(startPosition);

            int targetRow = ChessUtils.getRowFromPosition(endPosition);
            int targetColumn = ChessUtils.getColumnFromPosition(endPosition);
            // updating the board
            board[targetRow][targetColumn] = board[startRow][startColumn];
            board[startRow][startColumn] = null;
            toMove.setPosition(endPosition);

        } else {
            System.out.println("You can't do that!");
        }
    }
}
