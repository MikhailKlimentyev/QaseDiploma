package models;

import com.google.gson.annotations.SerializedName;

public enum Access {

    @SerializedName("all")
    ALL(),
    @SerializedName("group")
    GROUP(),
    @SerializedName("none")
    NONE();
}
