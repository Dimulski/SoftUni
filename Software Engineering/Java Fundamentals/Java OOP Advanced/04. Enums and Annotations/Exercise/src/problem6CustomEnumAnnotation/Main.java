package problem6CustomEnumAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String type = reader.readLine();

        Class<CardRank> rank = CardRank.class;
        Class<CardSuit> suit = CardSuit.class;
        EnumInfo annotation;
        annotation = type.equals("Rank") ?
                rank.getAnnotation(EnumInfo.class) :
                suit.getAnnotation(EnumInfo.class);

        System.out.printf("Type = %s, Description = %s", annotation.type(), annotation.description());
    }
}
