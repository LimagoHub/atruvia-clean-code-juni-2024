package main;

import de.atruvia.client.GameClient;
import de.atruvia.game.nimgame.NimGame;
import de.atruvia.game.nimgame.player.ComputerPlayer;
import de.atruvia.game.nimgame.player.GrandMaPlayer;
import de.atruvia.game.nimgame.player.HumanPlayer;
import de.atruvia.io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {

        NimGame game = new NimGame(new ConsoleWriter());
        game.addPlayer(new GrandMaPlayer("Hannelore"));
        game.addPlayer(new HumanPlayer("Fritz"));
        game.addPlayer(new ComputerPlayer("HAL"));
        GameClient client = new GameClient(game);
        client.go();

    }
}