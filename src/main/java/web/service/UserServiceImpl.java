package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.models.User;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDaoImlp")
    UserDao userDao;

    @Override
    public void addUser(User user){
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> showUsers() {
        return userDao.showUsers();
    }
}
