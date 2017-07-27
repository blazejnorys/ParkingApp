package pl.training.backend.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.training.backend.security.entity.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> getByLogin(String login);

    @Transactional
    @Modifying
    @Query("delete from User u where u.login = :login and id = ?#{ principal?.id }")
    void deleteByLogin(@Param("login") String login);

}
