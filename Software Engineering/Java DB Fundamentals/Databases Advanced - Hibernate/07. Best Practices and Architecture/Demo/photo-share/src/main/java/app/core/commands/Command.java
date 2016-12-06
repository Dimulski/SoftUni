package app.core.commands;

import app.core.Executable;

public abstract class Command implements Executable {
    private String[] data;

    protected Command(String[] data) {
        this.setData(data);
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
