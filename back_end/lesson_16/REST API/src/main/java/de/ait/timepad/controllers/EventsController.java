package de.ait.timepad.controllers;

import de.ait.timepad.dto.NewEventDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 8/8/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RestController
@RequestMapping("/events")
public class EventsController {

    @PostMapping
    public ResponseEntity<?> addEvent(@RequestBody @Valid NewEventDto eventDto) {
        System.out.println(eventDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
