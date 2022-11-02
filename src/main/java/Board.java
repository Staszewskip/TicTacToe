public class Board {
    public void showBoard(){


//tablica dwuwymiarowa
        char[][] board = {{' ', ' ', ' '},
                         {' ', ' ', ' '},
                         {' ', ' ', ' '}};

//        board[0][0] = 'X';
//        board[1][1] = 'X';
//        board[2][2] = 'X';

        System.out.println("\t0"+ " 1"+" 2");

//        zewnętrzna pętla ma licznik wskazujący indeks wiersza, wewnętrzna licznik kolumny
        for (int line = 0; line < board.length; line++) {
            System.out.print(line + ":\t");
            for (int col = 0; col < board[line].length; col++) {
                System.out.print(board[line][col] + "|");
            }
            System.out.println();
        }
    }
}
