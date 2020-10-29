package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

    User getUser(Integer id);

    List<User> showUsers();

    User getUserByLogin (String login);
}
