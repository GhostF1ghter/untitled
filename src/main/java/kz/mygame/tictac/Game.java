package kz.mygame.tictac;

import kz.mygame.tictac.new_game.*;
import kz.mygame.tictac.players.Bot;
import kz.mygame.tictac.players.Human;
import kz.mygame.tictac.players.Player;
import kz.mygame.tictac.saves.*;

import java.util.ArrayList;
import java.util.Scanner;

/*
1) почитай как располагать файлы по папкам. ?вроде сделал
2) как называть файлы разных типов (интерфейсы, сервисы классы И так далее) ?вроде сделал
3) Player какой-то старнный класс. если инт тик = 1, есть так = 2, можно же инт я хз тип который будет 1 или 2. +
4) у Human метод isPossibleStep, он же и боту и человеку нужен, тогда в общий надо его вынести для player(тебе для этого плеер и создан) +
5) isPossibleStep создает новую доску. дичь какая-то) надо без создания  +
6) вообще везде не надо создавать новые борды)) по идее даже isPossibleStep это метод борда а не игроков  +
7)у меня есть подозрение что и степ надо в доску выводить, но это не точно
8) progress очень сложный метод. надо надробить на более мелкие
9) добавь историю шагов) ты ж зачем то делал шаги
10) добавить спринг в проект

11) перетащить все методы из main в restController'ы и будешь вызывать по ресту их
12) добавить сохранение игр и шагов в бд автоматом
13) добавить возможность продолжения игры если имена совпали
14) добавить рейтинг игроков (имена будут не только tic tac)
Перед 10 пунктом скинь ещё раз

 Перенести методы playerCheck winnerCheck
 Добавить в параметр Step
 */
public class Game {




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Играем с ботом?");
        String yesOrNo = scanner.next();

        if (yesOrNo.equalsIgnoreCase("Да")) {
            botToHuman(scanner);

        } else {
            humanToHuman(scanner);
        }

    }

    private static void humanToHuman(Scanner scanner) {
        Human player1 = new Human("tic");
        Human player2 = new Human("tac");
        ArrayList<Step> steps = new ArrayList<Step>();
        Board board = new Board();
        System.out.println("Укажите размер доски: ");
        int size = scanner.nextInt();
        board.createBoard(size);
        System.out.println("Размер доски = " + size + "x" + size);
        int[][] newGame = board.getField();
        int i = 0;
        while (board.winnerCheck().equalsIgnoreCase("nobody") && i < newGame.length * newGame.length) {
            if (board.playerCheck().equalsIgnoreCase(player1.getName())) {
                System.out.println("Ходит игрок " + player1.getName() + " Введите столбец: ");
                int column = scanner.nextInt();
                System.out.println("Введите строку:");
                int row = scanner.nextInt();
                if (board.isPossibleStep(column, row)) {
                    newGame[column - 1][row - 1] = player1.step(player1.getName(), column - 1, row - 1,board);
                    steps.add(new Step(column, row, player1.getName()));
                    board.print();
                    if (board.winnerCheck().equalsIgnoreCase("tic") || board.winnerCheck().equalsIgnoreCase("tac")){
                        break;
                    }
                } else {
                    for (int j = 0; ; i++) {
                        System.out.println("Укажите заново столбец и строку: ");
                        column = scanner.nextInt();
                        row = scanner.nextInt();
                        if (board.isPossibleStep(column, row)) {
                            newGame[column - 1][row - 1] = player1.step(player1.getName(), column - 1, row - 1,board);
                            steps.add(new Step(column, row, player1.getName()));
                            board.print();
                            if (board.winnerCheck().equalsIgnoreCase("tic") || board.winnerCheck().equalsIgnoreCase("tac")){
                                break;
                            }
                            break;
                        }
                    }
                }

            } else {
                System.out.println("Теперь Ходит игрок " + player2.getName() + " Введите столбец: ");
                int column = scanner.nextInt();
                System.out.println("Введите строку:");
                int row = scanner.nextInt();
                if (board.isPossibleStep(column, row)) {
                    newGame[column - 1][row - 1] = player2.step(player2.getName(), column - 1, row - 1,board);
                    steps.add(new Step(column, row, player2.getName()));
                    board.print();
                    if (board.winnerCheck().equalsIgnoreCase("tic") || board.winnerCheck().equalsIgnoreCase("tac")){
                        break;
                    }
                } else {
                    for (int j = 0; ; i++) {
                        System.out.println("Укажите заново столбец и строку: ");
                        column = scanner.nextInt();
                        row = scanner.nextInt();
                        if (board.isPossibleStep(column, row)) {
                            newGame[column - 1][row - 1] = player2.step(player2.getName(), column - 1, row - 1,board);
                            steps.add(new Step(column, row, player2.getName()));
                            board.print();
                            if (board.winnerCheck().equalsIgnoreCase("tic") || board.winnerCheck().equalsIgnoreCase("tac")){
                                break;
                            }
                            break;
                        }
                    }
                }

            }
            i++;
        }
        for (Step step : steps) {
            System.out.println(step.getColumn() + " " + step.getRow() + " " + step.getPlayer() + " Очередь хода " +
                    step.getOrderOfStep());
        }
        System.out.println("Игра окончена");
    }

    private static void botToHuman(Scanner scanner) {

        Bot player1 = new Bot("tic");
        Human player2 = new Human("tac");
        ArrayList<Step> steps = new ArrayList<Step>();
        Board board = new Board();
        System.out.println("Укажите размер доски: ");
        int size = scanner.nextInt();
        board.createBoard(size);
        System.out.println("Размер доски = " + size + "x" + size);
        int[][] newGame = board.getField();
        int i = 0;

        while (board.winnerCheck().equalsIgnoreCase("nobody") && i < newGame.length * newGame.length) {
            if (board.playerCheck().equalsIgnoreCase(player1.getName())) {
                System.out.println("Ходит игрок " + player1.getName());
            }
//            player1.position(board);
            steps.add(player1.position(board));
            board.print();
            if (board.winnerCheck().equalsIgnoreCase("tic") || board.winnerCheck().equalsIgnoreCase("tac")){
                break;
            }
            System.out.println("Ходите вы. Укажите столбец: ");
            int column = scanner.nextInt();
            System.out.println("Укажите строку: ");
            int row = scanner.nextInt();
            if (board.isPossibleStep(column, row)) {
                newGame[column - 1][row - 1] = player2.step(player2.getName(), column - 1, row - 1,board);
                steps.add(new Step(column, row, player2.getName()));
                board.print();
                if (board.winnerCheck().equalsIgnoreCase("tic") || board.winnerCheck().equalsIgnoreCase("tac")){
                    break;
                }
            } else {
                for (int j = 0; ; i++) {
                    System.out.println("Укажите заново столбец и строку: ");
                    column = scanner.nextInt();
                    row = scanner.nextInt();
                    if (board.isPossibleStep(column, row)) {
                        newGame[column - 1][row - 1] = player2.step(player2.getName(), column - 1, row - 1,board);
                        steps.add(new Step(column, row, player2.getName()));
                        board.print();
                        board.winnerCheck();
                        break;
                    }
                }
            }
            i++;
        }
        for (Step step : steps) {
            System.out.println(step.getColumn() + " " + step.getRow() + " " + step.getPlayer() + " Очередь хода " +
                    step.getOrderOfStep());
        }
        System.out.println("Игра окончена");
    }


}

