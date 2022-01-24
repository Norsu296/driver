package pl.kuba.drive.entity;

import lombok.Data;
import pl.kuba.drive.model.BaseEntity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "tags")
@Data
public class Tag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Advice> advices;


}
