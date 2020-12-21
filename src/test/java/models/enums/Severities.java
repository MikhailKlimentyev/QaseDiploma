package models.enums;

public enum Severities {

    NOT_SET("Not set"),
    BLOCKER("Blocker"),
    CRITICAL("Critical"),
    MAJOR("Major"),
    NORMAL("Normal"),
    MINOR("Minor"),
    TRIVIAL("Trivial");

    private String field;

    Severities(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
