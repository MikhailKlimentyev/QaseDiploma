package factories;

import lombok.extern.log4j.Log4j2;
import models.StepToReproduce;

@Log4j2
public class StepToReproduceFactory {

    public static StepToReproduce getStepToReproduce() {
        StepToReproduce step = StepToReproduce.builder()
                .action(getAction())
                .expectedResult("Some expected result")
                .inputData("Some input data")
                .build();
        log.debug(String.format("Getting step %s", step.toString()));
        return step;
    }

    private static String getAction() {
        String action = "QA_" + System.currentTimeMillis();
        log.debug(String.format("Getting action %s for Step to reproduce", action));
        return action;
    }
}
