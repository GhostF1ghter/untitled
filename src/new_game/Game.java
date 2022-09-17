package new_game;


import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Human player = new Human("tic");
        Human player2 = new Human("tac");
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите размер доски: ");
        int size = scanner.nextInt();
        System.out.println("Размер доски = " + size + "x" + size);
        board.createBoard(size);
        int[][] newGame = board.getField();

        while (board.winnerCheck().equalsIgnoreCase("nobody")) {
            if (board.playerCheck().equalsIgnoreCase(player.getName())) {
                System.out.println("Ходит игрок " + player.getName() + " Введите столбец: ");
                progress(player, board, scanner, newGame);
            } else {
                System.out.println("Теперь Ходит игрок " + player2.getName() + " Введите столбец: ");
                progress(player2, board, scanner, newGame);
            }

        }


    }

    private static void progress(Human player, Board board, Scanner scanner, int[][] newGame) {
        int column = scanner.nextInt();
        System.out.println("Введите строку:");
        int row = scanner.nextInt();
        if (player.isPossibleStep(column, row)) {
            newGame[column - 1][row - 1] = player.step(player.getName(), column - 1, row - 1);
            board.print();
            board.winnerCheck();

        } else {
            for (int i = 0; ; i++) {
                System.out.println("Укажите заново столбец и строку: ");
                column = scanner.nextInt();
                row = scanner.nextInt();
                if (player.isPossibleStep(column, row)) {
                    newGame[column - 1][row - 1] = player.step(player.getName(), column - 1, row - 1);
                    board.print();
                    board.winnerCheck();
                    break;
                }
            }
        }
    }
}

