package problem9TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<TrafficLight> trafficLights = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] startingLights = reader.readLine().split("\\s+");
        for (String startingLight : startingLights) {
            TrafficLight trafficLight = new TrafficLightImpl(Light.valueOf(startingLight));
            trafficLights.add(trafficLight);
        }
        Integer n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeLight();
                System.out.print(String.format("%s ", trafficLight.getLight()));
            }
            System.out.println();
        }
    }
}
