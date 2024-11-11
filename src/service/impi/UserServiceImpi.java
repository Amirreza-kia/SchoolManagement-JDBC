package service.impi;

import exception.UserNotFoundException;
import model.User;
import repository.UserRepository;
import service.UserService;
import util.ApplicationContext;

import java.sql.SQLException;
import java.util.Optional;

public class UserServiceImpi implements UserService {

    public String login(String username, String password) {
        try {
            Optional<User> optionalUser = ApplicationContext.userRepository.login(username, password);
            if (optionalUser.isEmpty()) {
                throw new UserNotFoundException("Username or password is incorrect");
            }
            return optionalUser.get().getRole();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
