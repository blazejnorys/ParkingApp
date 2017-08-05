package pl.training.backend.reservation.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.backend.common.model.Mapper;
import pl.training.backend.common.model.ResultPage;
import pl.training.backend.common.web.UriBuilder;
import pl.training.backend.parking.service.ParkingService;
import pl.training.backend.reservation.dto.ReservationDto;
import pl.training.backend.reservation.dto.ReservationPageDto;
import pl.training.backend.reservation.entity.Reservation;
import pl.training.backend.reservation.service.ReservationService;
import pl.training.backend.security.service.UsersService;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

/**
 * Created by Pingwinek on 2017-07-27.
 */
@Api(description = "Reservation resource")
@RequestMapping(value = UriBuilder.PREFIX + "/reservation")

@RestController
public class ReservationController {


    @Autowired
    private Mapper mapper;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private ParkingService parkingService;

    private UriBuilder uriBuilder = new UriBuilder();


    @ApiOperation(value = "Create new reservation")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createReservation(
            @ApiParam(name = "reservation")
            @RequestBody ReservationDto reservationDto)
//            @RequestParam(value = "parkingId", required = true) Long parkingId)
    {
        Reservation reservation = mapper.map(reservationDto, Reservation.class);
        reservation.setProfile(usersService.getActiveUser().getProfile());
        reservation.setParking(parkingService.getParkingId(reservationDto.getParking().getId()));
        reservationService.addReservation(reservation);
        URI uri = uriBuilder.requestUriWithId(reservation.getId());
        return created(uri).build();
    }

//    @ApiOperation(value = "Get all reservations", response = ReservationDto.class)
//    @RequestMapping(method = RequestMethod.GET)
//    public ReservationPageDto getAllReservation(
//            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
//            @RequestParam(required = false, defaultValue = "10", name = "pageSize") int pageSize) {
//        ResultPage<Reservation> resultPage = reservationService.getAllReservations(pageNumber, pageSize);
//        List<ReservationDto> clientsDtos = mapper.map(resultPage.getContent(), ReservationDto.class);
//        return new ReservationPageDto(clientsDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
//    }

    @ApiOperation(value = "Get all reservations", response = ReservationPageDto.class)
    @RequestMapping(method = RequestMethod.GET)
    public ReservationPageDto getAllReservations() {
        List<Reservation> resultList = reservationService.getAllReservations();
        List<ReservationDto> reservationsDto = mapper.map(resultList, ReservationDto.class);
        return new ReservationPageDto(reservationsDto, 0, 0);
    }
}
