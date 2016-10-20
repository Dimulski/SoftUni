package Problem5PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PizzaCalories {

    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(System.in));
        String[] lineParams = reader.readLine().split("\\s+");
        try {
            while (!lineParams[0].equals("END")) {
                switch (lineParams[0]) {
                    case "Dough":
                        Dough dough = tryMakeDough(lineParams);
                        System.out.println(String.format("%.2f", dough.getCalories()));
                        break;
                    case "Topping":
                        Topping topping = tryMakeTopping(lineParams);
                        System.out.println(String.format("%.2f", topping.getCalories()));
                        break;
                    case "Pizza":
                        Pizza pizza = tryMakePizza(lineParams);
                        System.out.println(pizza);
                        break;
                }
                lineParams = reader.readLine().split("\\s+");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static Pizza tryMakePizza(String[] lineParams) throws IOException {

        String name = lineParams[1];
        Integer toppingsCount = Integer.valueOf(lineParams[2]);
        Pizza pizza = new Pizza(name, toppingsCount);

        String[] doughParams = reader.readLine().split("\\s+");
        Dough dough = tryMakeDough(doughParams);
        pizza.setDough(dough);

        for (int i = 0; i < toppingsCount; i++) {
            String[] toppingParams = reader.readLine().split("\\s+");
            Topping topping = tryMakeTopping(toppingParams);
            pizza.addTopping(topping);
        }

        return pizza;
    }

    private static Topping tryMakeTopping(String[] params) {
        String type = params[1];
        double weight = Double.valueOf(params[2]);

        return new Topping(type, weight);
    }

    private static Dough tryMakeDough(String[] params) {
        String flourType = params[1];
        String bakingTechnique = params[2];
        Double weight = Double.valueOf(params[3]);

        return new Dough(flourType, bakingTechnique, weight);
    }

    private static class Pizza {
        private static final Integer NAME_LOWER_LIMIT;
        private static final Integer NAME_UPPER_LIMIT;
        private static final Integer TOPPINGS_COUNT_LOWER_LIMIT;
        private static final Integer TOPPINGS_COUNT_UPPER_LIMIT;
        private String name;
        private Dough dough;
        private Integer toppingsCount;
        private List<Topping> toppings;

        static {
            NAME_LOWER_LIMIT = 1;
            NAME_UPPER_LIMIT = 15;
            TOPPINGS_COUNT_LOWER_LIMIT = 0;
            TOPPINGS_COUNT_UPPER_LIMIT = 10;
        }

        Pizza(String name, Integer toppingsCount) {
            this.setName(name);
            this.setToppingsCount(toppingsCount);
            this.setToppings();
        }

        void setDough(Dough dough) {
            this.dough = dough;
        }

        void addTopping(Topping topping) {
            this.toppings.add(topping);
        }

        Double getCalories() {
            Double result = getDough().getCalories();
            for (Topping topping : getToppings()) {
                result += topping.getCalories();
            }
            return result;
        }

        private void setName(String name) {
            if (name == null || name.length() < NAME_LOWER_LIMIT || name.length() > NAME_UPPER_LIMIT) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_PIZZA_NAME,
                        NAME_LOWER_LIMIT, NAME_UPPER_LIMIT));
            }

            this.name = name;
        }

        private void setToppingsCount(Integer toppingsCount) {
            if (toppingsCount < TOPPINGS_COUNT_LOWER_LIMIT || toppingsCount > TOPPINGS_COUNT_UPPER_LIMIT) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_TOPPINGS_COUNT,
                        TOPPINGS_COUNT_LOWER_LIMIT, TOPPINGS_COUNT_UPPER_LIMIT));
            }

            this.toppingsCount = toppingsCount;
        }

        private void setToppings() {
            this.toppings = new ArrayList<>(getToppingsCount());
        }

        private String getName() {
            return this.name;
        }

        private Dough getDough() {
            return this.dough;
        }

        private List<Topping> getToppings() {
            return this.toppings;
        }

        private Integer getToppingsCount() {
            return this.toppingsCount;
        }

        @Override
        public String toString() {
            return String.format("%s - %.2f Calories.", getName(), getCalories());
        }
    }

    private static class Dough {
        private static final Double WEIGHT_LOWER_LIMIT;
        private static final Double WEIGHT_UPPER_LIMIT;
        private static final Double caloriesPerGramBase;
        private static List<String> allowedFlourTypes;
        private static List<String> allowedBakingTechniques;
        private String flourType;
        private String bakingTechnique;
        private Double weight;

        static {
            WEIGHT_LOWER_LIMIT = 1d;
            WEIGHT_UPPER_LIMIT = 200d;
            caloriesPerGramBase = 2d;

            allowedFlourTypes = new ArrayList<String>() {{
                add("White");
                add("Wholegrain");
            }};

            allowedBakingTechniques = new ArrayList<String>() {{
                add("Crispy");
                add("Chewy");
                add("Homemade");
            }};
        }

        Dough(String flourType, String bakingTechnique, Double weight) {
            this.setFloutType(flourType);
            this.setBakingTechnique(bakingTechnique);
            this.setWeight(weight);
        }

        Double getCalories() {
            return (caloriesPerGramBase * getWeight()) * getFlourTypeModifier() * getBakingTechniqueModifier();
        }

        private String getFlourType() {
            return this.flourType;
        }

        private String getBakingTechnique() {
            return this.bakingTechnique;
        }

        private Double getWeight() {
            return this.weight;
        }

        private Double getFlourTypeModifier() {
            switch (getFlourType().toLowerCase()) {
                case "white":
                    return 1.5;
                case "wholegrain":
                    return 1.0; // idk
                default:
                    return 1d;
            }
        }

        private Double getBakingTechniqueModifier() {
            switch (getBakingTechnique().toLowerCase()) {
                case "crispy":
                    return 0.9;
                case "chewy":
                    return 1.1;
                case "homemade":
                    return 1.0;
                default:
                    return 1d;
            }
        }

        private void setFloutType(String flourType) {
            if (allowedFlourTypes.stream().noneMatch(s -> s.equalsIgnoreCase(flourType))) {
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FLOUR_TYPE);
            }

            this.flourType = flourType;
        }

        private void setBakingTechnique(String bakingTechnique) {
            if (allowedBakingTechniques.stream().noneMatch(s -> s.equalsIgnoreCase(bakingTechnique))) {
                throw new IllegalArgumentException(ExceptionMessages.INVALID_BAKING_TECHNIQUE);
            }

            this.bakingTechnique = bakingTechnique;
        }

        private void setWeight(Double weight) {
            if (weight < WEIGHT_LOWER_LIMIT || weight > WEIGHT_UPPER_LIMIT) {
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DOUGH_WEIGHT);
            }

            this.weight = weight;
        }
    }

    private static class Topping {
        private static final Double WEIGHT_LOWER_LIMIT;
        private static final Double WEIGHT_UPPER_LIMIT;
        private static final Double caloriesPerGramBase;
        private static List<String> allowedTypes;
        private String type;
        private Double weight;

        static {
            WEIGHT_LOWER_LIMIT = 1d;
            WEIGHT_UPPER_LIMIT = 50d;
            caloriesPerGramBase = 2d;

            allowedTypes = new ArrayList<String>() {{
                add("Meat");
                add("Veggies");
                add("Cheese");
                add("Sauce");
            }};
        }

        Topping(String type, Double weight) {
            this.setType(type);
            this.setWeight(weight);
        }

        Double getCalories() {
            return (caloriesPerGramBase * getWeight()) * getTypeModifier();
        }

        private String getType() {
            return this.type;
        }

        private Double getWeight() {
            return this.weight;
        }

        private Double getTypeModifier() {
            switch (getType().toLowerCase()) {
                case "meat":
                    return 1.2;
                case "veggies":
                    return 0.8;
                case "cheese":
                    return 1.1;
                case "sauce":
                    return 0.9;
                default:
                    return 1d;
            }
        }

        private void setType(String type) {
            if (allowedTypes.stream().noneMatch(s -> s.equalsIgnoreCase(type))) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_TOPPING_TYPE, type));
            }

            this.type = type;
        }

        private void setWeight(Double weight) {
            if (weight < WEIGHT_LOWER_LIMIT || weight > WEIGHT_UPPER_LIMIT) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_TOPPING_WEIGHT, getType()));
            }

            this.weight = weight;
        }
    }

    private class ExceptionMessages {

        static final String INVALID_FLOUR_TYPE = "Invalid type of dough.";
        static final String INVALID_BAKING_TECHNIQUE = "Invalid type of dough.";
        static final String INVALID_DOUGH_WEIGHT = "Dough weight should be in the range [1..200].";
        static final String INVALID_TOPPING_TYPE = "Cannot place %s on top of your pizza.";
        static final String INVALID_TOPPING_WEIGHT = "%s weight should be in the range [1..50].";
        static final String INVALID_PIZZA_NAME = "Pizza name should be between %d and %d symbols.";
        static final String INVALID_TOPPINGS_COUNT = "Number of toppings should be in range [%d..%d].";
    }
}
