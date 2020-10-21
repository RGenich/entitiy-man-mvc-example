package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);

    public void deleteUser(int id);

    public void updateUser(User user);

    public User getUser(int id);

    public List<User> showUsers();
}
