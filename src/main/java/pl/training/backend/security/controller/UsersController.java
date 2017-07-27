package pl.training.backend.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import pl.training.backend.common.model.Mapper;
import pl.training.backend.common.model.ResultPage;
import pl.training.backend.common.web.UriBuilder;
import pl.training.backend.security.dto.UserDto;
import pl.training.backend.security.dto.UsersPageDto;
import pl.training.backend.security.entity.User;
import pl.training.backend.security.service.UsersService;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@Api(description = "Users resource")
@RequestMapping(value = UriBuilder.PREFIX + "/users")
@RestController
public class UsersController {

    private Mapper mapper;
    private UsersService usersService;
    private UriBuilder uriBuilder = new UriBuilder();

    @Autowired
    public UsersController(Mapper mapper, UsersService usersService) {
        this.mapper = mapper;
        this.usersService = usersService;
    }

    @ApiOperation(value = "Create new user")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@ApiParam(name = "user") @RequestBody UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        usersService.addUser(user);
        URI uri = uriBuilder.requestUriWithId(user.getId());
        return created(uri).build();
    }

    @ApiOperation(value = "Get current user", response = UserDto.class)
    @RequestMapping(value = "active", method = RequestMethod.GET)
    public UserDto getUser(OAuth2Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return mapper.map(user, UserDto.class);
    }

    @ApiOperation(value = "Get users", response = UsersPageDto.class)
    @RequestMapping(method = RequestMethod.GET)
    public UsersPageDto getUsers(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "10", name = "pageSize") int pageSize) {
        ResultPage<User> resultPage = usersService.getUsers(pageNumber, pageSize);
        List<UserDto> usersDtos = mapper.map(resultPage.getContent(), UserDto.class);
        return new UsersPageDto(usersDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
    }

}
