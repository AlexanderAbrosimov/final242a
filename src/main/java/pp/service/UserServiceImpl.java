package pp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pp.dao.RoleDAO;
import pp.dao.UserDAO;
import pp.model.Role;
import pp.model.User;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;

    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAll();
    }


    @Override
    public void save(User user) {
        userDAO.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDAO.find(email);
    }

//    @Override
//    public User show(int id) {
//        return userDAO.show(id);
//    }
//    @Override
//    public void update(int id, User updatedUser) {
//        userDAO.update(id, updatedUser);
//    }
//
//    @Override
//    public void delete(int id) {
//        userDAO.delete(id);
//    }

}
