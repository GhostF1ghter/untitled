package kz.mygame.tictac.players;

public class Player {
    private String name;
    int ticOrTac;

    public int getTicOrTac() {
        return ticOrTac;
    }

    public Player(String name) {
        this.name = name;
        if (name.equalsIgnoreCase("tic"))
            this.ticOrTac = 1;
        else {
            this.ticOrTac = 2;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
