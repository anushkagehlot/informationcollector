package com.avirantenterprises.infocollector.repository.project;

import com.avirantenterprises.infocollector.model.project.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
