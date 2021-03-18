import java.util.Random;

public class RandomPlayer extends Player {
    public RandomPlayer(char mark) {
        super(mark);
    }

    public Move getMove(Board board) {
        Random rand = new Random();
        int space = rand.nextInt(board.parkingSpaces);
        int[] coordinates = board.getNthEmptySpace(space);
        return new Move(coordinates[0], coordinates[1]);
    }
}
