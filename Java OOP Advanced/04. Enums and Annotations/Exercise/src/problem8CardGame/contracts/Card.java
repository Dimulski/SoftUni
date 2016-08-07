package problem8CardGame.contracts;

import problem8CardGame.enums.CardRank;
import problem8CardGame.enums.CardSuit;

public interface Card extends Comparable<Card> {

    Integer getPower();

    CardRank getCardRank();

    CardSuit getCardSuit();
}
