package Problem4ReplaceATag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 14.6.2016 г..
 */
public class ReplaceATag {

    public static void main(String[] args) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String input = reader.readLine();
            if (input.equals("end")){
                break;
            }
            input = input.replaceAll("<a", "[URL");
            input = input.replaceAll("</a>", "[/URL]");
            stringBuilder.append(input);
        }
        System.out.print(stringBuilder);
    }

}
