package pl.training.backend.reservation.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.training.backend.common.model.ResultPage;
import pl.training.backend.reservation.entity.Reservation;
import pl.training.backend.reservation.repository.ReservationRepository;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-27.
 */
@Data
@Service
public class ReservationService {


    @Autowired
    ReservationRepository reservationRepository;

    public void addReservation(Reservation reservation){

        reservationRepository.saveAndFlush(reservation);
    }

//    public ResultPage<Reservation> getAllReservations(int pageNumber, int pageSize) {
//        Page<Reservation> reservationsPage = reservationRepository.findAll(new PageRequest(pageNumber, pageSize));
//        return new ResultPage<>(reservationsPage.getContent(), reservationsPage.getNumber(), reservationsPage.getTotalPages());
//    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.getReservations();
    }
}
