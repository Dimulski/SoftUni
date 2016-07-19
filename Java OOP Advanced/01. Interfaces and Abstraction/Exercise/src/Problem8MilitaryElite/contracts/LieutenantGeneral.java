package Problem8MilitaryElite.contracts;

import java.util.List;

public interface LieutenantGeneral extends Private {

    List<Private> getPrivates();

    void addPrivate(Private privateInstance);
}
