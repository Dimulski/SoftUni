package Problem4BeerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeerCounter {

    static Integer beersBought = 0;
    static Integer beersDrunk = 0;
    static Integer currentAmount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("End")) {
            String[] lineParams = line.split(" ");
            Integer beersToBuy = Integer.parseInt(lineParams[0]);
            Integer beersToDrink = Integer.parseInt(lineParams[1]);
            buyBeers(beersToBuy);
            drinkBeers(beersToDrink);
        }
        System.out.println(beersLeft() + " " + beersDrunk);
    }

    static void drinkBeers(Integer amount) {
        if (currentAmount >= amount) {
            beersDrunk += amount;
            currentAmount -= amount;
        }
    }

    static void buyBeers(Integer amount) {
        currentAmount += amount;
        beersBought += amount;
    }

    static Integer beersLeft() {
        return currentAmount;
    }
}
