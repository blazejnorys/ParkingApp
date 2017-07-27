package pl.training.backend.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pl.training.backend.profiles.dto.ProfileDto;
import pl.training.backend.profiles.entity.Profile;

import java.util.Set;

@ApiModel(value = "User")
@Data
public class UserDto {

    private ProfileDto profileDto;

    @ApiModelProperty(required = true)
    private String login;

    @JsonProperty(access = Access.WRITE_ONLY)
    @ApiModelProperty(required = true)
    private String password;

    @JsonProperty(access = Access.READ_ONLY)
    private Set<AuthorityDto> authorities;


}
