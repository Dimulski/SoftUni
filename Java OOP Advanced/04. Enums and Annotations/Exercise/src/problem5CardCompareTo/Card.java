package problem5CardCompareTo;

interface Card extends Comparable<Card> {

    Integer getPower();

    CardRank getCardRank();

    CardSuit getCardSuit();
}
