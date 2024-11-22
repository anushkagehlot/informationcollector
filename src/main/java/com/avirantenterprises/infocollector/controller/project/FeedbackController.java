package com.avirantenterprises.infocollector.controller.project;

import com.avirantenterprises.infocollector.model.project.Feedback;
import com.avirantenterprises.infocollector.service.project.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedbacks")
    public String showFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackService.getAllFeedbacks());
        return "project/feedbackList";
    }

    @GetMapping("/feedback/new")
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "project/feedbackForm";
    }

    @PostMapping("/feedback/save")
    public String saveFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return "redirect:/feedbacks";
    }

    @GetMapping("/feedback/edit/{id}")
    public String editFeedback(@PathVariable Long id, Model model) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        model.addAttribute("feedback", feedback);
        return "project/feedbackForm";
    }

    @GetMapping("/feedback/delete/{id}")
    public String deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedbackById(id);
        return "redirect:/feedbacks";
    }

    @GetMapping("/feedback/view/{id}")
    public String viewFeedback(@PathVariable Long id, Model model) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        model.addAttribute("feedback", feedback);
        return "project/feedbackView";
    }
}
