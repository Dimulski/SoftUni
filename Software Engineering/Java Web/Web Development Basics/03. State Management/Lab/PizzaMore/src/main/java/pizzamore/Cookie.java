package pizzamore;

public class Cookie {

    private String name;

    private String value;

    public Cookie(String name, String value) {
        this.setName(name);
        this.setValue(value);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        this.value = value;
    }

    public String getCookieValue() {
        return this.name + "=" + this.value + "; ";
    }
}
