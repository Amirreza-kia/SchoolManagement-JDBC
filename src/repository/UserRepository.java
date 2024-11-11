package repository;

import db.Database;
import model.User;
import org.intellij.lang.annotations.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements BaseRepository<User> {

    @Language("SQL")
    private static final String FIND_BY_ID = "SELECT * FROM schoolsystemmanagment.public.user WHERE user_id = ?";
    @Language("SQL")
    private static final String FIND_ALL = "SELECT * FROM schoolsystemmanagment.public.user";
    @Language("SQL")
    private static final String INSERT_USER_QUERY = "INSERT INTO schoolsystemmanagment.public.user" +
            " (firstname, lastname, username, password, user_id, role) VALUES (?, ?,?,?,?,?)";
    @Language("SQL")
    private static final String UPDATE_USER_QUERY = "insert into schoolsystemmanagment.public.user(" +
            "firstname,lastname,username,password,user_id,role) VALUES (?,?,?,?,?,?)";
    @Language("SQL")
    private static final String DELETE_USER_QUERY = "DELETE FROM schoolsystemmanagment.public.user WHERE user_id = ?";
    @Language("SQL")
    private static final String LOGIN_QUERY = "SELECT * FROM schoolsystemmanagment.public.user WHERE username = ? AND password = ? ";

    Database database = new Database();



    @Override
    public Optional<User> findById(int id) throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(FIND_BY_ID);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Optional<User> optionalUser = Optional.empty();
        while (rs.next()) {
            User user = new User();
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setUserId(rs.getInt("user_id"));
            user.setRoll(rs.getString("role"));
            optionalUser = Optional.of(user);

        }
        return optionalUser;
    }

    @Override
    public List<User> findAll() throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(FIND_ALL);
        ResultSet rs = ps.executeQuery();
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setUserId(rs.getInt("user_id"));
            user.setRoll(rs.getString("role"));
            users.add(user);
        }
        return users;
    }

    @Override
    public void persist(User entity) throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(INSERT_USER_QUERY);
        ps.setString(1, entity.getFirstname());
        ps.setString(2, entity.getLastname());
        ps.setString(3, entity.getUserName());
        ps.setString(4, entity.getPassword());
        ps.setInt(5, entity.getUserId());
        ps.setString(6, entity.getRole());
        ps.executeUpdate();
    }

    @Override
    public void update(User entity) throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(UPDATE_USER_QUERY);
        ps.setString(1, entity.getFirstname());
        ps.setString(2, entity.getLastname());
        ps.setString(3, entity.getUserName());
        ps.setString(4, entity.getPassword());
        ps.setInt(5, entity.getUserId());
        ps.setString(6, entity.getRole());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(DELETE_USER_QUERY);
        ps.setInt(1, id);
        ps.executeUpdate();
    }


    public Optional<User> login(String username, String password) throws SQLException {
        PreparedStatement preparedStatement = this.database.getPreparedStatement(LOGIN_QUERY);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        Optional<User> optionalUser = Optional.empty();
        while (resultSet.next()) {
            optionalUser = Optional.of(new User(resultSet.getInt("user_id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("role")));
        }
        return optionalUser;
    }

}
