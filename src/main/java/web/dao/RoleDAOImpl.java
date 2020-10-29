package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    EntityManager entityManager;

    public Role getRoleByName(String name) {
        return (Role) entityManager.createQuery("select r from Role r where r.roleName=:name")
                .setParameter("name", name)
                .getSingleResult();
    }

    public void createRoles(String roleName) {
        entityManager.persist(new Role(roleName));
    }

}
