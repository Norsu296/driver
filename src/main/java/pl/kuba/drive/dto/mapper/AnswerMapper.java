package pl.kuba.drive.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kuba.drive.dto.model.AnswerDTO;
import pl.kuba.drive.entity.Answer;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(target = "checked", ignore = true)
    AnswerDTO toAnswerDTO(Answer answer);

    List<AnswerDTO> toAnswerDTOs(List<Answer> answer);

    @Mapping(target = "checked", ignore = true)
    @InheritInverseConfiguration
    Answer toAnswer(AnswerDTO answerDTO);

    @InheritInverseConfiguration
    List<Answer> toAnswers(List<AnswerDTO> answerDTOs);
}
