package Part2BasicMapOperations.Problem8HandsOfCards;

import java.util.*;

/**
 * Created by User on 5.6.2016 г..
 */
public class HandsOfCards {

    public static void main(String[] args) {

        HashMap<Character, Integer> cardValues = new HashMap<Character, Integer>() {
            {
                put('2', 2);
                put('3', 3);
                put('4', 4);
                put('5', 5);
                put('6', 6);
                put('7', 7);
                put('8', 8);
                put('9', 9);
                put('T', 10);
                put('J', 11);
                put('Q', 12);
                put('K', 13);
                put('A', 14);
                put('S', 4);
                put('H', 3);
                put('D', 2);
                put('C', 1);
            }
        };

        LinkedHashMap<String, HashSet<String>> playersAndTheirDecks = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {

            String[] inputParams = input.split(":");
            String name = inputParams[0];
            String[] cards = inputParams[1].trim().replaceAll("10", "T").split("[, ]+");

            if (!playersAndTheirDecks.containsKey(name)){
                playersAndTheirDecks.put(name, new HashSet<>());
            }
            for (String card : cards) {
                playersAndTheirDecks.get(name).add(card);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, HashSet<String>> entry : playersAndTheirDecks.entrySet()) {
            int value = 0;
            for (String card : entry.getValue()) {
                Integer face = cardValues.get(card.charAt(0));
                Integer suit = cardValues.get(card.charAt(1));
                value += face * suit;
            }
            System.out.printf("%s: %d%n", entry.getKey(), value);
        }
    }
}
