public abstract class Player {
    private final char mark;

    public Player(char mark) {
        this.mark = mark;
    }

    public char getPlayerType() {
        return this.mark;
    }

    public abstract Move getMove(Board board);
}
