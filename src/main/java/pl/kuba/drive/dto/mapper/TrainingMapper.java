package pl.kuba.drive.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import pl.kuba.drive.dto.model.TrainingDTO;
import pl.kuba.drive.entity.Training;

import java.util.List;

@Mapper(componentModel = "spring", uses = {QuestionMapper.class})
public interface TrainingMapper {


    TrainingDTO toTrainingDTO(Training training);

    List<TrainingDTO> toTrainingDTOs(List<Training> training);

    @InheritInverseConfiguration
    Training toTraining(TrainingDTO trainingDTO);

    @InheritInverseConfiguration
    List<Training> toTrainings(List<TrainingDTO> trainingDTOs);


}
