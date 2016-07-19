package Problem6BirthdayCelebrations;

import Problem6BirthdayCelebrations.contracts.Pet;

class PetImpl implements Pet {

    private String name;
    private String birthday;

    PetImpl(String name, String birthday) {
        this.setBirthday(birthday);
        this.setName(name);
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
