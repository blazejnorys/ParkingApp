package pl.training.backend.parking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Pingwinek on 2017-07-27.
 */
@ApiModel(value = "Parking")
@Data
public class ParkingDto {

    @ApiModelProperty(required = true)
    private long id;
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private int slots;
    @ApiModelProperty(required = true)
    private String location;
}
