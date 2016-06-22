import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Person {

    String name;
    int age;

    Person() {
        this.name = "No name";
        this.age = 1;
    }

    Person(int age) {
        this.name = "No name";
        this.age = age;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws IOException {

        Map<String, Integer> map = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] lineParams;
        for (int i = 0; i < n; i++) {
            lineParams = reader.readLine().split(" ");
            String name = lineParams[0];
            int age = Integer.parseInt(lineParams[1]);
            if (age > 30) {
                map.put(name, age);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.printf("%s - %s%s", entry.getKey(), entry.getValue(), System.lineSeparator());
        }
    }

}
