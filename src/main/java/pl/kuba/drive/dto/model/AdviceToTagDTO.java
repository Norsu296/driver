package pl.kuba.drive.dto.model;

import lombok.Data;

@Data
public class AdviceToTagDTO {

    private Long id;
    private String title;
    private String content;
    private int points;

}
