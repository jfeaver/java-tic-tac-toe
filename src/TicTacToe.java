class TicTacToe {
    public static void main(String args[]) {
        Board board = new Board();
        String title = "Tic Tac Fro";
        Player playerX = new Player();
        Player playerO = new Player();
        BoardShow view = new BoardShow(board, title, playerX, playerO);
        view.updateBoard(board);
    }
}
