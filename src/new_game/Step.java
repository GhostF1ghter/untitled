package new_game;

public class Step {
    int column;
    int row;
    String player;
     int orderOfStep = 0;

    public int getOrderOfStep() {
        return orderOfStep;
    }

    public Step(int column, int row, String player) {
    this.column = column;
    this.row = row;
    this.player = player;

    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }


}
