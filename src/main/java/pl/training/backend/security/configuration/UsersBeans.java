package pl.training.backend.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import pl.training.backend.security.repository.UsersRepository;
import pl.training.backend.security.service.UsersService;

@Configuration
public class UsersBeans {

    @Bean
    public UsersService usersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        return new UsersService(usersRepository, passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }

}
