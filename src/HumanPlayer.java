import javax.swing.*;

public class HumanPlayer extends Player {
    private final JLabel prompt = new JLabel("Where move (x,y)?");

    public HumanPlayer(char mark) {
        super(mark);
    }

    public Move getMove(Board board) {
        String moveInput = JOptionPane.showInputDialog(prompt);
        return new Move(moveInput);
    }
}
