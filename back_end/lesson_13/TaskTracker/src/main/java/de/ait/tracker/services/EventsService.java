package de.ait.tracker.services;

import de.ait.tracker.dto.EventDto;
import de.ait.tracker.dto.NewEventDto;

public interface EventsService {
    EventDto addEvent(NewEventDto newEvent);
}
