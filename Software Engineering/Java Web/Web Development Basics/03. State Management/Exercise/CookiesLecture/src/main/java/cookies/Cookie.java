package cookies;

public class Cookie {

    private String name;

    private String value;

    public Cookie(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getCookie() {
        return this.name + "=" + this.value;
    }
}
