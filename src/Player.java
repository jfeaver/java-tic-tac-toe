public abstract class Player {
    public char getPlayerType() {
        return 'X';
    }

    public abstract Move getMove(Board board);
}
