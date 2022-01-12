package pl.kuba.drive.dto.model;

import lombok.Data;
import pl.kuba.drive.entity.Training;

@Data
public class AdviceToTagDTO {

    private Long id;
    private String title;
    private String content;
    private int points;
    private TrainingDTO training;

}
