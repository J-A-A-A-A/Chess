package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Chess {
    private Piece[][] board;

    // set up the board for the start of the game
    public Chess() {
        board = new Piece[8][8];
        // create the 'pawns'
        for (int c=0; c<8; c++) {
            board[1][c] = new Piece(1, c, false);
            board[6][c] = new Piece(6, c, true);
        }
        board[0][4] = new King("E1",false);
        board[7][4] = new King("E8",true);
        board[0][1] = new Knight("B1",false);
        board[0][6] = new Knight("G1",false);
        board[7][1] = new Knight("B8",true);
        board[7][6] = new Knight("G8",true);
        board[0][0] = new Rook("A1",false);
        board[0][7] = new Rook("H1",false);
        board[7][0] = new Rook("A8",true);
        board[7][7] = new Rook("H8",true);
    }

    // print the current board layout
    public void display() {
        System.out.println("   A B C D E F G H");
        for (int r=0; r<8; r++) {
            System.out.print(r+1 + "  ");
            for (int c=0; c<8; c++) {
                if (board[r][c] != null) {
                    System.out.print(board[r][c].getSymbol() + " ");
                } else {
                    System.out.print("  ");  // blank square
                }
            }
            System.out.println();  // start a new row
        }
    }

    // takes chess coords eg A8 and returns the piece at that loc or null
    public Piece getPieceAt(String position) {
        int row = ChessUtils.getRowFromPosition(position);
        int column = ChessUtils.getColumnFromPosition(position);
        return board[row][column];
    }

    // take input from the user for a chess move and validate
    public void move() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the piece to move:");
        String startPosition = input.nextLine();
        System.out.print("Enter the square to move to:");
        String endPosition = input.nextLine();
        Piece toMove = getPieceAt(startPosition);
        boolean validMove = false;
        if (toMove != null) {
            validMove = toMove.isValidMove(endPosition);
        }
        if (validMove) {
            System.out.print(toMove.getSymbol() + " moves to " + endPosition);
            // check there are no pieces along the route
            ArrayList<String> squares = toMove.passesThrough(endPosition);
            if (squares.size()>0) {
                System.out.print(" passing through ");
                for (String p : squares) {
                    System.out.print(p + ", ");
                }
            }
            System.out.println();
            //if (getPieceAt(endPosition).getSymbol() == getPieceAt(startPosition).getSymbol())
            // convert position to row and column
            int startRow = ChessUtils.getRowFromPosition(startPosition);
            int startColumn = ChessUtils.getColumnFromPosition(startPosition);
            int targetRow = ChessUtils.getRowFromPosition(endPosition);
            int targetColumn = ChessUtils.getColumnFromPosition(endPosition);
            // actually update the board
            board[targetRow][targetColumn] = board[startRow][startColumn];
            board[startRow][startColumn] = null;
        } else {
            System.out.println("You can't do that!");
        }
    }
}

