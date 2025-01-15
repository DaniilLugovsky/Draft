package models;

import lombok.*;

@Data
public class Project {
    private int id;
    private String name;
    private String announcement;
    private boolean showAnnouncement;
    private int suite_mod;
    private boolean isEnableTCApprovals;
}
