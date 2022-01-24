package pl.kuba.drive.entity;

import lombok.Data;
import pl.kuba.drive.model.BaseEntity;

import javax.persistence.*;

@Entity
@Data
public class UserPoints extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int points;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

}
