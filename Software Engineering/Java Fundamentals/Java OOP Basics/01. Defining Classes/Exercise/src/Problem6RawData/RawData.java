package Problem6RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class RawData { // #firstTry

    public static void main(String[] args) throws IOException {

        LinkedList<Car> cars = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] lineParams = reader.readLine().split(" ");
            Car car = Car.createCar(lineParams);
            cars.add(car);
        }
        String type = reader.readLine();
        StringBuilder sb = new StringBuilder();
        switch (type) {
            case "fragile":
                for (Car car: cars) {
                    if (car.cargo.type.equals("fragile") && (car.tires.stream().anyMatch(t -> t.pressure < 1))) {
                        sb.append(String.format("%s%s", car.model, System.lineSeparator()));
                    }
                }
                break;
            case "flamable": // gj
                for (Car car : cars) {
                    if (car.cargo.type.equals("flamable") && (car.engine.power > 250)) {
                        sb.append(String.format("%s%s", car.model, System.lineSeparator()));
                    }
                }

        }
        System.out.println(sb);
    }
}

class Car {
    String model;
    Engine engine;
    Cargo cargo;
    List<Tire> tires;

    Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public static Car createCar(String[] lineParams) {
        String model = lineParams[0];
        Integer engineSpeed = Integer.parseInt(lineParams[1]);
        Integer enginePower = Integer.parseInt(lineParams[2]);
        Integer cargoWeight = Integer.parseInt(lineParams[3]);
        String cargoType = lineParams[4];
        Double tire1Pressure = Double.parseDouble(lineParams[5]);
        Integer tire1Age = Integer.parseInt(lineParams[6]);
        Double tire2Pressure = Double.parseDouble(lineParams[7]);
        Integer tire2Age = Integer.parseInt(lineParams[8]);
        Double tire3Pressure = Double.parseDouble(lineParams[9]);
        Integer tire3Age = Integer.parseInt(lineParams[10]);
        Double tire4Pressure = Double.parseDouble(lineParams[11]);
        Integer tire4Age = Integer.parseInt(lineParams[12]);

        Engine engine = new Engine(engineSpeed, enginePower);
        Cargo cargo = new Cargo(cargoWeight, cargoType);
        List<Tire> tires = new LinkedList<>();
        Tire tire1 = new Tire(tire1Age, tire1Pressure);
        Tire tire2 = new Tire(tire2Age, tire2Pressure);
        Tire tire3 = new Tire(tire3Age, tire3Pressure);
        Tire tire4 = new Tire(tire4Age, tire4Pressure);
        tires.add(tire1);
        tires.add(tire2);
        tires.add(tire3);
        tires.add(tire4);

        return new Car(model, engine, cargo, tires);
    }
}

class Engine {
    Integer speed;
    Integer power;

    Engine(Integer speed, Integer power) {
        this.speed = speed;
        this.power = power;
    }
}

class Cargo {
    Integer weight;
    String type;

    Cargo(Integer weight, String type) {
        this.weight = weight;
        this.type = type;
    }
}

class Tire {
    Integer age;
    Double pressure;

    Tire(Integer age, Double pressure) {
        this.age = age;
        this.pressure = pressure;
    }
}
