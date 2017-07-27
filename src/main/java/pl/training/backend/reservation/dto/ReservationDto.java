package pl.training.backend.reservation.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pl.training.backend.parking.dto.ParkingDto;
import pl.training.backend.profiles.dto.ProfileDto;

import java.util.Date;

/**
 * Created by Pingwinek on 2017-07-27.
 */
@ApiModel(value = "Reservation")
@Data
public class ReservationDto {

    @ApiModelProperty(required = true)
    long id;

    @ApiModelProperty(required = true)
    private Date beginDate;

    @ApiModelProperty(required = true)
    private Date endDate;

    @ApiModelProperty(required = true)
    private ParkingDto parking;

    @ApiModelProperty(required = true)
    private ProfileDto profile;

}
