package factories;

import lombok.extern.log4j.Log4j2;
import models.Suite;
import org.apache.commons.lang3.RandomStringUtils;

@Log4j2
public class SuiteFactory {

    public static Suite getSuite() {
        Suite suite = Suite.builder()
                .title(getTitle())
                .description("Some description")
                .preconditions("Some preconditions")
                .build();
        log.debug(String.format("Getting suite %s", suite.toString()));
        return suite;
    }

    public static String getTitle() {
        String suiteName = "QA_" + RandomStringUtils.randomAlphabetic(7);
        log.debug(String.format("Getting suite name %s", suiteName));
        return suiteName;
    }
}
