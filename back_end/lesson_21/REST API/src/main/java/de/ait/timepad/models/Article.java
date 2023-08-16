package de.ait.timepad.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Article {

    public enum State {
        DRAFT, PUBLISHED, DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private LocalDate publishDate;

    @ManyToOne
    @JoinColumn(name = "about_id")
    private User about;

    @Enumerated(value = EnumType.STRING)
    private State state;
}
