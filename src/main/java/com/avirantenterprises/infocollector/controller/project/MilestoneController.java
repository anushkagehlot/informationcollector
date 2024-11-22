package com.avirantenterprises.infocollector.controller.project;

import com.avirantenterprises.infocollector.model.project.Milestone;
import com.avirantenterprises.infocollector.service.project.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MilestoneController {

    @Autowired
    private MilestoneService milestoneService;

    @GetMapping("/milestones")
    public String showMilestones(Model model) {
        model.addAttribute("milestones", milestoneService.getAllMilestones());
        return "project/milestoneList";
    }

    @GetMapping("/milestone/new")
    public String showMilestoneForm(Model model) {
        model.addAttribute("milestone", new Milestone());
        return "project/milestoneForm";
    }

    @PostMapping("/milestone/save")
    public String saveMilestone(@ModelAttribute Milestone milestone) {
        milestoneService.saveMilestone(milestone);
        return "redirect:/milestones";
    }

    @GetMapping("/milestone/edit/{id}")
    public String editMilestone(@PathVariable Long id, Model model) {
        Milestone milestone = milestoneService.getMilestoneById(id);
        model.addAttribute("milestone", milestone);
        return "project/milestoneForm";
    }

    @GetMapping("/milestone/delete/{id}")
    public String deleteMilestone(@PathVariable Long id) {
        milestoneService.deleteMilestoneById(id);
        return "redirect:/milestones";
    }

    @GetMapping("/milestone/view/{id}")
    public String viewMilestone(@PathVariable Long id, Model model) {
        Milestone milestone = milestoneService.getMilestoneById(id);
        model.addAttribute("milestone", milestone);
        return "project/milestoneView";
    }
}
