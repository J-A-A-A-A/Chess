package com.company;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class Piece {
    private int row;
    private int column;
    private boolean isBlack;
    protected char symbol;

    public Piece(int row, int column, boolean isBlack) {
        this.row = row;
        this.column = column;
        this.isBlack = isBlack;
        symbol = 'x';  // dummy symbol - shouldn't ever appear on the board
    }

    public Piece(String position, boolean isBlack) {
        this.isBlack = isBlack;
        symbol = 'x';
        row = ChessUtils.getRowFromPosition(position);
        column = ChessUtils.getColumnFromPosition(position);
    }


    public char getSymbol() {
        if (isBlack) {
            return Character.toUpperCase(symbol);
        }
        return Character.toLowerCase(symbol);
    }

    // convert row and column values to chess Notation eg 0,0 -> A1
    public String getPosition() {
        return ChessUtils.columnToLetter(column) + ChessUtils.rowToNumber(row);
    }

    // set a new position for the piece
    public void setPosition(String newPosition) {
        // add code here
    }

    public boolean isValidMove(String targetPosition) {
        // can't stand still
        if (getPosition().equals(targetPosition)) {
            return false;
        }
        return true;
    }

    // return an empty list by default
    public ArrayList<String> passesThrough(String position) {
        return new ArrayList<>();
    }
}

