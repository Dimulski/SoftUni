package enums;

public enum  StatusCode {
    CONTINUE(100, "Continue"),
    OK(200, "OK"),
    CREATED(201, "Created"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private int code;
    private String phrase;

    private StatusCode(int code, String phrase) {
        this.code = code;
        this.phrase = phrase;
    }

    public int getCode() {
        return this.code;
    }

    public String getPhrase() {
        return this.phrase;
    }
}
