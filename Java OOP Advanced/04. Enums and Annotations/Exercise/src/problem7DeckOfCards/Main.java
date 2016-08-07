package problem7DeckOfCards;

public class Main {

    public static void main(String[] args) {

        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                Card card = new CardImpl(cardRank, cardSuit);
                System.out.println(card);
            }
        }
    }
}
