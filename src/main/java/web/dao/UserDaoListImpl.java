//package web.dao;
//
//import org.springframework.stereotype.Component;
//import web.models.Sex;
//import web.models.User;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class UserDaoListImpl implements UserDao {
//    public static List<User> users = new ArrayList<>();
//
//    static {
//        users.add(new User(1, "Roman Genich", 29, Sex.MALE));
//        users.add(new User(2, "Daria Genich", 33, Sex.FEMALE));
//    }
//
//    @Override
//    public void addUser(User user) {
//        users.add(user);
//    }
//
//    @Override
//    public User deleteUser(int id) {
//        return null;
//    }
//
//    @Override
//    public User getUser(int id) {
//        return users.get(id - 1);
//    }
//
//    @Override
//    public List<User> showUsers() {
//        return users;
//    }
//}
