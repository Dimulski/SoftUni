package Problem6BirthdayCelebrations;

import Problem6BirthdayCelebrations.contracts.Citizen;

class CitizenImpl implements Citizen {

    private String birthday;
    private String name;
    private Integer age;
    private String id;

    CitizenImpl(String name, Integer age, String id, String birthday) {
        this.setBirthday(birthday);
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
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

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
