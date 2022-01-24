package pl.kuba.drive.entity;

import lombok.Data;
import pl.kuba.drive.model.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "questions")
@Data
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(
            mappedBy = "question",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    private List<Answer> answers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Training training;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "question_id")
    private List<Photo> photos;

}
