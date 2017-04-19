package softuni.areas.tasks.enums;

public enum Status {
    INACTIVE    ("Inactive"),
    SUCCESS     ("Success"),
    FAILED      ("Failed"),
    IN_PROGRESS ("In Progress");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
