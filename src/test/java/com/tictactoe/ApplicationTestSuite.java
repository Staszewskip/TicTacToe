package com.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ApplicationTestSuite {
    @Test
    void checkLinesO() {
//        given
        Board boardObj = new Board();
        char[][] board = new char [3][3];
        char currentSymbol = 'O';
        board[0][0] = currentSymbol;
        board[0][1] = currentSymbol;
        board[0][2] = currentSymbol;

//        when
        boolean win = boardObj.checkLines(board, currentSymbol);
//        then
        Assertions.assertTrue(win);

    }
    @Test
    void checkColumnsO() {
//        given
        Board boardObj = new Board();
        char[][] board = new char [3][3];
        char currentSymbol = 'O';
        board[0][0] = currentSymbol;
        board[1][0] = currentSymbol;
        board[2][0] = currentSymbol;

//        when
        boolean win = boardObj.checkColumns(board, currentSymbol);
//        then
        Assertions.assertTrue(win);

    }
    @Test
    void checkDiagonal2WithO(){
//        given
        Board boardObj = new Board();
        char[][] board = new char [3][3];
        char currentSymbol = 'O';
        board[0][2] = currentSymbol;
        board[1][1] = currentSymbol;
        board[2][0] = currentSymbol;
//        when
        boolean win = boardObj.checkDiagonal2(board, currentSymbol);
//        then
        Assertions.assertTrue(win);

    }

    @Test
    void checkLinesX() {
//        given
        Board boardObj = new Board();
        char[][] board = new char [3][3];
        char currentSymbol = 'X';
        board[1][0] = currentSymbol;
        board[1][1] = currentSymbol;
        board[1][2] = currentSymbol;

//        when
        boolean win = boardObj.checkLines(board, currentSymbol);
//        then
        Assertions.assertTrue(win);

    }
    @Test
    void checkColumnsX() {
//        given
        Board boardObj = new Board();
        char[][] board = new char[3][3];
        char currentSymbol = 'X';
        board[0][2] = currentSymbol;
        board[1][2] = currentSymbol;
        board[2][2] = currentSymbol;

//        when
        boolean win = boardObj.checkColumns(board, currentSymbol);
//        then
        Assertions.assertTrue(win);
    }
    @Test
    void checkDiagonal1withX(){
//        given
        Board boardObj = new Board();
        char[][] board = new char [3][3];
        char currentSymbol = 'X';
        board[0][0] = currentSymbol;
        board[1][1] = currentSymbol;
        board[2][2] = currentSymbol;
//        when
        boolean win = boardObj.checkDiagonal1(board, currentSymbol);
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
        boolean winLinesX = boardObj.checkLines(board, currentSymbolX);
        boolean winLinesO = boardObj.checkLines(board, currentSymbolO);
        boolean winColumnsX = boardObj.checkColumns(board, currentSymbolX);
        boolean winColumnsO = boardObj.checkColumns(board, currentSymbolO);
        boolean winDiagonal1X = boardObj.checkDiagonal1(board, currentSymbolX);
        boolean winDiagonal1O = boardObj.checkDiagonal1(board, currentSymbolO);
        boolean winDiagonal2X = boardObj.checkDiagonal2(board, currentSymbolX);
        boolean winDiagonal2O = boardObj.checkDiagonal2(board, currentSymbolO);
//        then
        Assertions.assertFalse(winLinesX && winLinesO && winColumnsX && winColumnsO && winDiagonal1X & winDiagonal1O && winDiagonal2X && winDiagonal2O);
    }

    @Test
    void checkWrongMoveException() throws Board.WrongMoveException {
//        given
        Board boardObj = new Board();
        char[][] board = new char [3][3];
        char computerSymbol = 'X';
        board[0][0] = computerSymbol;
        board[0][0] = computerSymbol;;
//        when
        boardObj.playComputer(board,computerSymbol,3);
//        then
        Assertions.assertThrows(Board.WrongMoveException.class, () -> boardObj.playComputer(board, computerSymbol,3) );
    }

}
