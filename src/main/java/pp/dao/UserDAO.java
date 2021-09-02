package pp.dao;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pp.model.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();
    User find(String email);

    void save(User user);

//    void save(User user);
//    void update(int id, User updatedUser);
//    void delete(int id);
//    User show(int id);
}
