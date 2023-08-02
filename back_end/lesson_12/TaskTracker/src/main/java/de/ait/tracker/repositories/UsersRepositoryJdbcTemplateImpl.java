package de.ait.tracker.repositories;

import de.ait.tracker.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 8/1/2023
 * TaskTracker
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Repository
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account;";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, (row, rowNumber) -> User.builder()
                .id(row.getLong("id"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .build());
    }
}
