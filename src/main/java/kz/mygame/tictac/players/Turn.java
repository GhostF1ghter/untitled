package kz.mygame.tictac.players;

import kz.mygame.tictac.new_game.Board;
import kz.mygame.tictac.saves.Step;

public interface Turn {
public int step(String name, int column, int row, Board board);
}
