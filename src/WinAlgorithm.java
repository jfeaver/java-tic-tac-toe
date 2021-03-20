public class WinAlgorithm {
    private final Board board;
    private final int rows;
    private final int columns;
    public boolean hasDiagonals;
    public boolean hasCenter;
    public int center;
    private Player winner;
    private Player observedPlayer;

    public WinAlgorithm(Board board) {
        this.board = board;
        this.rows = board.getRows();
        this.columns = board.getColumns();
        this.hasDiagonals = rows == columns;
        this.hasCenter = hasDiagonals && this.rows % 2 == 1;
        if (this.hasCenter) {
            this.center = rows / 2 + 1;
        }
    }

    public Player call() {
        if (hasDiagonals) {
            return diagonalsFirstAlgorithm();
        } else {
            return rowsAndColumnsAlgorithm();
        }
    }

    private Player rowsAndColumnsAlgorithm() {
        for (int r = 1; r < rows; r++) {
            checkRow(r);
            if (winner != null) {
                return winner;
            }
            this.observedPlayer = null;
        }
        for (int c = 1; c < columns; c++) {
            checkRow(c);
            if (winner != null) {
                return winner;
            }
            this.observedPlayer = null;
        }
        return null;
    }

    private Player diagonalsFirstAlgorithm() {
        this.observedPlayer = board.getPlayerAtCoordinate(center, center);
        if (observedPlayer != null) {
            checkRightDiagonal();
            if (winner != null) {
                System.out.println("RD");
                return winner;
            }
            checkLeftDiagonal();
            if (winner != null) {
                System.out.println("LD");
                return winner;
            }
            checkRow(center);
            if (winner != null) {
                System.out.println("CR");
                return winner;
            }
            checkColumn(center);
            if (winner != null) {
                System.out.println("CC");
                return winner;
            }
            this.observedPlayer = null;
        }
        this.observedPlayer = null;
        for (int i = 1; i < center; i++) {
            checkRow(i);
            if (winner != null) {
                System.out.printf("R%d", i);
                return winner;
            }
            this.observedPlayer = null;
            checkColumn(i);
            if (winner != null) {
                System.out.printf("C%d", i);
                return winner;
            }
            this.observedPlayer = null;
        }
        for (int i = center + 1; i <= rows; i++) {
            checkRow(i);
            if (winner != null) {
                System.out.printf("R%d", i);
                return winner;
            }
            this.observedPlayer = null;
            checkColumn(i);
            if (winner != null) {
                System.out.printf("C%d", i);
                return winner;
            }
            this.observedPlayer = null;
        }
        return null;
    }

    private void checkRow(int r) {
        checkLine(r, columns, true);
    }

    private void checkColumn(int c) {
        checkLine(c, rows, false);
    }

    private void checkLine(int l, int max, boolean rows) {
        Player inSpace;
        for (int i = 1; i <= max; i++) {
            if (rows) {
                inSpace = board.getPlayerAtCoordinate(l, i);
            } else {
                inSpace = board.getPlayerAtCoordinate(i, l);
            }
            if (observedPlayer == null) {
                this.observedPlayer = inSpace;
            }
            if (observedPlayer != inSpace || inSpace == null) {
                break;
            }
            if (i == max) {
                this.winner = observedPlayer;
            }
        }
    }

    private void checkRightDiagonal() {
        for (int i = 1; i <= rows; i++) {
            if (!checkDiagonalStep(i, i)) {
                break;
            }
            if (i == rows) {
                this.winner = observedPlayer;
            }
        }
    }

    private void checkLeftDiagonal() {
        for (int i = 1; i <= rows; i++) {
            if (!checkDiagonalStep(i, columns - i + 1)) {
                break;
            }
            if (i == rows) {
                this.winner = observedPlayer;
            }
        }
    }

    private boolean checkDiagonalStep(int row, int column) {
        if (row != center) {
            Player inSpace = board.getPlayerAtCoordinate(row, column);
            return inSpace == observedPlayer;
        }
        return true;
    }
}
