package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDAOImpl;
import web.models.Role;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    private static List<String> allRoles = Arrays.asList("ROLE_ADMIN", "ROLE_USER");
    @Autowired
    RoleDAOImpl roleDAO;

    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    public void createRoles() {
        for (String role:allRoles
             ) {
            roleDAO.createRoles(role);
        }
    }

    public List<String> getAllRoles () {
        return allRoles;
    }
}
