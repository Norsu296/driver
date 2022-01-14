package pl.kuba.drive.dto.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class QuestionDTO {

    private Long id;
    @NotEmpty
    @Size(min = 3, message = "Field name must have at least 3 characters")
    private String name;
    private List<AnswerDTO> answers;
    private List<String> photos;

}
