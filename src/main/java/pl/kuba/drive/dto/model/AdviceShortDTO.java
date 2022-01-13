package pl.kuba.drive.dto.model;

import lombok.Data;

@Data
public class AdviceShortDTO {

    private Long id;
    private String title;
    private String content;
    private int points;

}
