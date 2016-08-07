package problem9TrafficLights;

class TrafficLightImpl implements TrafficLight {

    private Light light;

    TrafficLightImpl(Light light) {
        this.setLight(light);
    }

    @Override
    public Light getLight() {
        return this.light;
    }

    private void setLight(Light light) {
        this.light = light;
    }

    @Override
    public void changeLight() {
        if (getLight().equals(Light.RED)) {
            setLight(Light.GREEN);
        } else if (getLight().equals(Light.GREEN)) {
            setLight(Light.YELLOW);
        } else {
            setLight(Light.RED);
        }
    }
}
