package by.tolpawsta.dao;

import java.util.List;
import java.util.Optional;

/**
 * 14.06.2019
 * by.tolpawsta.dao
 *
 * @author Talochka Pavel
 */
public interface CrudDao<T> {
    Optional<T> find(Integer id);
    void save(T model);
    void update(T model);
    void delete(Integer id);
    List<T> findAll();
}
