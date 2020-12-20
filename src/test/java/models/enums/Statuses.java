package models.enums;

public enum Statuses {

    ACTUAL("Actual"),
    DRAFT("Draft"),
    DEPRECATED("Deprecated");

    private String field;

    Statuses(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
