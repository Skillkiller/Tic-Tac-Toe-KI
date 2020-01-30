package tictactoe.actor;

import ch.aplu.jgamegrid.Actor;
import tictactoe.util.State;

public class Symbol extends Actor {

    private State user;

    public Symbol(State user) {
        super(user.getFilename());
        this.user = user;
    }

    public State getUser() {
        return user;
    }

}
