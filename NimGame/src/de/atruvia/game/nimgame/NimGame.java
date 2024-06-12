package de.atruvia.game.nimgame;

import de.atruvia.game.AbstractGame;
import de.atruvia.io.Writer;

public class NimGame extends AbstractGame<Integer,Integer> {

    public NimGame(Writer writer) {
        super(writer);
        setBoard(23);
    }

    protected boolean isTurnValid() {  // Operation
        return getTurn() >= 1 &&  getTurn() <= 3;
    }

    protected void updateBoard() {
        setBoard(getBoard() - getTurn());
    }

    protected boolean isGameover() {
        return getBoard() < 1  || getPlayers().isEmpty();
    }
}
