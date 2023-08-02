package de.ait.tracker.dto;

import de.ait.tracker.models.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 8/2/2023
 * TaskTracker
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {

    private Long id;

    private String title;

    private String description;

    public static EventDto from(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .build();
    }

    public static List<EventDto> from(List<Event> events) {
        return events.stream().map(EventDto::from).collect(Collectors.toList());
    }
}
