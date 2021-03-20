public class Board {
    private final int rows;
    private final int columns;
    private final Player[][] board;
    public int parkingSpaces;
    private boolean noWinner;
    private Player winner;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new Player[rows][columns];
        this.parkingSpaces = rows * columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
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
            player = getPlayerAtCoordinate(row, column);
            if (player == null) {
                count++;
            }
        } while (count < n);
        if (column > columns) {
            return null;
        }
        return new int[]{row, column};
    }

    public Player getPlayerAtLocation(int rowIndex, int columnIndex) {
        return getPlayerAtCoordinate(rowIndex + 1, columnIndex + 1);
    }

    public Player getPlayerAtCoordinate(int row, int column) {
        if (inBounds(row, column)) {
            return board[row - 1][column - 1];
        }
        return null;
    }

    public Player win() {
        if (noWinner) {
            return null;
        }
        if (winner != null) {
            return winner;
        }
        this.winner = new WinAlgorithm(this).call();
        if (winner == null) {
            this.noWinner = true;
        }
        return winner;
    }

    public boolean tie() {
        if (this.win() != null) {
            return false;
        }

        return this.parkingSpaces <= 0;
    }

    public boolean makeMove(int row, int column, Player player) {
        if (inBounds(row, column) && getPlayerAtCoordinate(row, column) == null) {
            this.board[row - 1][column - 1] = player;
            this.parkingSpaces--;
            this.noWinner = false;
            return true;
        }
        return false;
    }

    public boolean makeMove(Move move, Player player) {
        return makeMove(move.getRow(), move.getColumn(), player);
    }

    private boolean inBounds(int row, int column) {
        return (row <= rows && row > 0 && column <= columns && column > 0);
    }
}
