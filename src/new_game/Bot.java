package new_game;

public class Bot extends Player implements Turn {
    public Bot(String name) {
        super(name);

    }



    public int step(String name) {
        return 0;
    }

    @Override
    public int step(String name, int column, int row) {
        return 0;
    }
}
