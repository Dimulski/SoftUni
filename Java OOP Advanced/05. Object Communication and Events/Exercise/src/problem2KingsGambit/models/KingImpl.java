package problem2KingsGambit.models;

import problem2KingsGambit.models.contracts.King;
import problem2KingsGambit.models.contracts.Observer;

import java.util.LinkedList;
import java.util.List;

public class KingImpl implements King {

    private String name;
    private List<Observer> soldiers;

    public KingImpl(String name) {
        this.name = name;
        this.soldiers = new LinkedList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addObserver(Observer observer) {
        if (!this.soldiers.contains(observer)) {
            this.soldiers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (this.soldiers.contains(observer)) {
            this.soldiers.remove(observer);
        }
    }

    @Override
    public String notifyObservers() {
        StringBuilder sb = new StringBuilder();
        for (Observer soldier : soldiers) {
            sb.append(soldier.update(this.getName()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String respondToAttack() {
        return String.format("King %s is under attack!%s", this.getName(), System.lineSeparator()) +
        notifyObservers();
    }
}
