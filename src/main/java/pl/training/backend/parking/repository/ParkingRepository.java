package pl.training.backend.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.backend.parking.entity.Parking;

/**
 * Created by Pingwinek on 2017-07-27.
 */
public interface ParkingRepository extends JpaRepository<Parking,Long> {

}
