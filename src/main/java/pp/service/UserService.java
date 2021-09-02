package pp.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pp.model.Role;
import pp.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAllUsers();
    void save(User user);


//    void update(int id, User updatedUser);
//    void delete(int id);
//    User show(int id);
}
