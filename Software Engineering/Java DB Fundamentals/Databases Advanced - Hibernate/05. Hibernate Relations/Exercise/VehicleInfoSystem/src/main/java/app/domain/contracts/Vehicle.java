package app.domain.contracts;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Vehicle extends Serializable {

    String getManufacturer();

    void setManufacturer(String manufacturer);

    String getModel();

    void setModel(String model);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    int getMaxSpeed();

    void setMaxSpeed(int maxSpeed);
}
