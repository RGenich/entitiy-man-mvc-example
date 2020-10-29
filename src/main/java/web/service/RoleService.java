package web.service;

import web.models.Role;

import java.util.List;

public interface RoleService {

    Role getRoleByName(String name);
    void createRoles();
    List<String> getAllRoles();

}
