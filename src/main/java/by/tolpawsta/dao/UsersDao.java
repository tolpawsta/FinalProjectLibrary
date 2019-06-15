package by.tolpawsta.dao;

import by.tolpawsta.models.User;

import java.util.List;

/**
 * 14.06.2019
 * by.tolpawsta.dao
 *
 * @author Talochka Pavel
 */
public interface UsersDao extends CrudDao<User> {
    List<User> findAllByFirstName(String firstname);
}
