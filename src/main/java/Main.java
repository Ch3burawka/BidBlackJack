public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Game game = new Game();
        Dealer dealer = new Dealer();
//        deck.printDeck();
        game.play();
        game.nextCard();
        dealer.dealerPlay();
        game.compare();
    }
}
