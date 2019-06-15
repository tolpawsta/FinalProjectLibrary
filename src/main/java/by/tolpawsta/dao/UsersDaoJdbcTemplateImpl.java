package by.tolpawsta.dao;

import by.tolpawsta.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * 15.06.2019
 * by.tolpawsta.dao
 *
 * @author Talochka Pavel
 */
public class UsersDaoJdbcTemplateImpl implements UsersDao {
    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * from user";
    private JdbcTemplate template;
    private RowMapper<User> rowMapper = (resultSet, i) -> {
       return new User(
                resultSet.getInt("id"),
                resultSet.getString("firstname"),
                resultSet.getString("lastname"),
                LocalDate.parse(resultSet.getString("birthdate"))
                );

    };

    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override

    public List<User> findAllByFirstName(String firstname) {
        return null;
    }

    @Override
    public Optional<User> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL,rowMapper);
    }
}
