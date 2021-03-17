public class Board {
    public int getColumns() {
        return 3;
    }

    public int getRows() {
        return 3;
    }

    public Player getPlayerAtLocation(int x, int y) {
        return null;
    }

    public Player win() {
        return null;
    }

    public boolean tie() {
        return false;
    }

    public boolean makeMove(int row, int column, Player player) {
        return true;
    }
}
