package com.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Board {
    char playerSymbol = 'X';


    public void showBoard(char[][] board) {
        System.out.print("\t");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + "|");
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


    public boolean correctMove(char[][] board, int line, int col) throws WrongMoveException {
        boolean correctMove = board[line][col] == 0;
        if (!correctMove)
        {
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


    public boolean checkLines(char[][] board, char currentSymbol, int nbSymbolsToWin) {
        int winningCombination = 0;
        for (int line = 0; line < board.length; line++) {
            for (int col = 0; col < board.length; col++) {
                if (board[line][col] == currentSymbol) {
                    winningCombination++;
                }
                if (winningCombination == nbSymbolsToWin) {
                    return true;
                }
                if (board[line][col] != currentSymbol) {
                    winningCombination = 0;
                }
            }
        }
        return false;
    }

    public boolean checkColumns(char[][] board, char currentSymbol, int nbSymbolsToWin) {
        int winningCombination = 0;
        for (int col = 0; col < board.length; col++) {
            for (int line = 0; line < board.length; line++) {
                if (board[line][col] == currentSymbol) {
                    winningCombination++;
                }
                if (winningCombination == nbSymbolsToWin) {
                    return true;
                }
                if (board[line][col] != currentSymbol) {
                    winningCombination = 0;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonal1(char[][] board, char currentSymbol, int nbOfSymbolsToWin) {
        int winningCombination = 0;

//prawa górna część planszy
        for (int moveOnTheBoard = 0; moveOnTheBoard <= board.length - nbOfSymbolsToWin; moveOnTheBoard++) {
            for (int i = 0; i < board.length; i++) {
                int moveCol = i + moveOnTheBoard;
                if (board[i][moveCol] == currentSymbol) {
                    winningCombination++;
                }
                if (winningCombination == nbOfSymbolsToWin) {
                    return true;
                }
                if (board[i][moveCol] != currentSymbol) {
                    winningCombination = 0;
                }
            }
        }
//        lewa dolna część planszy
        for (int moveOnTheBoard = 0; moveOnTheBoard <= board.length - nbOfSymbolsToWin; moveOnTheBoard++) {
            for (int i = 0; i < board.length; i++) {
                int moveLine = i + moveOnTheBoard;
                if (board[moveLine][i] == currentSymbol) {
                    winningCombination++;
                }
                if (winningCombination == nbOfSymbolsToWin) {
                    return true;
                }
                if (board[moveLine][i] != currentSymbol) {
                    winningCombination = 0;
                }
            }
        }
        return false;
    }


    public boolean checkDiagonal2(char[][] board, char currentSymbol, int nbOfSymbolsToWin) {
        int winningCombination = 0;

//prawa dolna część planszy
        for (int moveOnTheBoard = 0; moveOnTheBoard <= board.length - nbOfSymbolsToWin; moveOnTheBoard++) {
            for (int i = board.length - 1, j = 0; i > 0 || j < board.length - 1; i--, j++) {
                int moveCol = j + moveOnTheBoard;
                if (board[i][moveCol] == currentSymbol) {
                    winningCombination++;
                }
                if (winningCombination == nbOfSymbolsToWin) {
                    return true;
                }
                if (board[i][moveCol] != currentSymbol) {
                    winningCombination = 0;
                }
            }
        }
//        lewa górna część planszy
        for (int moveOnTheBoard = 0; moveOnTheBoard <= board.length - nbOfSymbolsToWin; moveOnTheBoard++) {
            for (int i = board.length - 1, j = 0; i >= 0; i--, j++) {
                int moveLine = i - moveOnTheBoard;
                int moveCol =  moveOnTheBoard - j;
                if (board[moveLine][moveCol] == currentSymbol) {
                    winningCombination++;
                }
                if (winningCombination == nbOfSymbolsToWin) {
                    return true;
                }
                if (board[moveLine][moveCol] != currentSymbol) {
                    winningCombination = 0;
                }
            }
        }
        return false;
    }
}