package models.enums;

public enum Suites {

    WITHOUT_SUITE("Test cases without suite");

    private String field;

    Suites(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
