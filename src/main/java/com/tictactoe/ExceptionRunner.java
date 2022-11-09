package com.tictactoe;

public class ExceptionRunner {
    public boolean play(char[][] board,char playerSymbol)  {
        Board boardObj = new Board();
        try {
            boardObj.play(board, playerSymbol);
        } catch (Board.WrongMoveException e) {
            System.out.println("Niepoprawny ruch. Sprobuj ponownie");
            return false;
        }
        return true;
    }
}
