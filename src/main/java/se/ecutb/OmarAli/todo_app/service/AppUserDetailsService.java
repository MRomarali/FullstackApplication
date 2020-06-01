package se.ecutb.OmarAli.todo_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.ecutb.OmarAli.todo_app.data.AppUserRepo;
import se.ecutb.OmarAli.todo_app.entity.AppUser;
import se.ecutb.OmarAli.todo_app.entity.AppUserRole;
import se.ecutb.OmarAli.todo_app.security.AppUserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private AppUserRepo appUserRepo;

    @Autowired
    public AppUserDetailsService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> checkUsername = appUserRepo.findAppUserByUserName(username);
        if (checkUsername.isPresent()) {
            AppUser appUser = checkUsername.get();
            Collection<GrantedAuthority> collection = new HashSet<>();
            for (AppUserRole role : appUser.getRoleSet()){
                collection.add(new SimpleGrantedAuthority(role.getRole().name()));
            }
            return new AppUserDetails(appUser, collection);
        }else{
            throw new UsernameNotFoundException("Couldn't find username: " + username);
        }
    }
}
