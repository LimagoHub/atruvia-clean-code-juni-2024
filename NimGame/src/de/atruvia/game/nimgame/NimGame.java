package de.atruvia.game.nimgame;

import de.atruvia.game.Game;

import java.util.Scanner;

public class NimGame implements Game {
    private Scanner scanner = new Scanner(System.in);
    private int stones;
    private int turn;

    public NimGame() {
        stones = 23;

    }

    @Override
    public void play() {
        while( ! isGameover()) {
            playRound();
        }
    }

    private void playRound() {// Intergration
        playSingleTurn();
        computerTurn();
    }

    private void playSingleTurn() {
        if(isGameover()) return;

        executeConcreteTurn();

        terminateTurn(  "Du LOser");


    }

    private void executeConcreteTurn() {

        do humanTurn(); while(turnIsNotValid());
    }

    private boolean turnIsNotValid() {
        if(  isTurnValid())
            return false;
        System.out.println("Ungueltiger Zug");
        return true;

    }

    private void humanTurn() {
        System.out.println("Es gibt " + stones + " Steine. Bitte nehmen Sie 1, 2 oder 3!");
        turn = scanner.nextInt();
    }


    private void computerTurn() {

        if(isGameover()) return;
        final int[] zuege = {3,1,1,2};
        turn = zuege[stones % 4];
        System.out.println("Computer nimmt " + turn + " Steine!");
        terminateTurn("Du hast nur Glueck gehabt");

    }

    private void terminateTurn(String message) {
        updateBoard();
        printGameOverMessageIfGameIsOver(message);
    }

    private void printGameOverMessageIfGameIsOver(String message) {
        if(isGameover())  System.out.println(message);


    }
//------------------------------------------------------------------------------

    private boolean isTurnValid() {  // Operation
        return turn >= 1 && turn <= 3;
    }

    private void updateBoard() {
        stones -= turn;
    }

    public boolean isGameover() {
        return stones < 1;
    }
}
