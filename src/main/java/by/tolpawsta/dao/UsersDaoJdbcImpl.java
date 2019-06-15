package by.tolpawsta.dao;

import by.tolpawsta.models.User;
import by.tolpawsta.models.UserInfo;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 14.06.2019
 * by.tolpawsta.dao
 *
 * @author Talochka Pavel
 */
public class UsersDaoJdbcImpl implements UsersDao {
    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * from user";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "select * from user where user.user_id=?";
    //language=SQL
    private final String SQL_SAVE = "INSERT into user (firstname, lastname, adress, phone, login, password, birthdate) " +
            "values(?,?,?,?,?,?,?)";
    private Connection connection;

    public UsersDaoJdbcImpl(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findAllByFirstName(String firstname) {
        return null;
    }

    @Override
    public Optional<User> find(Integer id) {

        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                LocalDate birthDate = resultSet.getDate("birthdate").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                return Optional.of(new User(id, firstName, lastName, birthDate));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(User model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE);
            statement.setString(1, model.getFirstname());
            statement.setString(2, model.getLastname());
            statement.setString(3, null);
            statement.setString(4, null);
            statement.setString(5, model.getLogin());
            statement.setString(6, model.getPassword());
            statement.setDate(7, Date.valueOf(model.getBirthday()));
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
               Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                LocalDate birthDate = LocalDate.parse(resultSet.getString("birthdate"));
                //LocalDate birthDate = resultSet.getDate("birthdate").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                User user = new User(id, firstName, lastName, birthDate);
                System.out.println(user.getFirstname());
                System.out.println(user.getLastname());
                System.out.println(user.getBirthday());
                users.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
