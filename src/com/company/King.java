package com.company;

import java.util.Scanner;

public class King extends Piece{
    private boolean inCheck;

    public King (String position, boolean isBlack){
        super(position,isBlack);
        symbol = 'k';
        inCheck = false;
    }

    public King (int row, int column, boolean isBlack){
        super(row,column,isBlack);
        symbol = 'k';
        inCheck = false;
    }



    // kings can move in 1 square in any direction
    public boolean isValidMove(String targetPosition) {

        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());

        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);
        // positions can be the same
        if (targetRow == startRow && targetColumn == startColumn){
            return false;
        }

        if (Math.abs(targetRow - startRow) > 1 ){
            return false;
        }
        if (Math.abs(targetColumn - startColumn) > 1 ){
            return false;
        }
        return true;
    }
}
