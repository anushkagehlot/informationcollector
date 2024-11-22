package com.avirantenterprises.infocollector.service.project;

import com.avirantenterprises.infocollector.model.project.Event;
import com.avirantenterprises.infocollector.repository.project.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
}
