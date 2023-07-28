package de.ait.timepad.repositories;

import de.ait.timepad.models.Article;

import java.util.List;

public interface ArticlesRepository extends CrudRepository<Article> {

    // TODO: убрать метод, как только подключим базы данных
    void clear();

    List<Article> findAllByDate(Integer year, Integer month, Integer day);
}
