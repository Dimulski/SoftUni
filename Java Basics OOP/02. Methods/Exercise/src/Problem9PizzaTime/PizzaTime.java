package Problem9PizzaTime;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PizzaTime {

    public static void main(String[] args) throws IOException {

        Class<?> pizzaClass = PizzaDelivery.class;
        Method[] methods = pizzaClass.getDeclaredMethods();
        List<Method> checkedMethods = Arrays.stream(methods)
                .filter(m -> m.getReturnType().getName().contains("Map"))
                .collect(Collectors.toList());

        if (checkedMethods.size() < 1) {
            throw new ClassFormatException();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PizzaDelivery service = new PizzaDelivery();
        Map<Integer, List<Pizza>> pizzaOrders = service.groupPizzas(reader.readLine().split("\\s+"));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<Pizza>> entry : pizzaOrders.entrySet()) {
            sb.append(String.format("%d - %s%s", entry.getKey(),
                    String.join(", ", entry.getValue().stream().map(Pizza::getName)
                            .collect(Collectors.toList())), System.lineSeparator()));
        }
        System.out.println(sb);
    }
}

class PizzaDelivery {
    private Map<Integer, List<Pizza>> pizzaOrders;

    PizzaDelivery() {
        this.pizzaOrders = new TreeMap<>();
    }

    Map<Integer, List<Pizza>> groupPizzas(String... pizzaOrders) {
        Pattern pattern = Pattern.compile("(\\d+)(.+)");
        Matcher matcher;
        for (String pizza : pizzaOrders) {
            matcher = pattern.matcher(pizza);
            matcher.matches();
            Integer group = Integer.parseInt(matcher.group(1));
            String pizzaName = matcher.group(2);
            Pizza currentPizza = new Pizza(pizzaName, group); // let's not waste a decently good class here.
            if (!this.pizzaOrders.containsKey(currentPizza.getGroup())) {
                this.pizzaOrders.put(currentPizza.getGroup(), new LinkedList<>());
            }
            this.pizzaOrders.get(currentPizza.getGroup()).add(currentPizza);
        }
        return this.pizzaOrders;
    }
}

class Pizza {
    private String name;
    private Integer group;

    Pizza(String name, Integer group) {
        this.setName(name);
        this.setGroup(group);
    }

    public String getName() {
        return this.name;
    }

    public Integer getGroup() {
        return this.group;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setGroup(Integer group) {
        this.group = group;
    }

    String[] getInfo() {
        String[] info = new String[2];
        info[0] = this.name;
        info[1] = this.group.toString();
        return info;
    }
}
