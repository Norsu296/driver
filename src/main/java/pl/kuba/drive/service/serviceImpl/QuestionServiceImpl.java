package pl.kuba.drive.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.drive.dto.mapper.AnswerMapper;
import pl.kuba.drive.dto.mapper.QuestionMapper;
import pl.kuba.drive.dto.model.AnswerDTO;
import pl.kuba.drive.dto.model.QuestionDTO;
import pl.kuba.drive.exception.ControllerException;
import pl.kuba.drive.exception.ErrorMessage;
import pl.kuba.drive.repository.QuestionRepository;
import pl.kuba.drive.service.QuestionService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final AnswerMapper answerMapper;

    @Override
    public List<QuestionDTO> findAll() {
        return questionMapper.toQuestionDTOs(questionRepository.findAll());
    }

    @Override
    public QuestionDTO findById(Long id) {
        return questionMapper.toQuestionDTO(questionRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
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
    public QuestionDTO editNameById(Long id, String name) {
        return questionMapper.toQuestionDTO(questionRepository.findById(id)
                .map(questionFromDb -> {
                    questionFromDb.setName(name);
                    return questionRepository.save(questionFromDb);
                }).orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }

    @Override
    public QuestionDTO editAnswersById(Long id, List<AnswerDTO> answers) {
        return questionMapper.toQuestionDTO(questionRepository.findById(id)
                .map(questionFromDb -> {
                    questionFromDb.setAnswers(answerMapper.toAnswers(answers));
                    return questionRepository.save(questionFromDb);
                }).orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }
}
