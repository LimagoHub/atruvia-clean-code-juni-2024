package de.atruvia.game;

import de.atruvia.game.player.Player;
import de.atruvia.io.Writer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractGame<BOARD, TURN> implements Game{

    private final Writer writer;
    private final List<Player<BOARD,TURN>> players = new ArrayList<>();

    private BOARD board;
    private TURN turn;
    private Player<BOARD,TURN> currentPlayer;


    public AbstractGame(Writer writer) {
        this.writer = writer;
    }

    protected TURN getTurn() {
        return turn;
    }

    protected void setTurn(TURN turn) {
        this.turn = turn;
    }

    protected BOARD getBoard() {
        return board;
    }

    protected void setBoard(BOARD board) {
        this.board = board;
    }

    protected Player<BOARD,TURN> getCurrentPlayer() {
        return currentPlayer;
    }

    private void setCurrentPlayer(Player<BOARD,TURN> currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Player<BOARD, TURN>> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public void addPlayer(Player<BOARD,TURN> player) {
        // player.setWriter(writer);
        players.add(player);
    }

    public void removePlayer(Player<BOARD,TURN> player) {
        players.remove(player);
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
        do {
            setTurn(getCurrentPlayer().doTurn(getBoard()));

        }while(turnIsNotValid());
    }

    private void terminateTurn() {
        updateBoard();
        printGameOverMessageIfGameIsOver();
    }

    private boolean turnIsNotValid() {
        if(  isTurnValid())
            return false;
        write("Ungueltiger Zug");
        return true;

    }

    private void printGameOverMessageIfGameIsOver() {
        if(isGameover())  write(getCurrentPlayer().getName() + " hat verloren.");
    }

    protected void write(String message) {
        writer.write(message);
    }

    //---------------------------------------

    protected abstract boolean isTurnValid();

    protected abstract void updateBoard() ;

    protected abstract boolean isGameover() ;

}
