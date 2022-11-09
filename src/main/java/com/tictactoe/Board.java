package com.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Board {
    char playerSymbol = 'X';
    char computerSymbol = 'O';

    public void showBoard(char[][] board) {
        System.out.print("\t");
        for (int i = 0; i< board.length; i++) {
            System.out.print(i +"|" );
        }
        System.out.println();

        for (int line = 0; line < board.length; line++) {
            System.out.print(line + ":\t");
            for (int col = 0; col < board[line].length; col++) {
                System.out.print(board[line][col] + "|");
            }
            System.out.println();
        }
    }

    public boolean play(char[][] board, char currentSymbol) throws WrongMoveException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Twoj symbol " + currentSymbol);
        System.out.println("Podaj indeks wiersza");
        int line = scan.nextInt();
        System.out.println("Podaj indeks kolumny");
        int col = scan.nextInt();

        boolean correctMove = board[line][col] == 0;
        if (!correctMove) {
            throw new WrongMoveException();
        }
        board[line][col] = playerSymbol;
        return true;
    }
    public boolean playComputer(char[][] board, char computerSymbol, int size) {
        Random random = new Random();
        int line = random.nextInt(size);
        int col = random.nextInt(size);
        boolean correctMove = board[line][col] == 0;
        if (!correctMove) {
            return false;
        }
        board[line][col] = computerSymbol;
        return true;
    }

    public boolean checkLines(char[][] board, char currentSymbol) {
//        po przejściu wewnętrznej pętli (sprawdzającej kolumny) zewnętrzna pętla przejdzie do następnego wiersza
        for (int line = 0; line < board.length; line++) {
            boolean win = true;
//            sprawdzamy czy w kolejnych kolumnach jest znak inny niż obecny symbol.
//            jeżeli tak to przerywamy działanie pętli (break)
            for (int col = 0; col < board.length; col++) {
                if (board[line][col] != currentSymbol) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
//        jeżeli metoda nie przerwała działania przez cały czas iteracji pętli to znaczy, że nie ma zwycięskiej kombinacji
        return false;
    }
    public boolean checkColumns(char[][] board, char currentSymbol) {

        for (int col = 0; col < board.length; col++) {
            boolean win = true;
//            sprawdzamy czy w kolejnych kolumnach jest znak inny niż obecny symbol.
//            jeżeli tak to przerywamy działanie pętli (break)
            for (int line = 0; line < board.length; line++) {
                if (board[line][col] != currentSymbol) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
//        jeżeli metoda nie przerwała działania przez cały czas iteracji pętli to znaczy, że nie ma zwycięskiej kombinacji
        return false;
    }
    public boolean checkDiagonal1(char[][] board, char currentSymbol){
        for (int i=0; i< board.length; i++) {
            if (board[i][i] != currentSymbol){
            return false;
            }
        }
        return true;
    }
    public boolean checkDiagonal2(char[][] board, char currentSymbol){
        for (int i=2, j = 0; j<board.length; i--, j++) {
            if (board[i][j] != currentSymbol){
                return false;
            }
        }
        return true;
    }

    public static class WrongMoveException extends Exception{
    }

    public static class ExceptionRunner {
        public boolean play(char[][] board, char currentSymbol) {
            Board boardObj = new Board();

            try {
                boardObj.play(board, currentSymbol);
            } catch (WrongMoveException e) {
                System.out.println("Niepoprawny ruch. Sprobuj ponownie");
                return false;
            }
            return true;
        }
    }
}