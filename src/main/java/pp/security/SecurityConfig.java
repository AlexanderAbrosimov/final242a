package pp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pp.service.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final LoginSuccessHandler loginSuccessHandler;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserService userService, LoginSuccessHandler loginSuccessHandler, PasswordEncoder passwordEncoder){
    this.userService = userService;
    this.loginSuccessHandler = loginSuccessHandler;
    this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .formLogin()
                .loginPage("/login")
                .successHandler(loginSuccessHandler)
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll();

        http
                .authorizeRequests(authorize -> authorize
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated());



        http.logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .and().csrf().disable();
    }

}
