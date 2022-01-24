package pl.kuba.drive.dto.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AnswerDTO {

    private Long id;
    @NotEmpty
    @Size(min = 3, message = "Field name must have at least 3 characters")
    private String name;
    @NotNull(message = "Field correct cannot be empty")
    private boolean correct;

    private boolean checked;
}
