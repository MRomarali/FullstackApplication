package se.ecutb.OmarAli.todo_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.OmarAli.todo_app.data.AppUserRepo;
import se.ecutb.OmarAli.todo_app.data.AppUserRoleRepo;
import se.ecutb.OmarAli.todo_app.dto.AppUserFormDto;
import se.ecutb.OmarAli.todo_app.entity.AppUser;
import se.ecutb.OmarAli.todo_app.entity.AppUserRole;
import se.ecutb.OmarAli.todo_app.entity.Role;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepo appUserRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private AppUserRoleRepo appRoleRepo;

    @Autowired
    public AppUserServiceImpl(AppUserRepo appUserRepo, BCryptPasswordEncoder bCryptPasswordEncoder, AppUserRoleRepo appRoleRepo) {
        this.appUserRepo = appUserRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.appRoleRepo = appRoleRepo;
    }

    // Register new user
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public AppUser registerNewUser(AppUserFormDto userFormDto) {
        AppUserRole userRole = appRoleRepo.findByRole(Role.USER).get();
        AppUserRole adminRole = appRoleRepo.findByRole(Role.ADMIN).get();
       Set<AppUserRole> roleSet = new HashSet<>();
       roleSet.add(userRole);

       //If Admin checkbox is checked, give user admin role
       if (userFormDto.isAdmin()){
           roleSet.add(adminRole);
       }

        AppUser newUser = new AppUser(
                userFormDto.getUserName(),
                userFormDto.getFirstName(),
                userFormDto.getLastName(),
                LocalDate.now(),
                bCryptPasswordEncoder.encode(userFormDto.getPassword()),
                0
        );

        newUser = appUserRepo.save(newUser);
        newUser.setRoleSet(roleSet);
        return newUser;
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    @Override
    public Optional<AppUser> findById(int userId) {
        return appUserRepo.findById(userId);
    }

    @Override
    public Optional<AppUser> findByUserName(String userName) {
        return appUserRepo.findAppUserByUserName(userName);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepo.findAll();
    }

    @Override
    public AppUser delete(AppUser appUser) {
        appUserRepo.delete(appUser);
        return appUser;
    }


}
