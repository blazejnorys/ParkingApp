package pl.training.backend.parking.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.training.backend.parking.entity.Parking;
import pl.training.backend.parking.repository.ParkingRepository;

/**
 * Created by Pingwinek on 2017-07-27.
 */
@Data
@Service
public class ParkingService {

    @Autowired
    ParkingRepository parkingRepository;

    public void addParking(Parking parking){
        parkingRepository.saveAndFlush(parking);
    }

    public Parking getParkingId(long id){return parkingRepository.findOne(id);}
}
