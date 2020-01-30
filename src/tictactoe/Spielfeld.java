package tictactoe;

import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import tictactoe.actor.Symbol;

import java.awt.*;

public class Spielfeld extends GameGrid {

    public Spielfeld(int nbHorzCells, int nbVertCells) {
        super(nbHorzCells, nbVertCells, 128, Color.RED, "white.png", false);
        setTitle("Tic Tac Toe");
        show();
    }

    public void makeMove(Symbol symbol, Location location) {
        addActor(symbol, location);
    }

}
