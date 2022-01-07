package pl.kuba.drive.dto.model;

import lombok.Data;

import java.util.List;

@Data
public class TrainingDTO {

    private Long id;
    private List<QuestionDTO> questions;

}
