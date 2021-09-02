package pp.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role implements Serializable, GrantedAuthority {

    @Id
    @Column(name = "roleId", unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long roleId;

    @Column(name = "roleName", unique = true)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getName() {
        return roleName;
    }

    public void setName(String name) {
        this.roleName = name;
    }

    public Long getId() {
        return roleId;
    }

    public void setId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId == role.roleId && Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + roleId +
                ", name='" + roleName + '\'' +
                '}';
    }
}
