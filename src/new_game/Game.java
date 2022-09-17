package new_game;


import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Играем с ботом?");
        String yesOrNo = scanner.next();
        ArrayList<Step> steps = new ArrayList<Step>();
        Board board = new Board();
        System.out.println("Укажите размер доски: ");
        int size = scanner.nextInt();
        board.createBoard(size);
        System.out.println("Размер доски = " + size + "x" + size);
        int i = 0;

        int[][] newGame = board.getField();
        if (yesOrNo.equalsIgnoreCase("Да")) {
            Bot player1 = new Bot("tic");
            Human player2 = new Human("tac");
//            if ((Math.random() * 10) < 5) {
                while (board.winnerCheck().equalsIgnoreCase("nobody") && i < newGame.length * newGame.length){
                    if (board.playerCheck().equalsIgnoreCase(player1.getName())) {
                        System.out.println("Ходит игрок " + player1.getName() + " Введите столбец: ");
                    }
                    player1.position();
                    board.print();
                    board.winnerCheck();
                    System.out.println("Ходите вы. Укажите столбец: ");
                    int column = scanner.nextInt();
                    System.out.println("Укажите строку: ");
                    int row = scanner.nextInt();
                    newGame[column - 1][row - 1] = player2.step(player2.getName(), column - 1, row - 1);
                    board.print();
                    board.winnerCheck();
                    i++;
                }
//            }
        } else {
            Human player = new Human("tic");
            Human player2 = new Human("tac");
            while (board.winnerCheck().equalsIgnoreCase("nobody") && i < newGame.length * newGame.length) {
                if (board.playerCheck().equalsIgnoreCase(player.getName())) {
                    System.out.println("Ходит игрок " + player.getName() + " Введите столбец: ");
                    progress(player, board, scanner, newGame, steps);
                } else {
                    System.out.println("Теперь Ходит игрок " + player2.getName() + " Введите столбец: ");
                    progress(player2, board, scanner, newGame, steps);
                }
                i++;
            }
            for (Step step : steps) {
                System.out.println(step.getColumn() + " " + step.getRow() + " " + step.getPlayer() + " Очередь хода " +
                        step.getOrderOfStep());
            }
        }
    }

    private static void progress(Human player, Board board, Scanner scanner, int[][] newGame, ArrayList<Step> steps) {

        int column = scanner.nextInt();
        System.out.println("Введите строку:");
        int row = scanner.nextInt();
        if (player.isPossibleStep(column, row)) {
            newGame[column - 1][row - 1] = player.step(player.getName(), column - 1, row - 1);
            steps.add(new Step(column, row, player.getName()));
            board.print();
            board.winnerCheck();
        } else {
            for (int i = 0; ; i++) {
                System.out.println("Укажите заново столбец и строку: ");
                column = scanner.nextInt();
                row = scanner.nextInt();
                if (player.isPossibleStep(column, row)) {
                    newGame[column - 1][row - 1] = player.step(player.getName(), column - 1, row - 1);
                    steps.add(new Step(column, row, player.getName()));
                    board.print();
                    board.winnerCheck();
                    break;
                }
            }
        }
    }
}

