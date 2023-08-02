package de.ait.tracker.repositories;

import de.ait.tracker.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event, Long> {
}
