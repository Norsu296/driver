package pl.kuba.drive.dto.model;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {

    private Long id;
    private String name;
    private List<AnswerDTO> answers;

}
