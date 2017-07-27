package pl.training.backend.profiles.entity;

import lombok.Data;
import pl.training.backend.security.entity.User;

import javax.persistence.*;

/**
 * Created by Pingwinek on 2017-07-26.
 */
@Table(name="profiles")
@Entity
@Data
public class Profile {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
}
