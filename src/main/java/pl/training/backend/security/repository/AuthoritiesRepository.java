package pl.training.backend.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.backend.security.entity.Authority;

public interface AuthoritiesRepository extends JpaRepository<Authority, Long> {
}
