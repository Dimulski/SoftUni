package Problem5BorderControl;

import Problem5BorderControl.contracts.Citizen;

class CitizenImpl implements Citizen {

    private String name;
    private Integer age;
    private String id;

    CitizenImpl(String name, Integer age, String id) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
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
