package new_game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Human player = new Human("tic");
        Human player2 = new Human("tac");
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Step> steps = new ArrayList<>();

        System.out.println("Укажите размер доски: ");
        int size = scanner.nextInt();
        System.out.println("Размер доски = " + size + "x" + size);
        board.createBoard(size);
        int[][] newGame = board.getField();
        int i = 0;

        while (board.winnerCheck().equalsIgnoreCase("nobody") && i < newGame.length * newGame.length ) {
            if (board.playerCheck().equalsIgnoreCase(player.getName())) {
                System.out.println("Ходит игрок " + player.getName() + " Введите столбец: ");
                progress(player, board, scanner, newGame, steps);
            } else {
                System.out.println("Теперь Ходит игрок " + player2.getName() + " Введите столбец: ");
                progress(player2, board, scanner, newGame, steps);
            }
            i++;
        }
        for (Step step : steps){
            System.out.println(step.getColumn() + " " + step.getRow() + " " + step.getPlayer() + " Очередь хода " +
                    step.getOrderOfStep());
        }


    }

    private static void progress(Human player, Board board, Scanner scanner, int[][] newGame, ArrayList<Step> steps) {

        int column = scanner.nextInt();
        System.out.println("Введите строку:");
        int row = scanner.nextInt();
        if (player.isPossibleStep(column, row)) {
            newGame[column - 1][row - 1] = player.step(player.getName(), column - 1, row - 1);
            steps.add(new Step( column,row, player.getName()));
            board.print();
            board.winnerCheck();
        } else {
            for (int i = 0; ; i++) {
                System.out.println("Укажите заново столбец и строку: ");
                column = scanner.nextInt();
                row = scanner.nextInt();
                if (player.isPossibleStep(column, row)) {
                    newGame[column - 1][row - 1] = player.step(player.getName(), column - 1, row - 1);
                    steps.add(new Step(column,row, player.getName()));
                    board.print();
                    board.winnerCheck();
                    break;
                }
            }
        }
    }
}

