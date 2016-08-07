package problem10InfernoInfinityV2.weapons;

public class Knife extends WeaponImpl {

    private static final int DEFAULT_MIN_DAMAGE = 3;
    private static final int DEFAULT_MAX_DAMAGE = 4;
    private static final int DEFAULT_SOCKETS_COUNT = 2;

    public Knife(String name) {
        super(name, DEFAULT_MIN_DAMAGE, DEFAULT_MAX_DAMAGE, DEFAULT_SOCKETS_COUNT);
    }
}
