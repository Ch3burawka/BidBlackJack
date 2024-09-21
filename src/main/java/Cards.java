import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cards {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> deck = new ArrayList<>();
    ArrayList<String> useddeck = new ArrayList<>();
    Hand hand1 = new Hand();
    public Cards() {
        initdeck();
    }

    public void initdeck() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }
    }

    public void printDeck() {
        for (String jackdeck : deck) {
            System.out.println(jackdeck);
        }
    }

    public String dealCard() {
        if (deck.size() > 0) {
            String dcard = deck.remove(deck.size() - 1);
            useddeck.add(dcard);
            return dcard;
        }
        else {
            return "No cards left to deal";
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void play() {
        System.out.println("Welcome to the Big Black Jack to start the game press 1 if you want to quit press 2");
        int in = sc.nextInt();
        while (in != 1 && in != 2) {
            System.out.println("Invalid input");
        }
        if (in == 1) {
            System.out.println("Your card is " + dealCard());
            hand1.addCard(dealCard());
        } else {
            System.exit(0);
        }
    }
    public void nextcard () {
        boolean contplay = true;
        while (contplay) {
            System.out.println("Please enter 1 if you want one more card, enter 2 if you want to calculate your hand");
            int in1 = sc.nextInt();
            while (in1 != 1 && in1 != 2) {
                System.out.println("Invalid input, please enter 1 or 2.");
                in1 = sc.nextInt();}
            if (in1 == 1) {
                String newcard = dealCard();
                System.out.println("Your card is " + newcard);
                hand1.addCard(newcard);
            }
            else if (in1 == 2) {
                hand1.disphand();
                hand1.calc();
                int i = hand1.calc();
                System.out.println("Your total is " + i);
                contplay = false;
            }
        }
    }
}

