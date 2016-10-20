package problem7DeckOfCards;

interface Card extends Comparable<Card> {

    Integer getPower();

    CardRank getCardRank();

    CardSuit getCardSuit();
}
