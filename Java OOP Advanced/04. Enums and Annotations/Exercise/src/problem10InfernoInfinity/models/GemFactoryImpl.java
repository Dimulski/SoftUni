package problem10InfernoInfinity.models;

import problem10InfernoInfinity.contracts.Gem;
import problem10InfernoInfinity.enums.GemImpl;

public class GemFactoryImpl {

    public static Gem createGem(String gemType) {
        return GemImpl.valueOf(gemType);
    }
}
