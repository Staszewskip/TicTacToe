import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Board board1 = new Board();
        Board[][] board;
        char playerSymbol = 'X';

        board1.showBoard();

        Scanner scan = new Scanner(System.in);

        System.out.println( "Twoj symbol - " + playerSymbol);
        System.out.println("Podaj indeks wiersza (0-2)");
        int line = scan.nextInt();
        System.out.println("Podaj indeks kolumny (0-2)");
        int col = scan.nextInt();

//        board[line][col] = "X";
    }
}
//stworzyć najpierw warstwę graficzną
//można założyć, że użytkownik używa np. krzyżyk, a komputer kółko
//komputer losuje z liczb 0-2 i wstawia kółko pod warunkiem, że jest wolne miejsce