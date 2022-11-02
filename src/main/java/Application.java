import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Board boardObj = new Board();
//        char[][] board = {{' ', ' ', ' '},
//                {' ', ' ', ' '},
//                {' ', ' ', ' '}};
        char[][] board = new char[3][3];

        char playerSymbol = 'X';
        while (true) {
            boardObj.showBoard(board);
            Scanner scan = new Scanner(System.in);
            System.out.println("Twoj symbol - " + playerSymbol);
            System.out.println("Podaj indeks wiersza (0-2)");
            int line = scan.nextInt();
            System.out.println("Podaj indeks kolumny (0-2)");
            int col = scan.nextInt();
            boolean correctMove = board[line][col] == 0;
            if (!correctMove) {
                System.out.println("Niepoprawny ruch. Pole zajete");
                continue;
            }
            board[line][col] = playerSymbol;
            boardObj.showBoard(board);

//            if (playerSymbol == 'X') {
//                playerSymbol = 'O';
//            } else {
//                playerSymbol = 'X';
//            }
            playerSymbol = playerSymbol == 'X' ? 'O' : 'X';
            }
        }
    }

//stworzyć najpierw warstwę graficzną
//można założyć, że użytkownik używa np. krzyżyk, a komputer kółko
//komputer losuje z liczb 0-2 i wstawia kółko pod warunkiem, że jest wolne miejsce