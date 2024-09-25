import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    Deck deck;
    Hand hand = new Hand();
    Dealer dealer;
    public int playerTotal;

    public Game (Deck deck) {
        this.deck = deck;
        this.dealer = new Dealer(deck);
    }

    public void play() {
        System.out.println("Welcome to the Big Black Jack to start the game press 1 if you want to quit press 2");
        int in = sc.nextInt();
        while (in != 1 && in != 2) {
            System.out.println("Invalid input");
            in = sc.nextInt();
        }
        if (in == 1) {
            String i = deck.dealCard();
            System.out.println("Your card is " + i);
            hand.addCard(i);
        } else {
            System.exit(0);
        }
    }

    public void nextCard() {
        boolean contplay = true;
        while (contplay) {
            System.out.println("Please enter 1 if you want one more card, enter 2 if you want to finish and calculate your hand");
            int in1 = sc.nextInt();
            while (in1 != 1 && in1 != 2) {
                System.out.println("Invalid input, please enter 1 or 2.");
                in1 = sc.nextInt();
            }
            if (in1 == 1) {
                String newCard = deck.dealCard();
                System.out.println("Your card is " + newCard);
                hand.addCard(newCard);
            } else {
                hand.dispHand();
                hand.calc();
                int i = hand.calc();
                if (i > 21) {
                    System.out.println("Your score is " + i + " You bust");
                    System.exit(0);
                } else {
                    System.out.println("Your total is " + i);
                    playerTotal = i;
                    contplay = false;
                }
            }
        }
    }

    public void compare() {
        int dealerScore = dealer.dealerPlay();
        System.out.println("Dealer score is " + dealerScore);
        if (playerTotal > dealerScore) {
            System.out.println("Congratulations! You have won the game!");
        } else if (playerTotal == dealerScore) {
            System.out.println("Draw");
        } else {
            System.out.println("You lose!");
        }
    }
}