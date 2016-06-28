package Problem13DrawingTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrawingTool {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String figure = reader.readLine();
        CorDraw corDraw = null;
        switch (figure) {
            case "Square":
                Integer length = Integer.parseInt(reader.readLine());
                corDraw = new Square(length);
                break;
            case "Rectangle":
                Integer width = Integer.parseInt(reader.readLine());
                Integer height = Integer.parseInt(reader.readLine());
                corDraw = new Rectangle(width, height);
                break;
        }
        corDraw.draw();
    }
}

interface CorDraw {
    void draw();
}

class Square implements CorDraw {
    Integer length;

    Square(Integer length) {
        this.length = length;
    }

    @Override
    public void draw() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("|");
            for (int j = 0; j < length; j++) {
                if (i == 0 || i == length - 1) {
                    sb.append("-");
                } else {
                    sb.append(" ");
                }
            }
            sb.append(String.format("|%s", System.lineSeparator()));
        }
        System.out.println(sb);
    }
}

class Rectangle implements CorDraw {
    Integer width;
    Integer height;

    Rectangle(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.printf("|%s|%n", new String(new char[this.width]).replace("\0", "-"));
        for (int i = 0; i < this.height - 2; i++) {
            System.out.printf("|%s|%n", new String(new char[this.width]).replace("\0", " "));
        }
        System.out.printf("|%s|%n", new String(new char[this.width]).replace("\0", "-"));
    }
}
