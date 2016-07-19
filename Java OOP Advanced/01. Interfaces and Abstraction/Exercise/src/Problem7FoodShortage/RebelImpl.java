package Problem7FoodShortage;

import Problem7FoodShortage.contracts.Rebel;

class RebelImpl implements Rebel{

    private static final Integer BUY_FOOD_AMOUNT = 5;
    private static final Integer DEFAULT_FOOD_AMOUNT = 0;
    private String name;
    private Integer age;
    private String group;
    private Integer foodAmount;

    RebelImpl(String name, Integer age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
        this.setFoodAmount(DEFAULT_FOOD_AMOUNT);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    private void setFoodAmount(Integer foodAmount) {
        this.foodAmount = foodAmount;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public void buyFood() {
        this.setFoodAmount(getFoodAmount() + BUY_FOOD_AMOUNT);
    }

    @Override
    public Integer getFoodAmount() {
        return this.foodAmount;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
