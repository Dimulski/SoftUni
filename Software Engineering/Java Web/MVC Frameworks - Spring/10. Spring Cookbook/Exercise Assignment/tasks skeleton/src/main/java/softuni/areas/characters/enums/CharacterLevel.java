package softuni.areas.characters.enums;

public enum CharacterLevel {

    PLEB        ("Pleb"        , 0L),
    CODE_MONKEY ("Code Monkey" , 500L),
    CODER       ("Coder"       , 2000L),
    JUNIOR      ("Junior"      , 5000L),
    DEVELOPER   ("Developer"   , 10000L),
    SENIOR      ("Senior"      , 20000L),
    MASTER      ("Master"      , 35000L),
    CODE_WIZARD ("Code Wizard" , 100000L);

    private final Long xpNeeded;
    private final String name;

    CharacterLevel(String name, Long xpNeeded) {
        this.xpNeeded = xpNeeded;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CharacterLevel of(Long xp) {

        CharacterLevel cl = null;

        for (CharacterLevel c : values()) {
            if (c.xpNeeded > xp) {
                break;
            }
            cl = c;
        }

        return cl;
    }
}
