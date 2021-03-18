public abstract class Player {
    private final char mark;

    public Player(char mark) {
        this.mark = mark;
    }

    public char getPlayerType() {
        return this.mark;
    }

    // A null move corresponds to quitting the game (for convenience)
    public abstract Move getMove(Board board);
}
