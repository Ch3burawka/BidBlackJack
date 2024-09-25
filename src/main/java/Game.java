import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    Deck deck;
    Hand hand = new Hand();
    Dealer dealer;
    public int playerTotal;

    public Game(Deck deck) {
        this.deck = deck;
        this.dealer = new Dealer(deck);
    }

    public void play() {
        System.out.println("Welcome to the Big Black Jack to start the game press 1 if you want to quit press 2");
        int in = -1;
        while (true) {
            try {
                in = sc.nextInt();
                if (in == 1 || in == 2) {
                    break;
                } else {
                    System.out.println("Invalid input, try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again");
                sc.nextLine();
            }
        }
        if (in == 1) {
            String card = deck.dealCard();
            System.out.println("Your card is: " + card);
            hand.addCard(card);
        }
        else{
            System.exit(0);
        }
    }

    public void nextCard() {
        boolean contplay = true;
        while (contplay) {
            System.out.println("Please enter 1 if you want one more card, enter 2 if you want to finish and calculate your hand");
            int in1 = -1;
            while (true) {
                try {
                    in1 = sc.nextInt();
                    if (in1 != 1 && in1 != 2) {
                        System.out.println("Invalid input, enter 1 or 2");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, enter 1 or 2");
                    sc.nextLine();
                }
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
                    return;
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

    public boolean nextGame() {
        System.out.println("If you want play again press 1 or press 2 if you want to quit");
        int in = -1;
        while (true) {
            try {
                in = sc.nextInt();
                if (in == 1 || in == 2) {
                    break;
                } else {
                    System.out.println("Invalid input, please enter 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter 1 or 2.");
                sc.nextLine();
            }
        }
        return in == 1;
    }
}
