import javax.swing.*;

public class HumanPlayer extends Player {
    private final JLabel prompt = new JLabel("Where move (row,column)?");

    public HumanPlayer(char mark) {
        super(mark);
    }

    public Move getMove(Board board) {
        String moveInput = JOptionPane.showInputDialog(prompt);
        if (moveInput != null) {
            return new Move(moveInput);
        } else {
            return null;
        }
    }
}
