package pp.config;

import org.springframework.stereotype.Component;
import pp.model.Role;
import pp.model.User;
import pp.service.RoleService;
import pp.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;

    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void init() {

      Role role = new Role();
      role.setId(1L);
      role.setName("ROLE_ADMIN");

      User user = new User();
      user.setId(1L);
      user.setName("root");
      user.setPassword("1");
      user.setRoles(role);
      user.isEnabled();

      userService.save(user);

    }
}
