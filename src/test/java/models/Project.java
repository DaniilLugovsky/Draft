package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
public class Project {
    private int id;
    private String name;
    private String announcement;

    @SerializedName(value = "show_announcement")
    @JsonProperty("show_announcement")
    private boolean isShowAnnouncement;

    @SerializedName(value = "suite_mode")
    @JsonProperty("suite_mode")
    private int suiteMode;
}
