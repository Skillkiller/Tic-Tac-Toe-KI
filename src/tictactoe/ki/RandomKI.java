package tictactoe.ki;

import tictactoe.Board;
import tictactoe.util.State;

import java.util.List;
import java.util.Random;

public class RandomKI implements KIInterface {
    private Random random = new Random();

    @Override
    public void makeDecision(Board board, State player) {
        List<Integer> cells = board.getAvailableMoves();
        board.move(cells.get(random.nextInt(cells.size())));
    }
}
