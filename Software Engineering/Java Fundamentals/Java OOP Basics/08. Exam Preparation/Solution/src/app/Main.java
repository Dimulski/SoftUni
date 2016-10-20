package app;

import app.homes.Home;
import app.homes.HomeFactory;
import app.items.Toy;
import app.people.Child;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RoYaL on 7/6/2016.
 */


/**
 * 1. Class hierarchy segregation
 *  1.1. Inheritance
 *  1.2. Polymorphism
 * 2. Method's single responsibility
 * 3. Code blocks - into methods
 *  3.1. Methods to belong to relevant classes
 * 4. Encapsulation
 *  4.1. Access modifiers
 *  4.2. Properties
 * 5. No code duplication
 * 6. NO CASTS !
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );

        City kermen = new City();
        HomeFactory homeFactory = new HomeFactory();

        int count = 0;
        String line;

        while (!(line = reader.readLine()).equals("Democracy")) {
            count++;
            if (line.trim().equals("EVN")) {
                parseEVNCommand(kermen, count);
                continue;
            } else if (line.trim().equals("EVN bill")) {
                parseBillCommand(kermen, count);
                continue;
            }
            parseHomeCommand(kermen, homeFactory, count, line);
        }

        System.out.printf("Total population: %d%n", kermen.getPopulation());
    }

    private static void parseHomeCommand(City city, HomeFactory homeFactory, int count, String line) {
        String[] childParts = line.split(" Child");
        String command = childParts[0].substring(0, childParts[0].indexOf("("));
        Pattern pattern = Pattern.compile("[\\d.]+");
        Matcher matcher = pattern.matcher(childParts[0]);

        List<String> homeArgs = parseHomeArguments(command, matcher);
        List<Child> children = new ArrayList<>();
        parseChildren(childParts, pattern, children);

        Home home = homeFactory.createHome(homeArgs, children);
        city.addHome(home);

        tryPaySalaries(count, city);
    }

    private static List<String> parseHomeArguments(String command, Matcher matcher) {
        List<String> homeArgs = new ArrayList<>();
        homeArgs.add(command);

        while (matcher.find()) {
            homeArgs.add(matcher.group());
        }

        return homeArgs;
    }

    private static void parseChildren(String[] childParts, Pattern pattern, List<Child> children) {
        Matcher matcher;
        for (int i = 1; i < childParts.length; i++) {
            matcher = pattern.matcher(childParts[i]);
            matcher.find();
            double foodCost = Double.parseDouble(matcher.group());
            List<Toy> toys = new ArrayList<>();
            while (matcher.find()) {
                double toyCost = Double.parseDouble(matcher.group());
                Toy toy = new Toy(toyCost);
                toys.add(toy);
            }

            Child child = new Child(foodCost, toys);
            children.add(child);
        }
    }

    private static void parseBillCommand(City city, int count) {
        tryPaySalaries(count, city);
        city.payBills();
    }

    private static void parseEVNCommand(City city, int count) {
        tryPaySalaries(count, city);
        System.out.println("Total consumption: " + city.getConsumption());
    }

    private static void tryPaySalaries(int lineCount, City city) {
        if (lineCount % 3 == 0) {
            city.receiveSalaries();
        }
    }
}
