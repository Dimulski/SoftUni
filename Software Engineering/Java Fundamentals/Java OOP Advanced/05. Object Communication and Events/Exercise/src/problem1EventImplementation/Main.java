package problem1EventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        DispatcherImpl dispatcher = new DispatcherImpl();
        HandlerImpl handler = new HandlerImpl();
        dispatcher.addNameChangeListener(handler);

        while (true) {
            String line = reader.readLine();
            if (line.equals("End")) {
                break;
            }

            dispatcher.fireNameChangeEvent(line);
        }
    }
}
