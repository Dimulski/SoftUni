package Problem11RectangleIntersection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RectangleIntersection {

    public static void main(String[] args) throws IOException {

        Map<String, Rectangle> rectangles = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLineParams = reader.readLine().split(" ");
        for (int i = 0; i < Integer.parseInt(firstLineParams[0]); i++) {
            String[] rectangleParams = reader.readLine().split(" ");
            Rectangle rectangle = new Rectangle(
                    rectangleParams[0],
                    Double.parseDouble(rectangleParams[1]),
                    Double.parseDouble(rectangleParams[2]),
                    Double.parseDouble(rectangleParams[3]),
                    Double.parseDouble(rectangleParams[4]));
            rectangles.put(rectangleParams[0], rectangle);
        }
        for (int i = 0; i < Integer.parseInt(firstLineParams[1]); i++) {
            String[] rectangleIds = reader.readLine().split(" ");
            System.out.println(rectangles.get(rectangleIds[0]).intersectsWith(rectangles.get(rectangleIds[1])));
        }
    }
}

class Rectangle {
    String id;
    Double width;
    Double height;
    Double startingRow;
    Double startingCol;

    Rectangle(String id, Double width, Double height, Double startingCol, Double startingRow) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.startingCol = startingCol;
        this.startingRow = startingRow;
    }

    boolean intersectsWith(Rectangle rectangle) {
        if (this.startingCol + this.width < rectangle.startingCol || rectangle.startingCol + rectangle.width < this.startingCol ||
                this.startingRow + this.height < rectangle.startingRow || rectangle.startingRow + rectangle.height < this.startingRow) {
            return false;
        } else {
            return true;
        }
    }
}
