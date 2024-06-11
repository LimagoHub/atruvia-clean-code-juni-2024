package de.atruvia.game.nimgame.player;

public class ComputerPlayer extends AbstractNimGamePlayer{

    private static final  int[] ZUEGE = {3,1,1,2};

    public ComputerPlayer() {
    }

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public int doTurn(int stones) {
        int turn = ZUEGE[stones % 4];
        System.out.println("Computer nimmt " + turn + " Steine!");
        return turn;
    }
}
