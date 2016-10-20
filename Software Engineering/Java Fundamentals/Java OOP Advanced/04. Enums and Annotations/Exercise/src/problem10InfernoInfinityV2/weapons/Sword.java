package problem10InfernoInfinityV2.weapons;

public class Sword extends WeaponImpl {

    private static final int DEFAULT_MIN_DAMAGE = 4;
    private static final int DEFAULT_MAX_DAMAGE = 6;
    private static final int DEFAULT_SOCKETS_COUNT = 3;

    public Sword(String name) {
        super(name, DEFAULT_MIN_DAMAGE, DEFAULT_MAX_DAMAGE, DEFAULT_SOCKETS_COUNT);
    }
}
