package com.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ApplicationTestSuite {
    @Test
    void checkLinesO() {
//        given
        Board boardObj = new Board();
        char[][] board = new char [10][10];
        char currentSymbol = 'O';
        char computerSymbol = 'X';
        board[0][0] = computerSymbol;
        board[1][4] = currentSymbol;
        board[1][5] = currentSymbol;
        board[1][6] = currentSymbol;
        board[1][7] = currentSymbol;
        board[1][8] = currentSymbol;
        board[1][9] = computerSymbol;
//        when
        boolean win = boardObj.checkLines(board, currentSymbol,5);
//        then
        Assertions.assertTrue(win);
    }
    @Test
    void checkColumnsO() {
//        given
        Board boardObj = new Board();
        char[][] board = new char [3][3];
        char currentSymbol = 'O';
        int nbOfSymbolsToWin = 3;
        board[0][0] = currentSymbol;
        board[1][0] = currentSymbol;
        board[2][0] = currentSymbol;

//        when
        boolean win = boardObj.checkColumns(board, currentSymbol,nbOfSymbolsToWin);
//        then
        Assertions.assertTrue(win);

    }
    @Test
    void checkDiagonal2WithO(){
//        given
        Board boardObj = new Board();
        char[][] board = new char [10][10];
        char currentSymbol = 'O';
        int nbOfSymbolsToWin = 3;
        board[4][5] = currentSymbol;
        board[3][6] = currentSymbol;
        board[2][7] = currentSymbol;
        board[1][8] = currentSymbol;
        board[0][9] = currentSymbol;
//        when
        boolean win = boardObj.checkDiagonal2(board, currentSymbol,nbOfSymbolsToWin);
//        then
        Assertions.assertTrue(win);

    }

    @Test
    void checkLinesX() {
//        given
        Board boardObj = new Board();
        char[][] board = new char [3][3];
        char currentSymbol = 'X';
        int nbOfSymbolsToWin = 3;
        board[1][0] = currentSymbol;
        board[1][1] = currentSymbol;
        board[1][2] = currentSymbol;

//        when
        boolean win = boardObj.checkLines(board, currentSymbol, nbOfSymbolsToWin);
//        then
        Assertions.assertTrue(win);

    }
    @Test
    void checkColumnsX() {
//        given
        Board boardObj = new Board();
        char[][] board = new char[3][3];
        char currentSymbol = 'X';
        int nbSymbolsToWin = 3;
        board[0][2] = currentSymbol;
        board[1][2] = currentSymbol;
        board[2][2] = currentSymbol;

//        when
        boolean win = boardObj.checkColumns(board, currentSymbol,nbSymbolsToWin);
//        then
        Assertions.assertTrue(win);
    }
    @Test
    void checkDiagonal1withX(){
//        given
        Board boardObj = new Board();
        char[][] board = new char [10][10];
        char currentSymbol = 'X';
        int nbOfSymbolsToWin = 3;
        board[0][1] = currentSymbol;
        board[1][2] = currentSymbol;
        board[2][3] = currentSymbol;
        board[3][4] = currentSymbol;
        board[4][5] = currentSymbol;
//        when
        boolean win = boardObj.checkDiagonal1(board, currentSymbol, nbOfSymbolsToWin);
//        then
        Assertions.assertTrue(win);

    }
    @Test
    void checkDraw(){
//        given
        Board boardObj = new Board();
        char[][] board = new char [3][3];
        char currentSymbolX = 'X';
        char currentSymbolO = 'O';
        int nbOfSymbolsToWin = 3;

        board[0][0] = 'X';
        board[1][1] = 'O';
        board[2][2] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'O';
        board[1][0] = 'O';
        board[1][2] = 'X';
        board[2][0] = 'X';
        board[2][1] = 'O';
//        when
        boolean winLinesX = boardObj.checkLines(board, currentSymbolX, nbOfSymbolsToWin);
        boolean winLinesO = boardObj.checkLines(board, currentSymbolO, nbOfSymbolsToWin);
        boolean winColumnsX = boardObj.checkColumns(board, currentSymbolX,nbOfSymbolsToWin);
        boolean winColumnsO = boardObj.checkColumns(board, currentSymbolO, nbOfSymbolsToWin);
        boolean winDiagonal1X = boardObj.checkDiagonal1(board, currentSymbolX, nbOfSymbolsToWin);
        boolean winDiagonal1O = boardObj.checkDiagonal1(board, currentSymbolO, nbOfSymbolsToWin);
        boolean winDiagonal2X = boardObj.checkDiagonal2(board, currentSymbolX, nbOfSymbolsToWin);
        boolean winDiagonal2O = boardObj.checkDiagonal2(board, currentSymbolO, nbOfSymbolsToWin);
//        then
        Assertions.assertFalse(winLinesX && winLinesO && winColumnsX && winColumnsO && winDiagonal1X & winDiagonal1O && winDiagonal2X && winDiagonal2O);
    }

    @Test
    void checkWrongMoveException()  {
//        given
        Board boardObj = new Board();
        char[][] board = new char [3][3];
        char playerSymbol = 'X';
        int line = 0;
        int col = 0;
        board[line][col] = playerSymbol;
        board[line][col] = playerSymbol;
//        when & then
        Assertions.assertThrows(WrongMoveException.class, () -> boardObj.correctMove(board, line, col) );
    }

}
