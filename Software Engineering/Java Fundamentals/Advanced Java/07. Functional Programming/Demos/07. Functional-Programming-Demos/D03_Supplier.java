import java.util.Random;
import java.util.function.Supplier;

public class D03_Supplier {
    public static void main(String[] args) {
        String[] players = new String[] {"Steve", "Andy", "George", "Lysa"};

        Supplier<Integer> dice = () -> new Random().nextInt(12);

        for (String player : players) {
            System.out.printf("%s rolled %d!%n", player, dice.get());
        }
    }
}
