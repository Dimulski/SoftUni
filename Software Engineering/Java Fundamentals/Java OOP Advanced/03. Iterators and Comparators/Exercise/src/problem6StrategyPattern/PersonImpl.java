package problem6StrategyPattern;

class PersonImpl implements Person {

    private String name;
    private Integer age;

    PersonImpl(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.getName(), this.getAge());
    }
}
