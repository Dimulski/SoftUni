package Problem8MilitaryElite.models;

import Problem8MilitaryElite.Corp;
import Problem8MilitaryElite.contracts.Commando;
import Problem8MilitaryElite.contracts.Mission;

import java.util.LinkedList;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldier implements Commando {

    private List<Mission> missions;

    public CommandoImpl(Integer id, String firstName, String lastName, Double salary, Corp corp) {
        super(id, firstName, lastName, salary, corp);
        this.setMissions(new LinkedList<Mission>());
    }

    private void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    @Override
    public List<Mission> getMissions() {
        return this.missions;
    }

    public void addMission(Mission mission) { // I don't think this is the best way to skip adding an invalid Mission
        if (mission.getMissionState() != null) {
            this.getMissions().add(mission);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Missions:%s", System.lineSeparator()));
        for (Mission mission : getMissions()) {
            sb.append("  ");
            sb.append(mission.toString());
        }
        return super.toString() + sb.toString();
    }
}
