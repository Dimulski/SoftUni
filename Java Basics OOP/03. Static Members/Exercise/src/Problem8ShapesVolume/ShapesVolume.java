package Problem8ShapesVolume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapesVolume {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("End")) {
            String[] params = line.split(" ");
            String figure = params[0];
            switch (figure) {
                case "Cube":
                    System.out.println(String.format("%.3f", VolumeCalculator.cubeVolume(new Cube(Double.parseDouble(params[1])))));
                    break;
                case "Cylinder":
                    System.out.println(String.format("%.3f", VolumeCalculator.cylinderVolume(new Cylinder(Double.parseDouble(params[1]), Double.parseDouble(params[2])))));
                    break;
                case "TrianglePrism":
                    System.out.println(String.format("%.3f", VolumeCalculator.triangularPrismVolume(new TriangularPrism(Double.parseDouble(params[1]),
                            Double.parseDouble(params[2]), Double.parseDouble(params[3])))));
                    break;
            }
        }
    }
}

class VolumeCalculator {

    static Double triangularPrismVolume(TriangularPrism prism) {
        return (prism.heightFromBaseSide * 0.5) * prism.length * prism.baseSide;
    }

    static Double cubeVolume(Cube cube) {
        return cube.sideLength * cube.sideLength * cube.sideLength;
    }

    static Double cylinderVolume(Cylinder cylinder) {
        return Math.PI * cylinder.radius * cylinder.radius * cylinder.height;
    }
}

class TriangularPrism {
    Double baseSide;
    Double heightFromBaseSide;
    Double length;

    TriangularPrism(Double baseSide, Double heightFromBaseSide, Double length) {
        this.baseSide = baseSide;
        this.heightFromBaseSide = heightFromBaseSide;
        this.length = length;
    }
}

class Cube {
    Double sideLength;

    Cube(Double sideLength) {
        this.sideLength = sideLength;
    }
}

class Cylinder {
    Double radius;
    Double height;

    Cylinder(Double radius, Double height) {
        this.radius = radius;
        this.height = height;
    }
}
