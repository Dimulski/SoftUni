package Problem8MilitaryElite.models;

abstract class Soldier implements Problem8MilitaryElite.contracts.Soldier {

    private Integer id;
    private String firstName;
    private String lastName;

    Soldier(Integer id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setId(Integer id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s",
                getFirstName(),
                getLastName(),
                getId());
    }
}
