package new_game;

public class Player{
    private String name;
     int tic = 1;
     int tac = 2;

    public int getTic() {
        return tic;
    }

    public int getTac() {
        return tac;
    }




    public Player(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
