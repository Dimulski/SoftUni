package Problem7CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarSalesman { // #firstTry

    public static void main(String[] args) throws IOException {

        LinkedList<Car> cars = new LinkedList<>();
        HashMap<String, Engine> engines = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] lineParams = reader.readLine().split(" ");
            String engineModel = lineParams[0];
            Integer power = Integer.parseInt(lineParams[1]);
            Integer displacement = null;
            String efficiency = null;

            if (lineParams.length == 3) {
                Pattern pattern = Pattern.compile("^\\d+$");
                Matcher matcher = pattern.matcher(lineParams[2]);
                if (matcher.find()) {
                    displacement = Integer.parseInt(lineParams[2]);
                } else {
                    efficiency = lineParams[2];
                }
            } else if (lineParams.length == 4) {
                displacement = Integer.parseInt(lineParams[2]);
                efficiency = lineParams[3];
            }
            Engine engine = new Engine(engineModel, power, displacement, efficiency);
            engines.put(engineModel, engine);
        }
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] lineParams = reader.readLine().split(" ");
            String carModel = lineParams[0];
            String engineModel = lineParams[1];
            Integer weight = null;
            String color = null;
            if (lineParams.length == 3) {
                Pattern pattern = Pattern.compile("^\\d+$");
                Matcher matcher = pattern.matcher(lineParams[2]);
                if (matcher.find()) {
                    weight = Integer.parseInt(lineParams[2]);
                } else {
                    color = lineParams[2];
                }
            } else if (lineParams.length == 4) {
                weight = Integer.parseInt(lineParams[2]);
                color = lineParams[3];
            }
            Car car = new Car(carModel, engines.get(engineModel), weight, color);
            cars.add(car);
        }
        StringBuilder sb = new StringBuilder();
        cars.stream().forEach(car -> sb.append(car.toString()));
        System.out.println(sb);
    }

    static class Car {
        String model;
        Engine engine;
        Integer weight;
        String color;

        Car(String model, Engine engine, Integer weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s:%s", this.model, System.lineSeparator()));
            sb.append(String.format("  %s:%s", this.engine.model, System.lineSeparator()));
            sb.append(String.format("    Power: %d%s", this.engine.power, System.lineSeparator()));
            if (this.engine.displacement == null) {
                sb.append(String.format("    Displacement: n/a%s", System.lineSeparator()));
            } else {
                sb.append(String.format("    Displacement: %d%s", this.engine.displacement, System.lineSeparator()));
            }
            if (this.engine.efficiency == null) {
                sb.append(String.format("    Efficiency: n/a%s", System.lineSeparator()));
            } else {
                sb.append(String.format("    Efficiency: %s%s", this.engine.efficiency, System.lineSeparator()));
            }
            if (this.weight == null) {
                sb.append(String.format("  Weight: n/a%s", System.lineSeparator()));
            } else {
                sb.append(String.format("  Weight: %d%s", this.weight, System.lineSeparator()));
            }
            if (this.color == null) {
                sb.append(String.format("  Color: n/a%s", System.lineSeparator()));
            } else {
                sb.append(String.format("  Color: %s%s", this.color, System.lineSeparator()));
            }

            return sb.toString();
        }

    }

    static class Engine {
        String model;
        Integer power;
        Integer displacement;
        String efficiency;

        Engine(String model, Integer power, Integer displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }
    }
}
