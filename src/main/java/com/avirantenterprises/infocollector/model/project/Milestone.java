package com.avirantenterprises.infocollector.model.project;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String milestoneTitle;
    private String milestoneDescription;
    private LocalDate milestoneDate;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMilestoneTitle() {
        return milestoneTitle;
    }

    public void setMilestoneTitle(String milestoneTitle) {
        this.milestoneTitle = milestoneTitle;
    }

    public String getMilestoneDescription() {
        return milestoneDescription;
    }

    public void setMilestoneDescription(String milestoneDescription) {
        this.milestoneDescription = milestoneDescription;
    }

    public LocalDate getMilestoneDate() {
        return milestoneDate;
    }

    public void setMilestoneDate(LocalDate milestoneDate) {
        this.milestoneDate = milestoneDate;
    }
}
