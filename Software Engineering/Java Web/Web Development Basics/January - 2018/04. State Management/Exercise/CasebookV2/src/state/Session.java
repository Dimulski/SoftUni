package state;

public class Session {

    private String id;
    private Cookie cookie;

    public Session() { }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cookie getCookie() {
        return this.cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    @Override
    public String toString() {
        return "sessionId=" + this.id;
    }
}
