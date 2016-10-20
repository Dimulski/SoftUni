package Problem7FoodShortage;

import Problem7FoodShortage.contracts.Buyer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Map<String, Buyer> buyers = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inhabitantParams = reader.readLine().split("\\s+");
            switch (inhabitantParams.length) {
                case 3:
                    Buyer rebel = new RebelImpl(inhabitantParams[0],
                            Integer.parseInt(inhabitantParams[1]),
                            inhabitantParams[2]);
                    buyers.put(inhabitantParams[0], rebel);
                    break;
                case 4:
                    Buyer citizen = new CitizenImpl(inhabitantParams[0],
                            Integer.parseInt(inhabitantParams[1]),
                            inhabitantParams[2],
                            inhabitantParams[3]);
                    buyers.put(inhabitantParams[0], citizen);
                    break;
            }
        }
        String buyerName;
        while (!(buyerName = reader.readLine()).equals("End")) {
            if (buyers.containsKey(buyerName)) {
                buyers.get(buyerName).buyFood();
            }
        }
        Integer totalFood = 0;
        totalFood = buyers.values().stream().mapToInt(Buyer::getFoodAmount).sum();
        System.out.println(totalFood);
    }
}
