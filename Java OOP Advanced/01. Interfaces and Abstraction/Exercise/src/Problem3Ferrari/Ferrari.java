package Problem3Ferrari;

class Ferrari implements Car {

    private static final String BRAKES_MESSAGE = "Brakes!";
    private static final String GAS_PEDAL_MESSAGE = "Zadu6avam sA!";
    private static final String MODEL = "488-Spider";
    private String driver;

    Ferrari(String driver) {
        this.setDriver(driver);
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    String getModel() {
        return MODEL;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public String hitBreak() {
        return BRAKES_MESSAGE;
    }

    @Override
    public String stepOnTheGas() {
        return GAS_PEDAL_MESSAGE;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", getModel(), hitBreak(), stepOnTheGas(), getDriver());
    }
}
