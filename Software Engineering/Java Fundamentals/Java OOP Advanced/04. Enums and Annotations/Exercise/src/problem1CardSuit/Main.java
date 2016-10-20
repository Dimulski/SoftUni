package problem1CardSuit;

public class Main {

    public static void main(String[] args) {

        System.out.println("CardImpl Suits:");
        for (CardSuit cardSuit : CardSuit.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", cardSuit.ordinal(), cardSuit));
        }
    }
}
