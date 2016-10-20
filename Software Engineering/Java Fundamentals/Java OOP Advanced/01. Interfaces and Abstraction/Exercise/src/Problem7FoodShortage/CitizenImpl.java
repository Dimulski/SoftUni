package Problem7FoodShortage;

import Problem7FoodShortage.contracts.Citizen;

class CitizenImpl implements Citizen {

    private static final Integer BUY_FOOD_AMOUNT = 10;
    private static final Integer DEFAULT_FOOD_AMOUNT = 0;
    private String birthday;
    private String name;
    private Integer age;
    private String id;
    private Integer foodAmount;

    CitizenImpl(String name, Integer age, String id, String birthday) {
        this.setBirthday(birthday);
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setFoodAmount(DEFAULT_FOOD_AMOUNT);
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

    private void setFoodAmount(Integer foodAmount) {
        this.foodAmount = foodAmount;
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
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public void buyFood() {
        this.setFoodAmount(getFoodAmount() + BUY_FOOD_AMOUNT);
    }

    @Override
    public Integer getFoodAmount() {
        return this.foodAmount;
    }
}
