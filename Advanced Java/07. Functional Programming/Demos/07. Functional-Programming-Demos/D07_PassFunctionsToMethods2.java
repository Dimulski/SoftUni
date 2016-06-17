import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class D07_PassFunctionsToMethods2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(2, 5, -4, -1, 54, 4));

        List<Integer> evenNums = filter(list, num -> num % 2 == 0);

        System.out.println(evenNums);
    }

    private static List<Integer> filter(List<Integer> list, Function<Integer, Boolean> filter) {
        List<Integer> result = new ArrayList<Integer>();

        for (Integer number : list) {
            if (filter.apply(number)) {
                result.add(number);
            }
        }

        return result;
    }
}
