package problem10InfernoInfinityV2.io;

import problem10InfernoInfinityV2.io.contracts.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(Object message) {
        System.out.println(message);
    }
}
