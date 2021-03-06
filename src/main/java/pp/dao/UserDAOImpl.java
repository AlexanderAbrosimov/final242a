package pp.dao;

import org.springframework.stereotype.Repository;
import pp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public User find(String email) {
        return em.find(User.class, email);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }









//    @Override
//    public User show(int id) {
//        return em.find(User.class, id);
//    }
//
//    @Override
//    public void update(int id, User updatedUser) {
//        User userToBeUpdated = em.find(User.class, id);
//
//        userToBeUpdated.setName(updatedUser.getName());
//        userToBeUpdated.setAge(updatedUser.getAge());
//        userToBeUpdated.setEmail(updatedUser.getEmail());
//
//    }
//
//    @Override
//    public void delete(int id) {
//        em.remove(em.find(User.class, id));
//    }
}
