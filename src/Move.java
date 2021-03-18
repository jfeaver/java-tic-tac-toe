public class Move {
    private final int row;
    private final int column;

    public Move(String moveInput) {
        String[] coordinates = moveInput.split(",");
        this.row = Integer.parseInt(coordinates[0], 10);
        this.column = Integer.parseInt(coordinates[1], 10);
    }

    public Move(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
