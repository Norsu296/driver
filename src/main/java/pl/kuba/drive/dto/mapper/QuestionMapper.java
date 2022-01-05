package pl.kuba.drive.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import pl.kuba.drive.dto.model.QuestionDTO;
import pl.kuba.drive.entity.Question;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TagMapper.class})
public interface QuestionMapper {

    QuestionDTO toQuestionDTO(Question question);

    List<QuestionDTO> toQuestionDTOs(List<Question> question);

    @InheritInverseConfiguration
    Question toQuestion(QuestionDTO questionDTO);

    @InheritInverseConfiguration
    List<Question> toQuestions(List<QuestionDTO> questionDTOs);

}