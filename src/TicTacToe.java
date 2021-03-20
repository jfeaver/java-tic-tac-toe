import javax.swing.*;

class TicTacToe {
    public static void main(String[] args) {
        Integer rows = 3;
        Integer columns = 3;
        if (args.length == 2) {
            rows = Util.parseInt(args[0]);
            columns = Util.parseInt(args[1]);
            if (rows == null || columns == null || rows < 1 || columns < 1) {
                rows = 3;
                columns = 3;
            }
        }
        Board board = new Board(rows, columns);
        String title = "Tic Tac Fro";
        Player playerX = new HumanPlayer('X');
        Player playerO = new RandomPlayer('O');
        BoardShow view = new BoardShow(board, title, playerX, playerO);
        Players players = new Players(playerX, playerO);
        boolean quit = false;

        while (!quit && !board.tie() && board.win() == null) {
            Move move = players.current.getMove(board);
            if (move == null) {
                quit = true;
            } else if (move.valid() && board.makeMove(move, players.current)) {
                view.updateBoard(board);
                players.nextPlayer();
            }
        }
        Player winner = board.win();
        if (winner != null) {
            JOptionPane.showMessageDialog(null, String.format("%c is the Winner!", winner.getPlayerType()));
        } else if (board.tie()) {
            JOptionPane.showMessageDialog(null, "Tie Game!");
        }
        System.exit(0);
    }
}
