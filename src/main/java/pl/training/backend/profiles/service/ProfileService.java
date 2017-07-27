package pl.training.backend.profiles.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.training.backend.profiles.entity.Profile;
import pl.training.backend.profiles.repository.ProfileRepository;

/**
 * Created by Pingwinek on 2017-07-26.
 */
@Data
@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public void addProfile(Profile profile){
        profileRepository.saveAndFlush(profile);
    }

}
