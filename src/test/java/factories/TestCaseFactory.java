package factories;

import lombok.extern.log4j.Log4j2;
import models.TestCase;

import static models.enums.AutomationStatuses.NOT_AUTOMATED;
import static models.enums.Behaviors.POSITIVE;
import static models.enums.Priorities.HIGH;
import static models.enums.Severities.MAJOR;
import static models.enums.Statuses.ACTUAL;
import static models.enums.Suites.WITHOUT_SUITE;
import static models.enums.Types.FUNCTIONAL;

@Log4j2
public class TestCaseFactory {

    public static TestCase getTestCase() {
        TestCase testCase = TestCase.builder()
                .title(getTestCaseName())
                .description("Some test case description")
                .status(ACTUAL)
                .suite(WITHOUT_SUITE)
                .severity(MAJOR)
                .priority(HIGH)
                .type(FUNCTIONAL)
                .behavior(POSITIVE)
                .automationStatus(NOT_AUTOMATED)
                .preConditions("Some test case pre-conditions")
                .postConditions("Some test case post-conditions")
                .build();
        log.debug(String.format("Getting test case %s", testCase.toString()));
        return testCase;
    }

    public static String getTestCaseName() {
        String testCaseName = "QA_" + System.currentTimeMillis();
        log.debug(String.format("Getting test case name %s", testCaseName));
        return testCaseName;
    }
}
