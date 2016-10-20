import java.util.function.Function;
import java.util.function.Predicate;

public class D06_PassFunctionsToMethods1 {
    public static void main(String[] args) {
        int a = 5;
        int b = operation(a, x -> x + 1);
        System.out.println(b);

        int c = operation(b, x -> x * x);
        System.out.println(c);
    }

    public static int operation(int number, Function<Integer, Integer> function) {
        return function.apply(number);
    }
}
