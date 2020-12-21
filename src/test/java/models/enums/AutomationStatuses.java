package models.enums;

public enum AutomationStatuses {

    NOT_AUTOMATED("Not automated"),
    TO_BE_AUTOMATED("To be automated"),
    AUTOMATED("Automated");

    private String field;

    AutomationStatuses(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
