package pl.kuba.drive.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "answers")
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean correct;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;


}
