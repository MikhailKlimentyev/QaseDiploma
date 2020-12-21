package models.enums;

public enum Types {

    OTHER("Other"),
    SMOKE("Smoke"),
    REGRESSION("Regression"),
    SECURITY("Security"),
    USABILITY("Usability"),
    PERFORMANCE("Performance"),
    ACCEPTANCE("Acceptance"),
    FUNCTIONAL("Functional");

    private String field;

    Types(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
