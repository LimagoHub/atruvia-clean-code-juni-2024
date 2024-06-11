package de.atruvia.game.nimgame.player;

import java.util.Random;

public class GrandMaPlayer extends AbstractNimGamePlayer{

    private final Random random = new Random();

    public GrandMaPlayer() {
    }

    public GrandMaPlayer(String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer stones) {
        int turn = random.nextInt(5) + 1;
        System.out.println(getName() + " nimmt " + turn + " Steine.");
        return turn;
    }
}
