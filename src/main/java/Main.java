public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Game game = new Game(deck);
        Dealer dealer = new Dealer(deck);
//        deck.printDeck();
        game.play();
        game.nextCard();
        dealer.dealerPlay();
        game.compare();
    }
}
