package models.enums;

import com.google.gson.annotations.SerializedName;

public enum Accesses {

    @SerializedName("all")
    ALL,
    @SerializedName("group")
    GROUP,
    @SerializedName("none")
    NONE;
}
