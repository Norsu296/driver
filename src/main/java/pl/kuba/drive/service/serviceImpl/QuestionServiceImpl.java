package pl.kuba.drive.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.drive.config.properties.ApiProperties;
import pl.kuba.drive.dto.mapper.AnswerMapper;
import pl.kuba.drive.dto.mapper.QuestionMapper;
import pl.kuba.drive.dto.model.QuestionDTO;
import pl.kuba.drive.dto.model.AnswerDTO;
import pl.kuba.drive.dto.model.QuestionDTO;
import pl.kuba.drive.entity.Photo;
import pl.kuba.drive.entity.Question;
import pl.kuba.drive.exception.ControllerException;
import pl.kuba.drive.exception.ErrorMessage;
import pl.kuba.drive.repository.QuestionRepository;
import pl.kuba.drive.service.QuestionService;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ApiProperties apiProperties;
    private final QuestionMapper questionMapper;
    private final AnswerMapper answerMapper;

    @Override
    public List<QuestionDTO> findAll() {
        return questionMapper.toQuestionDTOs(questionRepository.findAll());
    }

    @Override
    public QuestionDTO findById(Long id) {
        if(questionRepository.findById(id).isPresent()){
            List<Photo> photos = questionRepository.getById(id).getPhotos();
            List<String> photoPaths = new ArrayList<>();
            for(Photo photo : photos){
                photoPaths.add(apiProperties.getUrl() + "/photos/question/" + id + "/" + photo.getName());
            }
            QuestionDTO questionDTO = questionMapper.toQuestionDTO(questionRepository.getById(id));
            questionDTO.setPhotos(photoPaths);
            return questionDTO;
        }
        throw new ControllerException(ErrorMessage.NOT_FOUND);
    }

    @Override
    public QuestionDTO create(QuestionDTO question) {
        return questionMapper.toQuestionDTO(questionRepository.save(questionMapper.toQuestion(question)));
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public QuestionDTO edit(QuestionDTO questionDTO) {
        return questionMapper.toQuestionDTO(questionRepository.findById(questionDTO.getId())
                .map(questionFromDb -> {
                    questionFromDb.setName(questionDTO.getName());
                    questionFromDb.setAnswers(answerMapper.toAnswers(questionDTO.getAnswers()));
                    return questionRepository.save(questionFromDb);
                }).orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }

}
