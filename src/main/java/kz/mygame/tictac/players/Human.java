package kz.mygame.tictac.players;

import kz.mygame.tictac.new_game.*;

public class Human extends Player implements Turn {
    public Human(String name) {
        super(name);

    }

    public int step(String player, int column, int row,Board board) {
        player = super.getName();
        int[][] checkerboard = board.getField();
        try {
            if (checkerboard[column][row] == 0 && player.equalsIgnoreCase("tic")) {
                return getTicOrTac();
            }
            if (checkerboard[column][row] == 0 && player.equalsIgnoreCase("tac")) {
                return getTicOrTac();
            } else {
                throw new Exception("Укажите пустое место в поле");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return checkerboard[column][row];
        }
    }
}
