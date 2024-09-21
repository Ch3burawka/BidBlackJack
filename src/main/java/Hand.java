import java.util.ArrayList;

public class Hand {
    public ArrayList<String> hand;
    public Hand() {
        this.hand = new ArrayList<>();
    }
    public void addCard(String card) {
        hand.add(String.valueOf(card));
    }
        public int calc() {
            int total = 0;
            int aces = 0;
            for (String card : hand) {
                String rank = card.split(" ")[0];
                if (rank.matches("[2-9]|10")) {
                    total += Integer.parseInt(rank);
                }
                else if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
                    total += 10;}
                    else if (rank.equals("Ace")) {
                        aces++;
                        total += 11;}
            while (total > 21 && aces > 0){
            total -= 10;
            aces--;
            }
            }
            return total;
        }
        public void disphand(){
        System.out.println("Your hand " + hand);
        }
}

