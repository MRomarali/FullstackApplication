package se.ecutb.OmarAli.todo_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.OmarAli.todo_app.data.AppUserRepo;
import se.ecutb.OmarAli.todo_app.data.AppUserRoleRepo;
import se.ecutb.OmarAli.todo_app.data.TodoItemRepo;
import se.ecutb.OmarAli.todo_app.entity.AppUser;
import se.ecutb.OmarAli.todo_app.entity.AppUserRole;
import se.ecutb.OmarAli.todo_app.entity.Role;
import se.ecutb.OmarAli.todo_app.entity.TodoItem;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Seeder {

    private AppUserRepo appUserRepo;
    private AppUserRoleRepo appUserRoleRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private TodoItemRepo todoItemRepo;


    @Autowired
    public Seeder(AppUserRepo appUserRepo, AppUserRoleRepo appUserRoleRepo, BCryptPasswordEncoder bCryptPasswordEncoder, TodoItemRepo todoItemRepo) {
        this.appUserRepo = appUserRepo;
        this.appUserRoleRepo = appUserRoleRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.todoItemRepo = todoItemRepo;
    }

    @PostConstruct
    @Transactional
    public void init(){
        Set<AppUserRole> userRoles = Arrays.stream(Role.values())
                .map(userRole -> appUserRoleRepo.save(new AppUserRole(userRole)))
                .collect(Collectors.toSet());

        AppUser appUser = new AppUser("admin", "Omar", "Ali", LocalDate.now(), bCryptPasswordEncoder.encode("admin"), 0);
        appUser.setRoleSet(userRoles);
        appUserRepo.save(appUser);

        AppUser newUser = new AppUser("user", "Ahmed", "Ali", LocalDate.now(), bCryptPasswordEncoder.encode("user"), 0);
        AppUserRole userRole = appUserRoleRepo.findByRole(Role.USER).get();
        Set<AppUserRole> roleSet = new HashSet<>();
        roleSet.add(userRole);
        newUser.setRoleSet(roleSet);


        TodoItem cleanTodo = new TodoItem("Studera", " Utbilda dig inom relevant arbetsområde", LocalDate.of(2020,06,15), false, 50);
        TodoItem washTodo = new TodoItem("Jobba", " Sök anställning hos det företag du vill jobba inom, gå på anställningsintervju och börja sedan jobba! ", LocalDate.of(2021,06,15), false, 50);
        TodoItem blahTodo = new TodoItem("Skapa projekt", " Skapa egna projekt som du senare säljer till investerare", LocalDate.of(2021,07,10), false, 100);

        newUser.addUsersTodo(cleanTodo);
        newUser.addUsersTodo(washTodo);
        newUser.addUsersTodo(blahTodo);

        newUser = appUserRepo.save(newUser);

    }



}
