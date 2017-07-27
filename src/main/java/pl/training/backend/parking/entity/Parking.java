package pl.training.backend.parking.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Pingwinek on 2017-07-27.
 */
@Table(name="parkings")
@Entity
@Data
public class Parking {

    @Id
    @GeneratedValue
    long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private int slots;

    @Column (nullable = false)
    private String location;

}
