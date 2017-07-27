package pl.training.backend.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import pl.training.backend.security.entity.Authority;
import pl.training.backend.security.entity.User;
import pl.training.backend.security.service.UsersService;

import javax.annotation.PostConstruct;

@Configuration
public class Security extends WebSecurityConfigurerAdapter {

    @PostConstruct
    public void init(){
        try {
            usersService.loadUserByUsername("admin");
        }catch (UsernameNotFoundException ex){
            User user = new User("admin","123");
            user.addAuthority(new Authority(Role.ADMIN.name()));
            usersService.addUser(user);
        }
    }

    @Autowired
    private UsersService usersService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(passwordEncoder);
    }

}
