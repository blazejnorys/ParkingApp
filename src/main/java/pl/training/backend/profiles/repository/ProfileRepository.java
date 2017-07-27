package pl.training.backend.profiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.backend.profiles.entity.Profile;

/**
 * Created by Pingwinek on 2017-07-26.
 */
public interface ProfileRepository extends JpaRepository<Profile,Long> {



}
