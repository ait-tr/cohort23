package de.ait.tracker.controllers.api;

import de.ait.tracker.dto.EventDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import de.ait.tracker.dto.NewEventDto;

@RequestMapping("/events")
public interface EventsApi {

    @PostMapping
    EventDto addEvent(@RequestBody NewEventDto newEvent);
}
