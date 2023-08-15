package de.ait.timepad.repositories;

import de.ait.timepad.models.Article;
import de.ait.timepad.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ArticlesRepository extends JpaRepository<Article, Long> {
    Page<Article> findAllByAboutAndState(Pageable pageable, User about, Article.State state);

    boolean existsByPublishDateAndAbout(LocalDate date, User about);

    int countByPublishDateBetween(LocalDate from, LocalDate to);

    void deleteByPublishDateBefore(LocalDate date);

    List<Article> findAllByAbout_RoleAndAbout_State(User.Role role, User.State state);
}

