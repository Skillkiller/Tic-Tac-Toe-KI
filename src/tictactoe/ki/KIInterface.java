package tictactoe.ki;

import tictactoe.Board;
import tictactoe.util.State;

public interface KIInterface {

    public void makeDecision(Board board, State player);

}
