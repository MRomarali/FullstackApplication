package se.ecutb.OmarAli.todo_app.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class AppUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserRoleId;
    @Column(unique = true)
    private Role role;

    @ManyToMany(
            mappedBy = "roleSet",
            cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    private Set<AppUser> appUsers;

    public AppUserRole(Role role) {
        this.role = role;
    }

    public AppUserRole(){}

    public int getAppUserRoleId() {
        return appUserRoleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<AppUser> getAppUsers() {
        return appUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserRole that = (AppUserRole) o;
        return appUserRoleId == that.appUserRoleId &&
                role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserRoleId, role);
    }

    @Override
    public String toString() {
        return "AppUserRole{" +
                "appUserRoleId=" + appUserRoleId +
                ", role=" + role +
                '}';
    }
}
