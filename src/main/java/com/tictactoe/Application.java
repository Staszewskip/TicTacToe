package com.tictactoe;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Board.WrongMoveException {
        Board boardObj = new Board();
        int size = 0;
        int nbOfSymbolsToWin = 0;
        char currentSymbol = 'X';
        boolean ifContinue = true;
        int counterMove = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                    Jaki rozmiar planszy chcesz wybrac?\s
                    1 - 3x3 \s
                    2 - 10x10\s
                    """);
        int choice = scan.nextInt();
        if (choice == 1) {
            size = 3;
            nbOfSymbolsToWin = 3;
        } else if (choice == 2) {
            size = 10;
            nbOfSymbolsToWin = 5;
        }
        char[][] board = new char[size][size];

        while (ifContinue && counterMove <=9) {
            counterMove++;
            boardObj.showBoard(board);
            boolean correctPlayerMove = false;
            if (currentSymbol == 'X') {
                correctPlayerMove = boardObj.play(board, currentSymbol);
            }
            boolean correctComputerMove = false;
            if (currentSymbol == 'O') {
                correctComputerMove = boardObj.playComputer(board, currentSymbol, size);
            }

            if (correctPlayerMove || correctComputerMove) {
                boolean winLines = boardObj.checkLines(board, currentSymbol, nbOfSymbolsToWin);
                boolean winColumns = boardObj.checkColumns(board, currentSymbol);
                boolean winDiagonal1 = boardObj.checkDiagonal1(board, currentSymbol);
                boolean winDiagonal2 = boardObj.checkDiagonal2(board, currentSymbol);

                if (currentSymbol == 'X' && (winLines || winColumns || winDiagonal1 || winDiagonal2)) {
                    System.out.println("Gratulacje. Wygrales");
                    ifContinue = false;
                } else if ((currentSymbol == 'O' && (winLines || winColumns || winDiagonal1 || winDiagonal2))) {
                    System.out.println("Przegrales gre");
                    ifContinue = false;
                } else {
                    System.out.println("Remis");
                }
            }
            currentSymbol = currentSymbol == 'X' ? 'O' : 'X';
            }
        }
    }

