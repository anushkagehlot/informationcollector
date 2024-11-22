package com.avirantenterprises.infocollector.model.project;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String feedbackText;
    private String givenBy;
    private LocalDate givenDate;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }

    public LocalDate getGivenDate() {
        return givenDate;
    }

    public void setGivenDate(LocalDate givenDate) {
        this.givenDate = givenDate;
    }
}
