import javax.swing.*;

public class HumanPlayer extends Player {
    private final JLabel prompt = new JLabel("Where move (row,column)?");

    public HumanPlayer(char mark) {
        super(mark);
    }

    public Move getMove(Board board) {
        // TODO: Handle Cancel
        String moveInput = JOptionPane.showInputDialog(prompt);
        return new Move(moveInput);
    }
}
