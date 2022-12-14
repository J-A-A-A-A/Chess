package com.company;
import java.util.ArrayList;
public class Rook extends Piece{

    private boolean hasCastled;

    public Rook(String position, boolean isBlack) {
        super(position, isBlack);
        symbol = 'r';
    }

    // Rooks can move horizontally or vertically arbitrarily far
    public boolean isValidMove(String targetPosition) {
        if (super.isValidMove(targetPosition) == false) {
            return false;
        }
        // convert position to row and column
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);

        // have we moved horizontally or vertically?
        if ((startRow == targetRow) || (startColumn == targetColumn)) {
            return true;
        }
        // all other moves are illegal
        return false;
    }

    // return a list of all positions the piece moves through
    // excluding the start and end
    public ArrayList<String> passesThrough(String targetPosition) {
        // convert position to row and column
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);

        ArrayList<String> squares = new ArrayList<>();
        // add all squares along the route, including the start square for now
        if (isValidMove(targetPosition)) {
            int row = startRow;
            do {
                int col = startColumn;
                do {
                    squares.add(ChessUtils.getPositionFromCoords(row, col));
                    col++;
                } while(col<targetColumn);
                row++;
            } while(row<targetRow);
        }
        // remove the first square added, since we want to exclude the start square
        squares.remove(0);
        return squares;
    }
}

