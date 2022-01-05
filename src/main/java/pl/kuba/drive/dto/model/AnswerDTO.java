package pl.kuba.drive.dto.model;

import lombok.Data;

@Data
public class AnswerDTO {

    private Long id;
    private String name;
    private boolean correct;

}
