package tictactoe.listener;

import ch.aplu.jgamegrid.Location;
import tictactoe.Board;
import tictactoe.Main;
import tictactoe.Spielfeld;
import tictactoe.util.State;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener {

    private Board board;
    private Spielfeld spielfeld;

    public MouseListener() {
        this.board = Main.getBoard();
        this.spielfeld = Main.getSpielfeld();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (board.getPlayer() != State.X || board.isGameOver()) {
            return;
        }
        Location location = spielfeld.toLocationInGrid(e.getX(), e.getY());
        board.move(location.getX(), location.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
