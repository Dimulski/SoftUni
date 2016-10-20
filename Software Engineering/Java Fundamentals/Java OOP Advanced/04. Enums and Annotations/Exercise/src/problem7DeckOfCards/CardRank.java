package problem7DeckOfCards;

enum CardRank {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private Integer power;

    private CardRank(Integer power) {
        this.setPower(power);
    }

    Integer getPower() {
        return power;
    }

    private void setPower(Integer power) {
        this.power = power;
    }
}
