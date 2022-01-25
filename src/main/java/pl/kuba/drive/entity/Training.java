package pl.kuba.drive.entity;

import lombok.Data;
import pl.kuba.drive.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trainings")
@Data
public class Training extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(
            mappedBy = "training",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions;

}
