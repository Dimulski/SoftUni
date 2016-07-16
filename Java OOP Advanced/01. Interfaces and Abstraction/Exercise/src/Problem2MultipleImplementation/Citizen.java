package Problem2MultipleImplementation;

class Citizen implements Person, Birthable, Identifiable {

    private String name;
    private Integer age;
    private String id;
    private String birthday;

    Citizen(String name, Integer age, String id, String birthday) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthday(birthday);
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

    private void setBirthday(String birthday) {
        this.birthday = birthday;
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
    public String birthday() {
        return this.birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
