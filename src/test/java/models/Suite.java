package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {

    private String title;
    private Integer parentId;
    private String description;
    private String preconditions;
}
