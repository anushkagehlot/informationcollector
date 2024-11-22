package com.avirantenterprises.infocollector.service.project;

import com.avirantenterprises.infocollector.model.project.Feedback;
import com.avirantenterprises.infocollector.repository.project.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    public void deleteFeedbackById(Long id) {
        feedbackRepository.deleteById(id);
    }
}
