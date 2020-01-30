package tictactoe.ki;

import tictactoe.Board;
import tictactoe.util.State;

public class MiniMaxKI implements KIInterface {
    private final int MAX_DEPTH;

    public MiniMaxKI(int max_depth) {
        MAX_DEPTH = max_depth;
    }

    @Override
    public void makeDecision(Board board, State player) {
        System.out.println(miniMax(player, board, 0));
    }

    private int miniMax(State player, Board board, int currentDepth) {
        if (currentDepth++ == MAX_DEPTH || board.isGameOver()) {
            return score(player, board);
        }

        double bestScore;
        if (board.getPlayer() == player) {
            //Suche Maximalen Score
            bestScore = Double.NEGATIVE_INFINITY;
        } else {
            //Suche minimalen Score
            bestScore = Double.POSITIVE_INFINITY;
        }
        int indexOfBestMove = -1;

        for (int move : board.getAvailableMoves()) {
            Board copied = board.getDeepCopy();
            copied.move(move);
            int score = miniMax(player, copied, currentDepth);

            if (board.getPlayer() == player) {
                //Suche Maximalen Score
                if (score >= bestScore) {
                    bestScore = score;
                    indexOfBestMove = move;
                }
            } else {
                //Suche minimalen Score
                if (score <= bestScore) {
                    bestScore = score;
                    indexOfBestMove = move;
                }
            }
        }
        board.move(indexOfBestMove);
        return (int) bestScore;
    }

    private int score(State player, Board board) {

        State opponent = (player == State.X) ? State.O : State.X;

        if (board.isGameOver() && board.getWinner() == player) {
            return 1;
        } else if (board.isGameOver() && board.getWinner() == opponent) {
            return -1;
        } else {
            return 0;
        }
    }
}
