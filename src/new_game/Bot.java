package new_game;

public class Bot extends Player implements Turn {
    public Bot(String name) {
        super(name);
    }

    public int step(String player, int column, int row) {
        player = super.getName();
        Board board = new Board();
        int[][] checkerboard = board.getField();
        if (checkerboard[column][row] == 0 && player.equalsIgnoreCase("tic")) {
            return getTic();
        }
        if (checkerboard[column][row] == 0 && player.equalsIgnoreCase("tac")) {
            return getTac();
        }
        return 3;
    }

    public void position() {
        Board board = new Board();
        int[][] field = board.getField();
        for (int i = 0; i < field.length; i++) {
            if (field[field.length - i - 1][i] == 0) {
                field[field.length - i - 1][i] = step(getName(), field.length - i - 1, i);
                return;

            }
            if (field[field.length - i - 1][field.length - i - 1] == 0) {
                field[field.length - i - 1][field.length - i - 1] = step(getName(), field.length - i - 1, field.length - i - 1);
                return;

            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][i] == 0) {
                    field[j][i] = step(getName(), j, i);
                    return;

                }
                if (field[field.length - j - 1][i] == 0) {
                    field[field.length - j - 1][i] = step(getName(), field.length - j - 1, i);
                    return;


                }
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 0) {
                    field[i][j] = step(getName(), i, j);
                    return;
                }
                if (field[i][field.length - i - 1] == 0) {
                    field[i][field.length - i - 1] = step(getName(), i, field.length - i - 1);
                    return;
                }
            }
        }


    }


}
