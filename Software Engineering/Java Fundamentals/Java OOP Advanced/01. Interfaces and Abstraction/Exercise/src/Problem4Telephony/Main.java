package Problem4Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] phoneNumbers = reader.readLine().split("\\s+");
        String[] sites = reader.readLine().split("\\s+");

        Smartphone phone = new Smartphone();
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phone.makeCall(phoneNumber));
        }
        for (String site : sites) {
            System.out.println(phone.browsWeb(site));
        }
    }
}
