class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board();
        String title = "Tic Tac Fro";
        Player playerX = new HumanPlayer();
        Player playerO = new RandomPlayer();
        new BoardShow(board, title, playerX, playerO);
    }
}
