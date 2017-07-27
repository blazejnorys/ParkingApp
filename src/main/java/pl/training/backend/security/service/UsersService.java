package pl.training.backend.security.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.training.backend.common.model.ResultPage;
import pl.training.backend.security.configuration.Role;
import pl.training.backend.security.entity.Authority;
import pl.training.backend.security.entity.User;
import pl.training.backend.security.repository.UsersRepository;

import java.security.Principal;

public class UsersService implements UserDetailsService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user) {
        user.setActive(true);
        encodeUserPassword(user);
        setDefaultAuthority(user);
        usersRepository.saveAndFlush(user);
    }

    public ResultPage<User> getUsers(int pageNumber, int pageSize) {
        Page<User> usersPage = usersRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(usersPage.getContent(), usersPage.getNumber(), usersPage.getTotalPages());
    }

    public void validateOwnership(Principal principal, Long resourceId) {
        User user = (User) principal;
        if (!user.getId().equals(resourceId)) {
            throw new WrongOwnerException();
        }
    }

    private void encodeUserPassword(User user) {
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
    }

    private void setDefaultAuthority(User user) {
        Authority authority = new Authority(Role.USER.nameWithPrefix());
        user.addAuthority(authority);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.getByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
    }

}
