class TicTacToe {
    public static void main(String[] args) {
        // TODO: Add command line args for rows/columns
        Board board = new Board(3, 3);
        String title = "Tic Tac Fro";
        Player playerX = new HumanPlayer('X');
        Player playerO = new RandomPlayer('O');
        BoardShow view = new BoardShow(board, title, playerX, playerO);
        Players players = new Players(playerX, playerO);

        while (!board.tie() && board.win() == null) {
            Move move = players.current.getMove(board);
            if (board.makeMove(move, players.current)) {
                view.updateBoard(board);
                players.nextPlayer();
            }
        }
    }
}
