import java.util.Scanner;

public class Board {

    public void showBoard(char[][] board) {

        System.out.println("\t0" + " 1" + " 2");
//        zewnętrzna pętla ma licznik wskazujący indeks wiersza, wewnętrzna licznik kolumny
        for (int line = 0; line < board.length; line++) {
            System.out.print(line + ":\t");
            for (int col = 0; col < board[line].length; col++) {
                System.out.print(board[line][col] + "|");
            }
            System.out.println();
        }
    }

    public boolean play(char[][] board, char currentSymbol) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Twoj symbol - " + currentSymbol);
        System.out.println("Podaj indeks wiersza (0-2)");
        int line = scan.nextInt();
        System.out.println("Podaj indeks kolumny (0-2)");
        int col = scan.nextInt();
        boolean correctMove = board[line][col] == 0;
        if (!correctMove) {
            System.out.println("Niepoprawny ruch. Pole zajete");
            return false;
        }
        board[line][col] = currentSymbol;
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
//        po przejściu wewnętrznej pętli (sprawdzającej wiersze) zewnętrzna pętla przejdzie do następnego wiersza
        for (int col = 0; col < board.length; col++) {
            boolean win = true;
//            sprawdzamy czy w kolejnych kolumnach jest znak inny niż obecny symbol.
//            jeżeli tak to przerywamy działanie pętli (break)
            for (int line = 0; line < board.length; line++) {
                if (board[line][line] != currentSymbol) {
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
        for (int i=0, j = 2; i< board.length && j<board.length; i++, j--) {
            if (board[i][j] != currentSymbol){
                return false;
            }
        }
        return true;
    }

}