package Problem10MooD3.models;

public abstract class Character { // the name GameObject doesn't make much sense. I doubt every game object in our game has a username and password.

    private String username;
    private String characterType;
    private Integer level;

    public Character(String username, String characterType, Integer level) {
        this.setUsername(username);
        this.setCharacterType(characterType);
        this.setLevel(level);
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String name) {
        this.username = name;
    }

    public String getCharacterType() {
        return characterType;
    }

    private void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public Integer getLevel() {
        return level;
    }

    private void setLevel(Integer level) {
        this.level = level;
    }

    public abstract <T> T getSpecialPoints();
    abstract <T> void setSpecialPoints(T specialPoints);
    public abstract <D> D getHashedPassword();
    abstract void setHashedPassword();

    @Override
    public String toString() {
        String result =
                String.format("\"%s\" | \"%s\" -> %s\n",
                        getUsername(),
                        getHashedPassword(),
                        getCharacterType());
        return result;
    }
}
