package Problem8MilitaryElite.models;

import Problem8MilitaryElite.MissionState;
import Problem8MilitaryElite.contracts.Mission;

public class MissionImpl implements Mission {

    private String codeName;
    private MissionState missionState = null;

    public MissionImpl(String codeName, MissionState missionState) {
        this.setCodeName(codeName);
        this.setMissionState(missionState);
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    private void setMissionState(MissionState missionState) {
        if (missionState.equals(MissionState.Finished) || missionState.equals(MissionState.inProgress)) {
            this.missionState = missionState;
        }
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public MissionState getMissionState() {
        return this.missionState;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s%s",
                getCodeName(),
                getMissionState(),
                System.lineSeparator());
    }
}
