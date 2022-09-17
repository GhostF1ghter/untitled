package new_game;

public class Human extends Player implements Turn {


    public Human(String name) {
        super(name);
    }

    public boolean isPossibleStep(int column,int row){
        Board board = new Board();
        int[][] checkerboard = board.getField();
        return column >= 1 && column <= checkerboard.length && row >= 1 && row <= checkerboard.length;
    }


    public int step(String player, int column, int row) {
        player = super.getName();
        Board board = new Board();
        int[][] checkerboard = board.getField();

        try {
            if (checkerboard[column][row] == 0 && player.equalsIgnoreCase("tic")) {
                return 1;
            }
            if (checkerboard[column][row] == 0 && player.equalsIgnoreCase("tac")) {
                return 2;
            } else {
                throw new Exception("Укажите пустое место в поле");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return checkerboard[column][row] ;
        }
    }
}
