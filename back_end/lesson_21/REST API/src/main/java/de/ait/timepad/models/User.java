package de.ait.timepad.models;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "articles")
@ToString(exclude = "articles")
@Entity
@Table(name = "account")
public class User {

    public enum Role {
        ADMIN,
        USER,
        MANAGER
    }

    public enum State {
        NOT_CONFIRMED,
        CONFIRMED,
        BANNED,
        DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "about")
    private List<Article> articles;

    @OneToMany(mappedBy = "about")
    @Where(clause = "state = 'PUBLISHED'")
    private List<Article> publishedArticles;
}
