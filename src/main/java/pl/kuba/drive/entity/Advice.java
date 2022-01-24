package pl.kuba.drive.entity;

import lombok.Data;
import pl.kuba.drive.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "advices")
@Data
public class Advice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String content;
    private int points;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "advice_tag",
            joinColumns = @JoinColumn(name = "advice_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @OneToOne
    private Training training;

    @OneToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "advice_id")
    private List<Photo> photos;




}
