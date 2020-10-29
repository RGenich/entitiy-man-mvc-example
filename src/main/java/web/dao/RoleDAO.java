package web.dao;

import web.models.Role;

public interface RoleDAO {
    Role getRoleByName (String name);
    void createRoles (String roleName);
}
