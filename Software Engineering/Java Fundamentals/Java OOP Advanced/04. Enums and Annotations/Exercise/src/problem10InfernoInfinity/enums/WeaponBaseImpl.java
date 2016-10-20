package problem10InfernoInfinity.enums;

import problem10InfernoInfinity.contracts.Gem;
import problem10InfernoInfinity.contracts.WeaponBase;

public enum WeaponBaseImpl implements WeaponBase {

    AXE(5, 10, new Gem[4]),
    SWORD(4, 6, new Gem[3]),
    KNIFE(3, 4, new Gem[2]);

    private Integer minDamage;
    private Integer maxDamage;
    private Gem[] sockets;

    WeaponBaseImpl(Integer minDamage, Integer maxDamage, Gem[] sockets) {
        this.setMinDamage(minDamage);
        this.setMaxDamage(maxDamage);
        this.setSockets(sockets);
    }

    @Override
    public Integer getMinDamage() {
        return this.minDamage;
    }

    @Override
    public Integer getMaxDamage() {
        return this.maxDamage;
    }

    @Override
    public Gem[] getSockets() {
        return this.sockets;
    }

    private void setMinDamage(Integer minDamage) {
        this.minDamage = minDamage;
    }

    private void setMaxDamage(Integer maxDamage) {
        this.maxDamage = maxDamage;
    }

    private void setSockets(Gem[] sockets) {
        this.sockets = sockets;
    }
}
