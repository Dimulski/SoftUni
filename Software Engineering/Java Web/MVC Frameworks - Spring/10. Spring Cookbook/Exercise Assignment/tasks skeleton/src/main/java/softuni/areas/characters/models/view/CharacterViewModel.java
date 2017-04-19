package softuni.areas.characters.models.view;

public class CharacterViewModel {
    private Long id;

    private Long xp;

    private String name;

    private Long money;

    private Boolean onMission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getXp() {
        return xp;
    }

    public void setXp(Long xp) {
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Boolean getOnMission() {
        return onMission;
    }

    public void setOnMission(Boolean onMission) {
        this.onMission = onMission;
    }
}
