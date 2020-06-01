package se.ecutb.OmarAli.todo_app.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.OmarAli.todo_app.entity.AppUserRole;
import se.ecutb.OmarAli.todo_app.entity.Role;

import java.util.Optional;

public interface AppUserRoleRepo extends JpaRepository<AppUserRole, Integer> {

    @Override
    Optional<AppUserRole> findById(Integer integer);
    Optional<AppUserRole> findByRole(Role userRole);
}
