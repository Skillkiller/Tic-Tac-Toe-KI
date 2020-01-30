package tictactoe;

import ch.aplu.jgamegrid.Location;
import tictactoe.actor.Symbol;
import tictactoe.util.State;

import java.util.LinkedList;
import java.util.List;

public class Board {

    private Spielfeld spielfeld;
    private int moveCount = 0;
    private State player = State.X;
    private State winner = State.BLANK;
    private boolean gameOver = false;

    private State[][] board;

    public Board(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
        board = new State[3][3];
        reset();
    }

    public void reset() {
        moveCount = 0;
        gameOver = false;
        player = State.X;
        winner = State.BLANK;
        if (spielfeld != null) {
            spielfeld.removeAllActors();
            spielfeld.doReset();
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = State.BLANK;
            }
        }
    }

    public void move(int index) {
        move(index % 3, index / 3);
    }

    public void move(int x, int y) {
        if (gameOver) return;
        if (board[y][x] == State.BLANK) {
            board[y][x] = player;
        } else {
            return;
        }

        moveCount++;
        if (moveCount == 9) {
            winner = State.BLANK;
            gameOver = true;
        }
        if (spielfeld != null) {
            spielfeld.makeMove(new Symbol(player), new Location(x, y));
        }

        // Check for a winner.
        checkRow(y);
        checkColumn(x);
        checkDiagonalFromTopLeft(x, y);
        checkDiagonalFromTopRight(x, y);

        player = (player == State.X) ? State.O : State.X;

        if (spielfeld != null) {
            Main.handleNextMove();
        }
    }

    public State getPlayer() {
        return player;
    }

    public State getWinner() {
        return winner;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public List<Integer> getAvailableMoves() {
        List<Integer> moves = new LinkedList<>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == State.BLANK) {
                    moves.add(row * 3 + col);
                }
            }
        }
        return moves;
    }

    public Board getDeepCopy() {
        Board newBoard = new Board(null);

        for (int i = 0; i < newBoard.board.length; i++) {
            newBoard.board[i] = this.board[i].clone();
        }

        newBoard.player = player;
        newBoard.gameOver = gameOver;
        newBoard.winner = winner;
        newBoard.moveCount = moveCount;
        return newBoard;
    }

    private void checkRow(int row) {
        for (int i = 1; i < 3; i++) {
            if (board[row][i] != board[row][i - 1]) {
                break;
            }
            if (i == 3 - 1) {
                winner = player;
                gameOver = true;
            }
        }
    }

    private void checkColumn(int column) {
        for (int i = 1; i < 3; i++) {
            if (board[i][column] != board[i - 1][column]) {
                break;
            }
            if (i == 3 - 1) {
                winner = player;
                gameOver = true;
            }
        }
    }

    private void checkDiagonalFromTopLeft(int x, int y) {
        if (x == y) {
            for (int i = 1; i < 3; i++) {
                if (board[i][i] != board[i - 1][i - 1]) {
                    break;
                }
                if (i == 3 - 1) {
                    winner = player;
                    gameOver = true;
                }
            }
        }
    }

    private void checkDiagonalFromTopRight(int x, int y) {
        if (3 - 1 - x == y) {
            for (int i = 1; i < 3; i++) {
                if (board[3 - 1 - i][i] != board[3 - i][i - 1]) {
                    break;
                }
                if (i == 3 - 1) {
                    winner = player;
                    gameOver = true;
                }
            }
        }
    }
}
