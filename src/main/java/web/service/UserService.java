package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUser(Integer id);

    User getUser(Integer id);

    void updateUser(User user);

    List<User> showUsers();

    User getUserByLogin(String login);
}
