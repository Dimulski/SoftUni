package problem5CardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CardRank firstCardRank = CardRank.valueOf(reader.readLine());
        CardSuit firstCardSuit = CardSuit.valueOf(reader.readLine());
        CardRank secondCardRank = CardRank.valueOf(reader.readLine());
        CardSuit secondCardSuit = CardSuit.valueOf(reader.readLine());
        Card firstCard = new CardImpl(firstCardRank, firstCardSuit);
        Card secondCard = new CardImpl(secondCardRank, secondCardSuit);
        System.out.println(greaterCard(firstCard, secondCard));
    }

    private static Card greaterCard(Card firstCard, Card secondCard) { // Note: This returns the second card if the two are equal
        if (firstCard.compareTo(secondCard) > 0) {
            return firstCard;
        }
        return secondCard;
    }
}
