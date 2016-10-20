package problem10InfernoInfinityV2.weapons;

public class Axe extends WeaponImpl {

    private static final int DEFAULT_MIN_DAMAGE = 5;
    private static final int DEFAULT_MAX_DAMAGE = 10;
    private static final int DEFAULT_SOCKETS_COUNT = 4;

    public Axe(String name) {
        super(name, DEFAULT_MIN_DAMAGE, DEFAULT_MAX_DAMAGE, DEFAULT_SOCKETS_COUNT);
    }
}
