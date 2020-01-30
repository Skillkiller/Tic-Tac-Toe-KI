package tictactoe.util;

public enum State {
    BLANK(null, false), X("x.png", false), O("o.png", true);

    private String filename;
    private boolean ki;

    State(String filename, boolean ki) {
        this.filename = filename;
        this.ki = ki;
    }

    public String getFilename() {
        return filename;
    }

    public boolean isKi() {
        return ki;
    }
}