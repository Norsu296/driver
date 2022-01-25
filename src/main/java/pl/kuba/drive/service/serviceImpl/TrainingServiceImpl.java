package pl.kuba.drive.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.drive.dto.mapper.QuestionMapper;
import pl.kuba.drive.dto.mapper.TrainingMapper;
import pl.kuba.drive.dto.model.AnswerDTO;
import pl.kuba.drive.dto.model.QuestionDTO;
import pl.kuba.drive.dto.model.TrainingDTO;
import pl.kuba.drive.dto.model.TrainingResultDTO;
import pl.kuba.drive.entity.UserPoints;
import pl.kuba.drive.exception.ControllerException;
import pl.kuba.drive.exception.ErrorMessage;
import pl.kuba.drive.repository.TrainingRepository;
import pl.kuba.drive.repository.UserPointsRepository;
import pl.kuba.drive.service.TrainingService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;
    private final QuestionMapper questionMapper;
    private final UserPointsRepository userPointsRepository;

    @Override
    public List<TrainingDTO> findAll() {
        return trainingMapper.toTrainingDTOs(trainingRepository.findAll());
    }

    @Override
    public TrainingDTO findById(Long id) {
        return trainingMapper.toTrainingDTO(trainingRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }

    @Override
    public TrainingDTO create(TrainingDTO training) {
        return trainingMapper.toTrainingDTO(trainingRepository.save(trainingMapper.toTraining(training)));
    }

    @Override
    public void deleteById(Long id) {
        trainingRepository.deleteById(id);
    }

    @Override
    public TrainingDTO edit(TrainingDTO trainingDTO) {
        return trainingMapper.toTrainingDTO(trainingRepository.findById(trainingDTO.getId())
                .map(trainingFromDb -> {
                    trainingFromDb.setQuestions(questionMapper.toQuestions(trainingDTO.getQuestions()));
                    return trainingRepository.save(trainingFromDb);
                }).orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }

    @Override
    public TrainingResultDTO getResult(TrainingDTO trainingDTO) {
        TrainingResultDTO trainingResultDTO = new TrainingResultDTO();
        List<QuestionDTO> questionDTOs = trainingDTO.getQuestions();
        int maxPoints = questionDTOs.size();
        int points = 0;

        for (QuestionDTO questionDTO : questionDTOs) {
            List<AnswerDTO> answerDTOs = questionDTO.getAnswers();
            for (AnswerDTO answerDTO : answerDTOs) {
                if (answerDTO.isChecked()){
                    if(answerDTO.isCorrect()){
                        points++;
                    }
                }
            }
        }


        trainingResultDTO.setPoints(points);
        trainingResultDTO.setMaxPoints(maxPoints);

        UserPoints userPoints = new UserPoints();
        userPoints.setPoints(points);
        userPoints.setTraining(trainingRepository.getById(trainingDTO.getId()));

        userPointsRepository.save(userPoints);

        return trainingResultDTO;
    }
}
