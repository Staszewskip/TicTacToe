import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Board boardObj = new Board();
//        char[][] board = {{' ', ' ', ' '},
//                {' ', ' ', ' '},
//                {' ', ' ', ' '}};
        char[][] board = new char[3][3];
        char currentSymbol = 'X';
        boolean ifContinue = true;
        int moveCounter = 0;
        while (ifContinue && moveCounter <= 9) {
            boardObj.showBoard(board);
            boolean correctMove = boardObj.play(board, currentSymbol);
            if (correctMove) {
                moveCounter++;
                boolean winLines = boardObj.checkLines(board, currentSymbol);
                boolean winColumns = boardObj.checkColumns(board, currentSymbol);
                boolean winDiagonal1 = boardObj.checkDiagonal1(board, currentSymbol);
                boolean winDiagonal2 = boardObj.checkDiagonal2(board, currentSymbol);
                if (winLines || winColumns || winDiagonal1 || winDiagonal2) {
                    System.out.println("Gratulacje, wygrales!");
                    ifContinue = false;
                }

                currentSymbol = currentSymbol == 'X' ? 'O' : 'X';
            }
        }
    }
}
