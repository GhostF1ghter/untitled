package kz.mygame.tictac.saves;

public class Step {
    int column;
    int row;
    String player;
    int orderOfStep = 0;
    static int counter = 1;

    public int getOrderOfStep() {
        return orderOfStep;
    }

    @Override
    public String toString() {
        return "Step{" +
                "Стобец= " + column +
                ", Строка= " + row +
                ", Игрок= '" + player + '\'' +
                ", Очередь хода=" + orderOfStep +
                '}';
    }

    public Step(int column, int row, String player) {
        this.column = column;
        this.row = row;
        this.player = player;
        this.orderOfStep = counter++;
    }

    public String getColumn() {

        return Integer.toString(column+1);
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getRow() {
        return Integer.toString(row + 1);
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
