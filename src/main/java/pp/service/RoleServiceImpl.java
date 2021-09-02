package pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import pp.dao.RoleDAO;
import pp.model.Role;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> findAllRoles() {
        return roleDAO.findAll();
    }
}
