package com.tictactoe;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Board boardObj = new Board();
        int size = 0;
        int nbOfSymbolsToWin = 0;
        char currentSymbol = 'X';
        boolean ifContinue = true;
        boolean correctPlayerMove = false;
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

        while (ifContinue) {
            boardObj.showBoard(board);

            if (currentSymbol == 'X') {
                System.out.println("Twoj symbol " + currentSymbol);
                boardObj.showBoard(board);
                Scanner scanner = new Scanner(System.in);
                System.out.println("Podaj indeks wiersza");
                int line = scanner.nextInt();
                System.out.println("Podaj indeks kolumny");
                int col = scanner.nextInt();

                try {
                    correctPlayerMove = boardObj.correctMove(board, line, col);

                } catch (WrongMoveException e) {
                    System.out.println("Niepoprawny ruch. Sprobuj ponownie");
                }
            }
            boolean correctComputerMove = false;
            if (currentSymbol == 'O') {
                correctComputerMove = boardObj.playComputer(board, currentSymbol, size);
            }

            if (correctPlayerMove || correctComputerMove) {
                boolean winLines = boardObj.checkLines(board, currentSymbol, nbOfSymbolsToWin);
                boolean winColumns = boardObj.checkColumns(board, currentSymbol, nbOfSymbolsToWin);
                boolean winDiagonal1 = boardObj.checkDiagonal1(board, currentSymbol, nbOfSymbolsToWin);
                boolean winDiagonal2 = boardObj.checkDiagonal2(board, currentSymbol, nbOfSymbolsToWin);

                if (currentSymbol == 'X' && (winLines || winColumns || winDiagonal1 || winDiagonal2)) {
                    boardObj.showBoard(board);
                    System.out.println("Gratulacje. Wygrales");
                    ifContinue = false;
                } else if ((currentSymbol == 'O' && (winLines || winColumns || winDiagonal1 || winDiagonal2))) {
                    boardObj.showBoard(board);
                    System.out.println("Przegrales gre");
                    ifContinue = false;
                } else {
                    boardObj.showBoard(board);
                    System.out.println("Remis");
                    ifContinue = false;
                }
            }
            currentSymbol = currentSymbol == 'X' ? 'O' : 'X';
        }
    }
}

