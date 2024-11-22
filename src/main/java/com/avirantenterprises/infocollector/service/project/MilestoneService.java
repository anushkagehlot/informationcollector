package com.avirantenterprises.infocollector.service.project;

import com.avirantenterprises.infocollector.model.project.Milestone;
import com.avirantenterprises.infocollector.repository.project.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MilestoneService {

    @Autowired
    private MilestoneRepository milestoneRepository;

    public List<Milestone> getAllMilestones() {
        return milestoneRepository.findAll();
    }

    public Milestone getMilestoneById(Long id) {
        Optional<Milestone> milestone = milestoneRepository.findById(id);
        return milestone.orElse(null);
    }

    public void saveMilestone(Milestone milestone) {
        milestoneRepository.save(milestone);
    }

    public void deleteMilestoneById(Long id) {
        milestoneRepository.deleteById(id);
    }
}
