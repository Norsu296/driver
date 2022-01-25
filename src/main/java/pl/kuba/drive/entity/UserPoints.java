package pl.kuba.drive.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users_points")
public class UserPoints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int points;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

}
