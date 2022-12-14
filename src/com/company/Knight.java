package com.company;
import java.util.ArrayList;
public class Knight extends Piece  {
    public Knight(String position, boolean isBlack) {
        super(position, isBlack);
        symbol = 'n';
    }

    // Knights can move in L shapes in any direction
    public boolean isValidMove(String targetPosition) {
        if (super.isValidMove(targetPosition)==false) {
            return false;
        }
        // convert position to row and column
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);

        // either move 2 rows and and 1 column
        // OR 2 columns and 1 row
        int rowDifference = Math.abs(startRow - targetRow);
        int colDifference = Math.abs(startColumn - targetColumn);
        if ((rowDifference == 2 && colDifference == 1) ||
                (rowDifference == 1 && colDifference == 2)) {
            return true;
        }
        // all other moves are illegal
        return false;
    }
}

