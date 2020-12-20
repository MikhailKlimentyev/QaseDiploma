package models;

import lombok.Builder;
import lombok.Data;
import models.enums.*;

@Data
@Builder
public class TestCase {

    private String title;
    private String description;
    private Statuses status;
    private Suites suite;
    private Severities severity;
    private Priorities priority;
    private Types type;
    private Behaviors behavior;
    private AutomationStatuses automationStatus;
    private String preConditions;
    private String postConditions;
}
