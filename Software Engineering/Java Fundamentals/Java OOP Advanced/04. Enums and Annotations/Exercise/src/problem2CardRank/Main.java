package problem2CardRank;

public class Main {

    public static void main(String[] args) {

        System.out.println("CardImpl Ranks:");
        for (CardRank cardRank : CardRank.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", cardRank.ordinal(), cardRank));
        }
    }
}
