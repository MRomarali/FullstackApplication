package se.ecutb.OmarAli.todo_app.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/users/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/todos/todolist").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/todos/create").hasAuthority("ADMIN")
                .antMatchers("/**").permitAll()
            .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/users/userlist")
                .permitAll()
            .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
            .and()
                .exceptionHandling()
                .accessDeniedPage("/accessdenied");
    }
}
