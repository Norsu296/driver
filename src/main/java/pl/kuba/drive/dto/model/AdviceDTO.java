package pl.kuba.drive.dto.model;

import lombok.Data;


import java.util.List;


@Data
public class AdviceDTO {

    private Long id;
    private String title;
    private String content;
    private int points;
    private String photoUrl;
    private List<TagToAdviceDTO> tags;
    private TrainingDTO training;

}
