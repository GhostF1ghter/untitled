package new_game;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private static int[][] field;

    public Board() {
    }

    public int[][] getField() {
        return field;
    }


    public String winnerCheck() {

        int winner = 0;
        for (int i = 0; i < field.length; i++) {
            int columnCounter = 0;
            int rowCounter = 0;


            for (int j = 0; j < field.length; j++) {
                if ((field[i][j] == field[i][0] && field[i][0] != 0) || (columnCounter == field.length)) {
                    columnCounter++;
                    if (columnCounter == field.length) {
                        winner = field[i][j];
                    }

                }
                if ((field[j][i] == field[0][i] && field[0][i] != 0) || (rowCounter == field.length)) {
                    rowCounter++;
                    if (rowCounter == field.length) {
                        winner = field[j][i];
                    }
                }
            }
        }

        int mainDiagonalCounter = 0;
        int secondaryDiagonalCounter = 0;
        for (int i = 0; i < field.length; i++) {
            if ((field[i][i] == field[0][0] && field[0][0] != 0) || mainDiagonalCounter == field.length) {
                mainDiagonalCounter++;
                if (mainDiagonalCounter == field.length)
                    winner = field[i][i];
            }
            if ((field[i][field.length - 1 - i] == field[field.length - 1][0] && field[field.length - 1][0] != 0)
                    || secondaryDiagonalCounter == field.length) {
                secondaryDiagonalCounter++;
                if (secondaryDiagonalCounter == field.length)
                    winner = field[i][field.length - 1 - i];
            }
        }


        if (winner == 1) {
            System.out.println("Победил tic");
            return "tic";
        }
        if (winner == 2) {
            System.out.println("Победил tac");
            return "tac";
        }

        return "nobody";

    }

    public String playerCheck() {
        int counterFirstPlayer = 0;
        int counterSecondPlayer = 0;


        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    counterFirstPlayer++;
                }
                if (field[i][j] == 2) {
                    counterSecondPlayer++;
                }
            }
        }

        if (counterFirstPlayer < counterSecondPlayer || counterFirstPlayer == counterSecondPlayer) {
            return "tic";
        } else {
            return "tac";
        }
    }

    public void createBoard(int size) {
        field = new int[size][size];
        print();
    }

    public void print() {
        for (int j = 0; j < field.length; j++) {
            for (int i = 0; i < field.length; i++) {
                System.out.print(field[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
