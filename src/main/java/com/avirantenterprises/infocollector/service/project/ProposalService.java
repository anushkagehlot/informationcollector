package com.avirantenterprises.infocollector.service.project;

import com.avirantenterprises.infocollector.model.project.Proposal;
import com.avirantenterprises.infocollector.repository.project.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    public Proposal getProposalById(Long id) {
        return proposalRepository.findById(id).orElse(null);
    }

    public void saveProposal(Proposal proposal) {
        proposalRepository.save(proposal);
    }

    public void deleteProposalById(Long id) {
        proposalRepository.deleteById(id);
    }
}
