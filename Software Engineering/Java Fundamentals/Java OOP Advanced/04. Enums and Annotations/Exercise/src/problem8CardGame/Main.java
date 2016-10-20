package problem8CardGame;

import problem8CardGame.contracts.Card;
import problem8CardGame.contracts.Player;
import problem8CardGame.enums.CardRank;
import problem8CardGame.enums.CardSuit;
import problem8CardGame.models.CardImpl;
import problem8CardGame.models.PlayerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Card> deck = getNewDeck();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player firstPlayer = new PlayerImpl(reader.readLine(), new ArrayList<Card>());
        Player secondPlayer = new PlayerImpl(reader.readLine(), new ArrayList<Card>());

        Card currentCard;
        while (firstPlayer.getHand().size() < 5) {
            currentCard = drawCardFromDeck(reader.readLine().split("\\s+"), deck);
            if (currentCard != null) {
                firstPlayer.getHand().add(currentCard);
            }
        }
        while (secondPlayer.getHand().size() < 5) {
            currentCard = drawCardFromDeck(reader.readLine().split("\\s+"), deck);
            if (currentCard != null) {
                secondPlayer.getHand().add(currentCard);
            }
        }

        printWinnerAndWinningCard(firstPlayer, secondPlayer);
    }

    private static void printWinnerAndWinningCard(Player firstPlayer, Player secondPlayer) {
        Card greatestCard = new CardImpl(CardRank.TWO, CardSuit.CLUBS);

        for (Card card : firstPlayer.getHand()) {
            if (card.getPower() > greatestCard.getPower()) {
                greatestCard = card;
            }
        }

        for (Card card : secondPlayer.getHand()) {
            if (card.getPower() > greatestCard.getPower()) {
                greatestCard = card;
            }
        }

        if (firstPlayer.getHand().contains(greatestCard)) {
            System.out.println(String.format("%s wins with %s.", firstPlayer.getName(), greatestCard));
        } else {
            System.out.println(String.format("%s wins with %s.", secondPlayer.getName(), greatestCard));
        }
    }


    private static Card drawCardFromDeck(String[] cardParams, List<Card> deck) {
        CardRank cardRank;
        CardSuit cardSuit;
        try {
            cardRank = CardRank.valueOf(cardParams[0]);
            cardSuit = CardSuit.valueOf(cardParams[2]);
        } catch (IllegalArgumentException e) {
            System.out.println("No such card exists.");
            return null;
        }
        Card card = new CardImpl(cardRank, cardSuit);
        boolean wasInDeck = deck.remove(card); // CardImpl needs to override Object.equals()
        if (!wasInDeck) {
            System.out.println("Card is not in the deck.");
            return null;
        }
        return card;
    }

    private static List<Card> getNewDeck() {
        List<Card> deck = new ArrayList<>();
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                Card card = new CardImpl(cardRank, cardSuit);
                deck.add(card);
            }
        }
        return deck;
    }
}
