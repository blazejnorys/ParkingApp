package pl.training.backend.reservation.entity;

import lombok.Data;
import pl.training.backend.parking.entity.Parking;
import pl.training.backend.profiles.entity.Profile;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pingwinek on 2017-07-27.
 */
@Table (name="reservations")
@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue
    long id;

    @Column (nullable = false)
    private Long beginDate;

    @Column (nullable = false)
    private Long endDate;

    @ManyToOne
    private Parking parking;

    @ManyToOne
    private Profile profile;

}
