package pl.training.backend.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.training.backend.reservation.entity.Reservation;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-27.
 */
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("SELECT r FROM Reservation r left join fetch r.parking left join fetch r.profile")
    List<Reservation> getReservations();
}
