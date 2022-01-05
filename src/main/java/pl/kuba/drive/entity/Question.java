package pl.kuba.drive.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "questions")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(
            mappedBy = "question",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
            )
    private List<Answer> answers = new ArrayList<>();

}
