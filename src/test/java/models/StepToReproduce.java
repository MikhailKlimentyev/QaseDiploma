package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StepToReproduce {

    private String action;
    private String expectedResult;
    private String inputData;
}
