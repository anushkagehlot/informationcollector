package com.avirantenterprises.infocollector.controller.project;

import com.avirantenterprises.infocollector.model.project.Event;
import com.avirantenterprises.infocollector.service.project.EventService;
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
public class EventController {

    @Autowired
    private EventService eventService;

    private final String uploadDir = "uploads/event/";

    @GetMapping("/events")
    public String showEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "project/eventList";
    }

    @GetMapping("/event/new")
    public String showEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "project/eventForm";
    }

    @PostMapping("/event/save")
    public String saveEvent(@ModelAttribute Event event, @RequestParam("attachment") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, file.getBytes());
                event.setAttachmentPath(filePath.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/event/new?error";
        }

        eventService.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/event/edit/{id}")
    public String editEvent(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "project/eventForm";
    }

    @GetMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEventById(id);
        return "redirect:/events";
    }

    @GetMapping("/event/view/{id}")
    public String viewEvent(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "project/eventView";
    }
}
