package problem7DeckOfCards;

class CardImpl implements Card {

    private CardRank cardRank;
    private CardSuit cardSuit;

    CardImpl(CardRank cardRank, CardSuit cardSuit) {
        this.setCardRank(cardRank);
        this.setCardSuit(cardSuit);
    }

    private void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    private void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    @Override
    public Integer getPower() {
        return getCardRank().getPower() + getCardSuit().getPower();
    }

    @Override
    public CardRank getCardRank() {
        return this.cardRank;
    }

    @Override
    public CardSuit getCardSuit() {
        return this.cardSuit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.getCardRank(), this.getCardSuit());
    }

    @Override
    public int compareTo(Card otherCard) {
        return this.getPower().compareTo(otherCard.getPower());
    }
}
