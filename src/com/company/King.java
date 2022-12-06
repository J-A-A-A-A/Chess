package com.company;

import java.util.Scanner;

public class King extends Piece{
    private boolean inCheck;

    public King (String position, boolean isBlack){
        super(position,isBlack);
        symbol = 'k';
        inCheck = false;
    }

    // kings can move in 1 square in any direction
    public boolean isValidMove(String targetPosition) {
        int row = ChessUtils.getRowFromPosition(targetPosition);
        int column = ChessUtils.getColumnFromPosition(targetPosition);
    }
}
