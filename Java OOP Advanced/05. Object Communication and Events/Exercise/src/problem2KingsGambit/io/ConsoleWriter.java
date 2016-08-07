package problem2KingsGambit.io;

import problem2KingsGambit.io.contracts.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(Object message) {
        System.out.print(message);
    }
}
