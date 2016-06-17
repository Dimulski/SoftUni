import java.util.Arrays;
import java.util.List;

public class D01_LambdaExpressions {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 2, 1, 3, 5, 7, 1, 4 , 2, 12);


        numbers.stream().filter(number -> number % 2 == 0).sorted((x, y) -> x.compareTo(y)).forEach(System.out::println);
    }
}
