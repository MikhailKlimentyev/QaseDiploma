package models.enums;

public enum Priorities {

    NOT_SET("Not set"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private String field;

    Priorities(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
