package main;

import de.atruvia.client.GameClient;
import de.atruvia.game.Game;
import de.atruvia.game.nimgame.NimGame;
import de.atruvia.game.nimgame.player.ComputerPlayer;
import de.atruvia.game.nimgame.player.HumanPlayer;
import de.atruvia.io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {

        NimGame game = new NimGame(new ConsoleWriter());
        game.add(new HumanPlayer());
        game.add(new ComputerPlayer());
        GameClient client = new GameClient(game);
        client.go();

    }
}