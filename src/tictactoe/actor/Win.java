package tictactoe.actor;

import ch.aplu.jgamegrid.Actor;
import tictactoe.util.State;

public class Win extends Actor {

    public Win(State player) {
        super("win_" + player.name() + ".png");
    }
}
