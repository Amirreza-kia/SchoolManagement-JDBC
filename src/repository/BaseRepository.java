package repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {

    Optional<T> findById(int id) throws SQLException;
    List<T> findAll() throws SQLException;
    void persist(T entity) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(int id) throws SQLException;
}
