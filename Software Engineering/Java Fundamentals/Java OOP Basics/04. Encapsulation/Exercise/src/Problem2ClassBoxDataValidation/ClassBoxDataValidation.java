package Problem2ClassBoxDataValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassBoxDataValidation {

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
        Box box;
        try {
            box = new Box(length, width, height);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        box.printSurfaceArea();
        box.printLateralSurfaceArea();
        box.printVolume();
    }

    private static class Box {
        private Double length;
        private Double width;
        private Double height;

        Box(Double length, Double width, Double height) {
            this.setLength(length);
            this.setWidth(width);
            this.setHeight(height);
        }

        Double getSurfaceArea() {
            return 2 * getLength() * getWidth() + 2 * getLength() * getHeight() + 2 * getWidth() * getHeight();
        }

        Double getLateralSurfaceArea() {
            return 2 * getLength() * getHeight() + 2 * getWidth() * getHeight();
        }

        Double getVolume() {
            return getLength() * getWidth() * getHeight();
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

        Double getLength() {
            return this.length;
        }

        Double getWidth() {
            return this.width;
        }

        Double getHeight() {
            return this.height;
        }

        private void setLength(Double length) {
            if (length <= 0) {
                throw new IllegalArgumentException("Length cannot be zero or negative.");
            }

            this.length = length;
        }

        private void setWidth(Double width) {
            if (width <= 0) {
                throw new IllegalArgumentException("Width cannot be zero or negative.");
            }

            this.width = width;
        }

        private void setHeight(Double height) {
            if (height <= 0) {
                throw new IllegalArgumentException("Height cannot be zero or negative.");
            }

            this.height = height;
        }
    }
}
