package de.ait.tracker.controllers;

import de.ait.tracker.controllers.api.EventsApi;
import de.ait.tracker.dto.EventDto;
import de.ait.tracker.dto.NewEventDto;
import de.ait.tracker.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * 8/2/2023
 * TaskTracker
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@RestController
public class EventsController implements EventsApi {

    private final EventsService eventsService;

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        return eventsService.addEvent(newEvent);
    }
}
