package pl.training.backend.profiles.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.training.backend.common.model.Mapper;
import pl.training.backend.common.web.UriBuilder;
import pl.training.backend.profiles.dto.ProfileDto;
import pl.training.backend.profiles.entity.Profile;
import pl.training.backend.profiles.service.ProfileService;
import pl.training.backend.security.dto.UserDto;
import pl.training.backend.security.entity.User;
import pl.training.backend.security.service.UsersService;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

/**
 * Created by Pingwinek on 2017-07-26.
 */
@Api(description = "Profile resource")
@RequestMapping(value = UriBuilder.PREFIX + "/profile")
@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private Mapper mapper;
    @Autowired
    private UsersService usersService;

    private UriBuilder uriBuilder = new UriBuilder();

    //response entity generuje obiekt i wysyla http w odpowiedzi
    @Transactional
    @ApiOperation(value = "Create new profile")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createProfile(@ApiParam(name = "profile") @RequestBody UserDto userDto){
        User user = mapper.map(userDto, User.class);
        Profile profile = mapper.map(userDto.getProfileDto(), Profile.class);
        user.setProfile(profile);
        usersService.addUser(user);
        URI uri = uriBuilder.requestUriWithId(profile.getId());
        return created(uri).build();
    }



}
