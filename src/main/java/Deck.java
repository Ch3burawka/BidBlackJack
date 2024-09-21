import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<String> deck = new ArrayList<>();
    ArrayList<String> useddeck = new ArrayList<>();

    public Deck() {
        initDeck();
    }

    public void initDeck() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }
    }

    public void printDeck() {
        for (String jackDeck : deck) {
            System.out.println(jackDeck);
        }
    }

    public String dealCard() {
        if (!deck.isEmpty()) {
            String dCard = deck.remove(deck.size() - 1);
            useddeck.add(dCard);
            return dCard;
        } else {
            return "No cards left to deal";
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

}

