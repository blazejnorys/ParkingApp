package pl.training.backend.parking.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.training.backend.common.model.ResultPage;
import pl.training.backend.parking.entity.Parking;
import pl.training.backend.parking.repository.ParkingRepository;

import java.util.List;

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

    public ResultPage<Parking> getAllParkings(int pageNumber, int pageSize) {
        Page<Parking> parkingPage = parkingRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(parkingPage.getContent(), parkingPage.getNumber(), parkingPage.getTotalPages());
    }
}