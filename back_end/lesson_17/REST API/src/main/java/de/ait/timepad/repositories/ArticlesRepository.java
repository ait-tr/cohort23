package de.ait.timepad.repositories;

import de.ait.timepad.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Article, Long> {
}
