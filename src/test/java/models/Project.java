package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

    private String title;
    private String code;
    private String description;
    private Access access;
    private String group;
}
