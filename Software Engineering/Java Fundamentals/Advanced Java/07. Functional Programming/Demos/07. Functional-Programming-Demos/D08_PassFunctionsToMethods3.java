import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class D08_PassFunctionsToMethods3 {
    public static void main(String[] args) {
        HashMap<String, Integer> people = new HashMap<>();
        people.put("Pesho", 20);
        people.put("Gosho", 18);
        people.put("Mimi", 29);
        people.put("Ico", 31);
        people.put("Simo", 16);

        String condition = "older";
        String format = "name age";
        Integer age = 20;

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        printFilteredStudent(people, tester, printer);
    }

    private static Consumer<Map.Entry<String,Integer>> createPrinter(String format) {
        switch (format) {
            case "name":
                return person -> System.out.printf("%s%n", person.getKey());
            case "age":
                return person -> System.out.printf("%d%n", person.getValue());
            case "name age":
                return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
            default:
                return null;
        }
    }

    private static Predicate<Integer> createTester(String condition, Integer age) {
        switch (condition) {
            case "younger":
                return x -> x <= age;
            case "older":
                return x -> x >= age;
            default:
                return null;
        }
    }

    public static void printFilteredStudent(
            HashMap<String, Integer> people,
            Predicate<Integer> tester,
            Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }
}
