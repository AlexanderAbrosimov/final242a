package pp.dao;

import pp.model.Role;

import java.util.List;
import java.util.NoSuchElementException;

public interface RoleDAO {

    List<Role> findAll();

    Role findRoleByAuthority(String authority) throws NoSuchElementException;
}

