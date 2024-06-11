package de.atruvia.game.nimgame;

import de.atruvia.game.Game;
import de.atruvia.game.nimgame.player.NimGamePlayer;
import de.atruvia.io.Writer;

import java.util.*;
import java.util.Scanner;

public class NimGame implements Game {


    private final Writer writer;
    private final List<NimGamePlayer> players = new ArrayList<>();
    private int stones;
    private int turn;
    private NimGamePlayer currentPlayer;


    public NimGame(final Writer writer) {
        this.writer = writer;
        stones = 23;

    }

    public void add(NimGamePlayer player) {
        // player.setWriter(writer);
        players.add(player);
    }

    public void remove(NimGamePlayer player) {
        players.remove(player);
    }

    protected NimGamePlayer getCurrentPlayer() {
        return currentPlayer;
    }

    private void setCurrentPlayer(NimGamePlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void play() {
        while( ! isGameover()) {
            playRound();
        }
    }

    private void playRound() {// Intergration

       for(var player : players) {
           setCurrentPlayer(player);
           playSingleTurn();
       }
    }

    private void playSingleTurn() {
        if(isGameover()) return;
        executeTurnAndRepeatUntilValid();
        terminateTurn( );


    }

    private void executeTurnAndRepeatUntilValid() {
        do turn = getCurrentPlayer().doTurn(stones); while(turnIsNotValid());
    }

    private boolean turnIsNotValid() {
        if(  isTurnValid())
            return false;
        write("Ungueltiger Zug");
        return true;

    }



    private void terminateTurn() {
        updateBoard();
        printGameOverMessageIfGameIsOver();
    }

    private void printGameOverMessageIfGameIsOver() {
        if(isGameover())  write(getCurrentPlayer().getName() + " hat verloren.");
    }

    protected void write(String message) {
        writer.write(message);
    }
//------------------------------------------------------------------------------

    private boolean isTurnValid() {  // Operation
        return turn >= 1 && turn <= 3;
    }

    private void updateBoard() {
        stones -= turn;
    }

    public boolean isGameover() {
        return stones < 1  || players.isEmpty();
    }
}
