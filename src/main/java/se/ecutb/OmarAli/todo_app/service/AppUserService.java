package se.ecutb.OmarAli.todo_app.service;

import se.ecutb.OmarAli.todo_app.dto.AppUserFormDto;
import se.ecutb.OmarAli.todo_app.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {

    AppUser registerNewUser(AppUserFormDto userFormDto);
    AppUser save(AppUser appUser);
    Optional<AppUser> findById(int userId);
    Optional<AppUser> findByUserName(String userName);
    List<AppUser> findAll();
    AppUser delete(AppUser appUser);
}
