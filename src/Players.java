public class Players {
    public Player current;
    private Player next;

    public Players(Player one, Player two) {
        this.current = one;
        this.next = two;
    }

    public void nextPlayer() {
        Player temp = current;
        this.current = next;
        this.next = temp;
    }
}
