package Problem1ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassBox {

    public static void main(String[] args) throws IOException {

        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields)
                .stream()
                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());
        Box box = new Box(length, width, height);
        box.printSurfaceArea();
        box.printLateralSurfaceArea();
        box.printVolume();
    }

    private static class Box {
        private Double length;
        private Double width;
        private Double height;

        Box(Double length, Double width, Double height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }

        Double getSurfaceArea() {
            return 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
        }

        Double getLateralSurfaceArea() {
            return 2 * this.length * this.height + 2 * this.width * this.height;
        }

        Double getVolume() {
            return this.length * this.width * this.height;
        }

        void printSurfaceArea() {
            System.out.println(String.format("Surface Area - %.2f", this.getSurfaceArea()));
        }

        void printLateralSurfaceArea() {
            System.out.println(String.format("Lateral Surface Area - %.2f", this.getLateralSurfaceArea()));
        }

        void printVolume() {
            System.out.println(String.format("Volume - %.2f", this.getVolume()));
        }
    }
}
