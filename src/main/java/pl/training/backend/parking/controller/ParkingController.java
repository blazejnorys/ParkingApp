package pl.training.backend.parking.controller;

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
import pl.training.backend.parking.dto.ParkingDto;
import pl.training.backend.parking.entity.Parking;
import pl.training.backend.parking.service.ParkingService;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

/**
 * Created by Pingwinek on 2017-07-27.
 */
@Api(description = "Parking resource")
@RequestMapping(value = UriBuilder.PREFIX + "/parking")
@RestController
public class ParkingController {


    @Autowired
    private ParkingService parkingService;
    @Autowired
    private Mapper mapper;


    private UriBuilder uriBuilder = new UriBuilder();

    @Transactional
    @ApiOperation(value = "Create new parking")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createParking(@ApiParam(name = "parking") @RequestBody ParkingDto parkingDto){
        Parking parking = mapper.map(parkingDto, Parking.class);

        parkingService.addParking(parking);
        URI uri = uriBuilder.requestUriWithId(parking.getId());
        return created(uri).build(); //standard do zwracania nagłówko z http
    }

}
