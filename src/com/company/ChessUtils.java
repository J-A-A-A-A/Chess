package com.company;

public class ChessUtils {

    // e.g. for a position A8 return row number 7
    public static int getRowFromPosition(String p){
        char posChar = p.toCharArray()[1]; // "A8" -> '8'
        int rowNumber = Character.getNumericValue(posChar); // '8' -> 8
        return rowNumber - 1;
    }

    // e.g. for a position A8 return row number 0
    public static int getColumnFromPosition(String p){
        char posChar = p.toCharArray()[0]; // "A8" -> 'A'
        int asciiValue = posChar;
        int colNumber = asciiValue - (int)'A'; // '8' -> 0
        return colNumber;
    }

    // e.g. 0->A 1->B etc
    public static String columnToLetter(int c){
        char letter = (char)('A' + c);
        return Character.toString(letter);
    }

    // e.g. 0 -> "1"  1 -> "2"
    public static String rowToNumber(int r){
        return Integer.toString(r+1);
    }

}
