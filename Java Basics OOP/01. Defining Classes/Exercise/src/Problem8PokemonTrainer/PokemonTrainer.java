package Problem8PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PokemonTrainer { // #firstTry

    public static void main(String[] args) throws IOException {

        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("Tournament")) {
            String[] lineParams = line.split(" ");
            String trainerName = lineParams[0];
            String pokemonName = lineParams[1];
            String element = lineParams[2];
            Integer health = Integer.parseInt(lineParams[3]);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer(trainerName, new ArrayList<>()));
            }
            trainers.get(trainerName).pocketMonsters.add(pokemon);
        }
        while(!(line = reader.readLine()).equals("End")) {
            for (Trainer trainer : trainers.values()) {
                boolean getsBadge = false;
                for (Pokemon pokemon : trainer.pocketMonsters) {
                    if (pokemon.element.equals(line)) {
                        getsBadge = true;
                        break;
                    }
                }
                if (getsBadge) {
                    trainer.numberOfBadges++;
                } else {
                    Stack<Pokemon> carcassStack = new Stack<>();
                    for (Pokemon pokemon : trainer.pocketMonsters) {
                        Integer health = pokemon.health;
                        if (health <= 10) {
                            pokemon.isDead = true;
                            carcassStack.push(pokemon);
                        } else {
                            pokemon.health -= 10;
                        }
                    }
                    while (!carcassStack.empty()) {
                        trainer.pocketMonsters.remove(carcassStack.pop());
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        trainers.values().stream().sorted((t1, t2) -> t2.numberOfBadges.compareTo(t1.numberOfBadges))
                .forEach(t -> sb.append(String.format("%s%s", t.toString(), System.lineSeparator())));
        System.out.println(sb);
    }

    static class Trainer {
        String name;
        Integer numberOfBadges;
        List<Pokemon> pocketMonsters;

        Trainer(String name, List<Pokemon> pocketMonsters) {
            this.name = name;
            this.numberOfBadges = 0;
            this.pocketMonsters = pocketMonsters;
        }

        public String toString() {
            return String.format("%s %d %d", name, numberOfBadges, pocketMonsters.size());
        }
    }

    static class Pokemon {
        String name;
        String element;
        Integer health;
        boolean isDead;

        Pokemon(String name, String element, Integer health) {
            this.name = name;
            this.element = element;
            this.health = health;
            this.isDead = false;
        }
    }
}
