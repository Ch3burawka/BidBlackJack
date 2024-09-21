public class Main {
    public static void main(String[] args) {
        Cards cards = new Cards();
        cards.shuffleDeck();
        cards.printDeck();
        cards.play();
        cards.nextcard();
    }
}
