package pp.dao;

import org.springframework.stereotype.Repository;
import pp.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Role> findAll() {
        return em.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    public Role findRoleByAuthority(String auth) throws NoSuchElementException {
        for (Role r : findAll()) {
            if (auth.equals(r.getAuthority())) {
                return Optional.of(r)
                        .orElseThrow(() -> new NoSuchElementException("Role not found"));
            }
        }
        return Optional.<Role>empty()
                .orElseThrow(() -> new NoSuchElementException("Role not found"));
    }
}
