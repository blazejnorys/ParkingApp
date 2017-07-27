package pl.training.backend.profiles.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pl.training.backend.security.dto.UserDto;

/**
 * Created by Pingwinek on 2017-07-26.
 */
@ApiModel(value = "Profile")
@Data
public class ProfileDto {


    @ApiModelProperty(required = true)
    private long id;
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private String surname;
}
