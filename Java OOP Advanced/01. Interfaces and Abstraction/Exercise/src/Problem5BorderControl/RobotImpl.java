package Problem5BorderControl;

import Problem5BorderControl.contracts.Robot;

class RobotImpl implements Robot {

    private String model;
    private String id;

    RobotImpl(String model, String id) {
        this.setModel(model);
        this.setId(id);
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return getId();
    }
}
