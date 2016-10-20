package Problem4ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingSpree {

    public static void main(String[] args) throws IOException {

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        HashMap<String, Product> products = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] peopleParams = reader.readLine().split(";");
        for (String personParams : peopleParams) {
            String[] params = personParams.split("=");
            Person person;
            try {
                person = new Person(params[0], Double.parseDouble(params[1]));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            people.put(person.getName(), person);
        }
        String[] productsParams = reader.readLine().split(";");
        for (String productParams : productsParams) {
            String[] params = productParams.split("=");
            Product product;
            try {
                product = new Product(params[0], Double.parseDouble(params[1]));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            products.put(product.getName(), product);
        }
        String line;
        while (!(line = reader.readLine()).equals("END")) {
            String[] lineParams = line.split(" ");
            Person person = people.get(lineParams[0]);
            Product product = products.get(lineParams[1]);

            boolean bought = person.tryBuyProduct(product);
            if (bought){
                System.out.printf("%s bought %s%n", person.getName(), product.getName());
            } else {
                System.out.printf("%s can't afford %s%n", person.getName(), product.getName());
            }
        }

        people.values().forEach(System.out::println);
    }

    private static class Person {
        private String name;
        private Double money;
        private List<Product> productsBought;

        Person(String name, Double money) {
            this.setName(name);
            this.setMoney(money);
            this.setProductsBought();
        }

        String getName() {
            return this.name;
        }

        Double getMoney() {
            return this.money;
        }

        List<Product> getProductsBought() {
            return this.productsBought;
        }

        private void setName(String name) {
            if (name == null || name.trim().length() == 0){
                throw new IllegalArgumentException("Name cannot be empty");
            }
            this.name = name;
        }

        private void setMoney(Double money) {
            if (money < 0){
                throw new IllegalArgumentException("Money cannot be negative");
            }
            this.money = money;
        }

        private void setProductsBought() {
            this.productsBought = new LinkedList<>();
        }

        private void addProduct(Product product) {
            this.productsBought.add(product);
        }

        boolean tryBuyProduct(Product product){
            if (product.getCost() > getMoney()){
                return false;
            }

            this.setMoney(getMoney() - product.getCost());
            this.addProduct(product);
            return true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s - ", getName()));
            if (this.getProductsBought().size() != 0){
                sb.append(this.getProductsBought().stream().map(Object::toString).collect(Collectors.joining(", ")));
            } else {
                sb.append("Nothing bought");
            }

            return sb.toString();
        }
    }

    private static class Product {
        private String name;
        private Double cost;

        Product(String name, Double cost) {
            this.setName(name);
            this.setCost(cost);
        }

        String getName() {
            return this.name;
        }

        Double getCost() {
            return this.cost;
        }

        private void setName(String name) {
            if (name == null || name.trim().length() == 0) {
                throw new IllegalArgumentException("Name cannot be empty");
            }

            this.name = name;
        }

        private void setCost(Double cost) {
            if (cost < 0) {
                throw new IllegalArgumentException("Money cannot be negative");
            }

            this.cost = cost;
        }

        @Override
        public String toString() {
            return getName();
        }
    }
}

