package pl.kuba.drive.dto.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AdviceShortDTO {

    private Long id;
    @NotEmpty
    @Size(min = 3, message = "Field title must have at least 3 characters")
    private String title;
    @NotEmpty
    @Size(min = 3, message = "Field content must have at least 3 characters")
    private int points;

}
