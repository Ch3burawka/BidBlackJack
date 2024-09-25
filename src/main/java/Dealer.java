import java.util.ArrayList;
import java.util.Random;

public class Dealer {
    Deck deck;
    Hand hand = new Hand();
    public ArrayList<String> dHand;

    public Dealer(Deck deck) {
        this.deck = deck;
        dHand = new ArrayList<>();
    }

    public void addCard(String card) {
        dHand.add(card);
    }

    public int dealerPlay() {
        Random rand = new Random();
        String card = deck.dealCard();
        addCard(card);
        hand.addCard(card);
        while (hand.calc() < 17) {
            card = deck.dealCard();
            addCard(card);
            hand.addCard(card);
            while (hand.calc() > 12 && hand.calc() < 17) {
                int num = rand.nextInt(100);
                if (num < 20) {
                    card = deck.dealCard();
                    addCard(card);
                    hand.addCard(card);
                } else {
                    break;
                }
            }
        }
        if (hand.calc() >= 22) {
            System.out.println("Dealer bust, you win!");
            return -1;
        }
        return hand.calc();
    }
}
