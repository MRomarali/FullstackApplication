package se.ecutb.OmarAli.todo_app.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.OmarAli.todo_app.entity.AppUser;

import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findAppUserByUserName(String userName);
}
