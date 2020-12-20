package models;

import lombok.Builder;
import lombok.Data;
import models.enums.Accesses;

@Data
@Builder
public class Project {

    private String title;
    private String code;
    private String description;
    private Accesses access;
    private String group;
}
