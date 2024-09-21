import java.util.ArrayList;

public class Dealer {
    Deck deck = new Deck();
    Hand hand = new Hand();
    public ArrayList<String> dHand;

    public Dealer() {
        dHand = new ArrayList<>();
    }

    public void addCard(String card) {
        dHand.add(card);
    }

    public int dealerPlay() {
        String card = deck.dealCard();
        addCard(card);
        hand.addCard(card);
        while (hand.calc() < 17) {
            card = deck.dealCard();
            addCard(card);
            hand.addCard(card);
        }
        return hand.calc();
    }
}
