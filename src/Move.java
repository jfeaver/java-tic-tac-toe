public class Move {
    private Integer row;
    private Integer column;

    public Move(String moveInput) {
        String[] coordinates = moveInput.split(",");
        if (coordinates.length == 2) {
            this.row = Util.parseInt(coordinates[0]);
            this.column = Util.parseInt(coordinates[1]);
        }
    }

    public Move(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Integer getRow() {
        return this.row;
    }

    public Integer getColumn() {
        return this.column;
    }

    public boolean valid() {
        return row != null && column != null && row > 0 && column > 0;
    }
}
