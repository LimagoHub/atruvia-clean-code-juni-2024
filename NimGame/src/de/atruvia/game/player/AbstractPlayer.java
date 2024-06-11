package de.atruvia.game.player;

public abstract class AbstractPlayer<BOARD, TURN> implements Player<BOARD, TURN> {

    private String name = getClass().getSimpleName();


    public AbstractPlayer() {
    }

    public AbstractPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
