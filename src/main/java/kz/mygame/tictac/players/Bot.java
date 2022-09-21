package kz.mygame.tictac.players;

import kz.mygame.tictac.new_game.*;
import kz.mygame.tictac.saves.Step;

public class Bot extends Player implements Turn {
    public Bot(String name) {
        super(name);
    }

    public int step(String player, int column, int row,Board board) {
        player = super.getName();
        int[][] checkerboard = board.getField();
        if (checkerboard[column][row] == 0 && player.equalsIgnoreCase("tic")) {
            return getTicOrTac();
        }
        if (checkerboard[column][row] == 0 && player.equalsIgnoreCase("tac")) {
            return getTicOrTac();
        }
        return 3;
    }

    public Step position(Board board) {
        int[][] field = board.getField();
        for (int i = 0; i < field.length; i++) {
            if (field[field.length - i - 1][i] == 0) {
                field[field.length - i - 1][i] = step(getName(), field.length - i - 1, i,board);

                return new Step(field.length - i - 1,i,getName());

            }
            if (field[field.length - i - 1][field.length - i - 1] == 0) {
                field[field.length - i - 1][field.length - i - 1] = step(getName(), field.length - i - 1, field.length - i - 1,board);

                return new Step(field.length - i - 1,field.length - i - 1,getName());

            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][i] == 0) {
                    field[j][i] = step(getName(), j, i,board);

                    return new Step(j,i,getName());

                }
                if (field[field.length - j - 1][i] == 0) {
                    field[field.length - j - 1][i] = step(getName(), field.length - j - 1, i,board);

                    return new Step(field.length - j - 1,i,getName());


                }
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 0) {
                    field[i][j] = step(getName(), i, j,board);
                    return new Step(i,j,getName());
                }
                if (field[i][field.length - j - 1] == 0) {
                    field[i][field.length - j - 1] = step(getName(), i, field.length - i - 1,board);
                    return new Step(i,field.length - j - 1,getName());
                }
            }
        }

return new Step(0,0,"nobody");
    }




}
