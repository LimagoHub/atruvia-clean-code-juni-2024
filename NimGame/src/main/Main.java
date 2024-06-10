package main;

import de.atruvia.client.GameClient;
import de.atruvia.game.Game;
import de.atruvia.game.nimgame.NimGame;

public class Main {
    public static void main(String[] args) {

        Game game = new NimGame();
        GameClient client = new GameClient(game);
        client.go();

    }
}