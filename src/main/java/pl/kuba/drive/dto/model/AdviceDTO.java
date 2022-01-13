package pl.kuba.drive.dto.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class AdviceDTO {

    private Long id;
    private String title;
    private String content;
    private int points;
    private List<String> photos;
    private List<TagToAdviceDTO> tags;
    private TrainingDTO training;

}
