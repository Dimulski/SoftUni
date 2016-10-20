package Problem11CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CatLady {

    public static void main(String[] args) throws IOException {

        Map<String, Cat> cats = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("End")) {
            String[] lineParams = line.split(" ");
            String breed = lineParams[0];
            String name = lineParams[1];
            if (breed.equals("Siamese")) {
                Integer earSize = Integer.parseInt(lineParams[2]);
                Cat cat = new Siamese(name, earSize);
                cats.put(name, cat);
            } else if (breed.equals("Cymric")) {
                Double furLength = Double.parseDouble(lineParams[2]);
                Cat cat = new Cymric(name, furLength);
                cats.put(name, cat);
            } else if (breed.equals("StreetExtraordinaire")) {
                Integer decibelsOfMeows = Integer.parseInt(lineParams[2]);
                Cat cat = new StreetExtraordinaire(name, decibelsOfMeows);
                cats.put(name, cat);
            }
        }
        String targetCat = reader.readLine();
        System.out.println(cats.get(targetCat));
    }

    static class Cat {
        String breed;
        String name;

        public String toString() {
            return String.format("%s %s ", breed, name);
        }
    }

    static class Siamese extends Cat {
        Integer earSize;

        Siamese(String name, Integer earSize) {
            this.breed = "Siamese";
            this.name = name;
            this.earSize = earSize;
        }

        public String toString() {
            return super.toString() + earSize.toString();
        }
    }

    static class Cymric extends Cat {
        Double furLength;

        Cymric(String name, Double furLength) {
            this.breed = "Cymric";
            this.name = name;
            this.furLength = furLength;
        }

        public String toString() {
            return super.toString() + String.format("%.2f", furLength); // This wasn't in the description...gj
        }
    }

    static class StreetExtraordinaire extends Cat {
        Integer decibelsOfMeows;

        StreetExtraordinaire(String name, Integer decibelsOfMeows) {
            this.breed = "StreetExtraordinaire";
            this.name = name;
            this.decibelsOfMeows = decibelsOfMeows;
        }

        public String toString() {
            return super.toString() + decibelsOfMeows.toString();
        }
    }
}
