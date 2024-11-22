package com.avirantenterprises.infocollector.repository.project;

import com.avirantenterprises.infocollector.model.project.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
}
