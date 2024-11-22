package com.avirantenterprises.infocollector.repository.project;

import com.avirantenterprises.infocollector.model.project.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
