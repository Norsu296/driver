package pl.kuba.drive.dto.model;

import lombok.Data;
import pl.kuba.drive.entity.Question;
import pl.kuba.drive.entity.Training;

import java.util.List;


@Data
public class AdviceDTO {

    private Long id;
    private String title;
    private String content;
    private int points;
    private List<TagToAdviceDTO> tags;
    private Training training;

}
