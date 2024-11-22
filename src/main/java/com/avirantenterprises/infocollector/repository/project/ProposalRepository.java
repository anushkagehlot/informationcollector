package com.avirantenterprises.infocollector.repository.project;

import com.avirantenterprises.infocollector.model.project.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
