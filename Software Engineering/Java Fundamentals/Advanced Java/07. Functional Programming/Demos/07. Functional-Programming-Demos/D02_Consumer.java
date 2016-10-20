import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class D02_Consumer {
    public static void main(String[] args) {
        String[] greetingMessages = new String[]{"Hello!", "Hi!", "Bonjour!", "Holla!", "Ciao!"};

        Consumer<String> print = message -> System.out.println(message);

        for (String greetingMessage : greetingMessages) {
            print.accept(greetingMessage);
        }
    }
}
