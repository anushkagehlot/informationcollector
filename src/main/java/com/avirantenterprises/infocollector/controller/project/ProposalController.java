package com.avirantenterprises.infocollector.controller.project;

import com.avirantenterprises.infocollector.model.project.Proposal;
import com.avirantenterprises.infocollector.service.project.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    private final String uploadDir = "uploads/proposals/";

    @GetMapping("/proposals")
    public String showProposals(Model model) {
        model.addAttribute("proposals", proposalService.getAllProposals());
        return "project/proposalList";
    }

    @GetMapping("/proposal/new")
    public String showProposalForm(Model model) {
        model.addAttribute("proposal", new Proposal());
        return "project/proposalForm";
    }

    @PostMapping("/proposal/save")
    public String saveProposal(@ModelAttribute Proposal proposal, @RequestParam("attachment") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, file.getBytes());
                proposal.setAttachmentPath(filePath.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/proposal/new?error";
        }

        proposalService.saveProposal(proposal);
        return "redirect:/proposals";
    }

    @GetMapping("/proposal/edit/{id}")
    public String editProposal(@PathVariable Long id, Model model) {
        Proposal proposal = proposalService.getProposalById(id);
        model.addAttribute("proposal", proposal);
        return "project/proposalForm";
    }

    @GetMapping("/proposal/delete/{id}")
    public String deleteProposal(@PathVariable Long id) {
        proposalService.deleteProposalById(id);
        return "redirect:/proposals";
    }

    @GetMapping("/proposal/view/{id}")
    public String viewProposal(@PathVariable Long id, Model model) {
        Proposal proposal = proposalService.getProposalById(id);
        model.addAttribute("proposal", proposal);
        return "project/proposalView";
    }
}
