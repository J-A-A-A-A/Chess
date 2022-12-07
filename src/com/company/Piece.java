package com.company;

import javax.print.DocFlavor;

public class Piece {
    private int row;
    private int column;
    private boolean isBlack;
    protected char symbol;

    public Piece(int row, int column, boolean isBlack) {
        this.row = row;
        this.column = column;
        this.isBlack = isBlack;
        symbol = 'x'; // dummy symbol shouldn't be on the board
    }

    public Piece(String position, boolean isBlack){
        this.isBlack = isBlack;
        symbol = 'x';
        row = ChessUtils.getRowFromPosition(position);
        column = ChessUtils.getColumnFromPosition(position);
    }

    public char getSymbol(){
        if (isBlack){
            return Character.toUpperCase(symbol);
        } else {
            return Character.toLowerCase(symbol);
        }
    }

    // convert row and column value to chess notation e.g 0,0 -> "A1"
    public String getPosition() {
        return ChessUtils.columnToLetter(column) + ChessUtils.rowToNumber(row);
    }

    // set a new position for the piece
    public void setPosition(String newPosition){
        row = ChessUtils.getRowFromPosition(newPosition);
        column = ChessUtils.getColumnFromPosition(newPosition);

    }
    public boolean isValidMove(String TargetPosition){
        return true;
    }
}
