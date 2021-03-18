class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board(3, 3);
        String title = "Tic Tac Fro";
        Player playerX = new HumanPlayer('X');
        Player playerO = new RandomPlayer('O');
        new BoardShow(board, title, playerX, playerO);
    }
}
