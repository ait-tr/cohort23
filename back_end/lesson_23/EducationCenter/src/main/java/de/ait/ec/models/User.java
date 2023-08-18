package de.ait.ec.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * 8/16/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@EqualsAndHashCode(of = {"id", "email"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class User {

    public enum Role {
        ADMIN,
        STUDENT,
        MANAGER
    }

    public enum State {
        CONFIRMED,
        DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private State state;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String hashPassword;

    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id"}))
    private Set<Course> courses;
}
