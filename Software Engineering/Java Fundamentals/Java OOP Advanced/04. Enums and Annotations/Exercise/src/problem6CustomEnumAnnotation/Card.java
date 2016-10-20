package problem6CustomEnumAnnotation;

interface Card extends Comparable<Card> {

    Integer getPower();

    CardRank getCardRank();

    CardSuit getCardSuit();
}
