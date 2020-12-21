package models.enums;

public enum Behaviors {

    NOT_SET("Not set"),
    POSITIVE("Positive"),
    NEGATIVE("Negative"),
    DESTRUCTIVE("Destructive");

    private String field;

    Behaviors(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
