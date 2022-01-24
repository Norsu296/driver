package pl.kuba.drive.dto.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class AdviceDTO {

    private Long id;
    @NotEmpty
    @Size(min = 3, message = "Field title must have at least 3 characters")
    private String title;
    @NotEmpty
    @Size(min = 3, message = "Field content must have at least 3 characters")
    private String content;
    private int points;
    private List<String> photos;
    private List<TagToAdviceDTO> tags;
    private TrainingDTO training;

}
