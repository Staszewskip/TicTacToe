package com.tictactoe;

public class ExceptionRunner {
    public boolean play(char[][] board, char currentSymbol)  {
        Board boardObj = new Board();
        char computerSymbol = 'O';
//        char[][] board = new char [3][3];
        int size = 3;
        try {
            boardObj.playComputer(board, computerSymbol,size);
        } catch (WrongMoveException e) {
            System.out.println("Niepoprawny ruch. Sprobuj ponownie");
            return false;
        }
        return true;
    }

}
