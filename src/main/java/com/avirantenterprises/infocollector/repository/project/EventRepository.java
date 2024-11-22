package com.avirantenterprises.infocollector.repository.project;

import com.avirantenterprises.infocollector.model.project.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
