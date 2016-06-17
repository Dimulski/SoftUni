import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class D04_Predicate {
    public static void main(String[] args) {
        String[] words = new String[]{"stone", "rocket", "mallet", "skull"};

        BiPredicate<String, String> endsWith = (word, suffix) -> word.endsWith(suffix);

        for (String word : words) {
            if (endsWith.test(word, "let")) {
                System.out.println(word);
            }
        }
    }
}
