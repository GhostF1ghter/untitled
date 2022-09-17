package new_game;

public class Step {
    int column;
    int row;
    String player;
    static int orderOfStep = 0;

    public Step(int i, int i1, String s) {
        orderOfStep++;
        System.out.println(orderOfStep);
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
