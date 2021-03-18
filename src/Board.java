public class Board {
    private final int rows;
    private final int columns;
    private final Player[][] board;
    public int parkingSpaces;
    private boolean noWinner;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new Player[rows][columns];
        this.parkingSpaces = rows * columns;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public int[] getNthEmptySpace(int n) {
        int count = 0;
        int column = 1;
        int row = 0;
        Player player;
        do {
            row++;
            if (row > rows) {
                row = 1;
                column++;
            }
            player = getPlayerAtLocation(row, column);
            if (player == null) {
                count++;
            }
        } while (count < n);
        if (column > columns) {
            return null;
        }
        return new int[]{row, column};
    }

    public Player getPlayerAtLocation(int row, int column) {
        if (this.rows >= row && this.columns >= column) {
            return this.board[row][column];
        }
        return null;
    }

    public Player win() {
        if (this.noWinner) {
            return null;
        }
        this.noWinner = true;
        return null;
    }

    public boolean tie() {
        if (this.win() != null) {
            return false;
        }

        return this.parkingSpaces <= 0;
    }

    public boolean makeMove(int row, int column, Player player) {
        if (this.rows >= row && this.columns >= column && this.getPlayerAtLocation(row, column) == null) {
            this.board[row][column] = player;
            this.parkingSpaces--;
            this.noWinner = false;
            return true;
        }
        return false;
    }
}
