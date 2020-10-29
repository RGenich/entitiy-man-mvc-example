package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.dao.RoleDAOImpl;
import web.dao.UserDao;
import web.dao.UserDaoImlp;
import web.models.Role;
import web.models.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDaoImlp")
    UserDao userDao = new UserDaoImlp();
    @Autowired
    RoleDAOImpl roleDAO;
    @Autowired
    RoleServiceImpl roleServiceImpl;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void addUser(User user) {

        Set<Role> roles = new HashSet<>();
        if (getUser(1) == null) {
            roleServiceImpl.createRoles();
            roles.add(roleServiceImpl.getRoleByName("ROLE_ADMIN"));
        }
        roles.add(roleServiceImpl.getRoleByName("ROLE_USER"));
        user.setRoles(roles);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public void updateUser(User user) {

        Set<Role> dbRoles = new HashSet<>();
        for (Role role : user.getRoles()) {
            dbRoles.add(roleDAO.getRoleByName(role.getRoleName()));
        }
        user.setRoles(dbRoles);
        userDao.updateUser(user);
    }

    @Override
    public List<User> showUsers() {
        return userDao.showUsers();
    }

    @Override
    public User getUserByLogin(String login) {

        return userDao.getUserByLogin(login);
    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return userDao.getUserByLogin(s);
//    }
}
