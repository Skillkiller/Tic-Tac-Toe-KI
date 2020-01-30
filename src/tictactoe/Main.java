package tictactoe;

import ch.aplu.jgamegrid.Location;
import tictactoe.actor.Win;
import tictactoe.ki.KIInterface;
import tictactoe.ki.MiniMaxKI;
import tictactoe.listener.MouseListener;

public class Main {

    private static Board board;
    private static Spielfeld spielfeld;
    private static KIInterface ki;

    public static void main(String[] args) {
        spielfeld = new Spielfeld(3, 3);

        // Ki definieren
        ki = new MiniMaxKI(10);

        board = new Board(spielfeld);

        spielfeld.addMouseListener(new MouseListener());
        handleNextMove();
    }

    public static void handleNextMove() {
        if (board.isGameOver()) {
            spielfeld.removeAllActors();
            spielfeld.addActor(new Win(board.getWinner()), new Location(1, 1));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            board.reset();
            return;
        }

        if (board.getPlayer().isKi()) {
            ki.makeDecision(board, board.getPlayer());
        }
    }

    public static Board getBoard() {
        return board;
    }

    public static Spielfeld getSpielfeld() {
        return spielfeld;
    }
}
