package pl.kuba.drive.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.drive.dto.mapper.AnswerMapper;
import pl.kuba.drive.dto.model.AnswerDTO;
import pl.kuba.drive.exception.ControllerException;
import pl.kuba.drive.exception.ErrorMessage;
import pl.kuba.drive.repository.AnswerRepository;
import pl.kuba.drive.service.AnswerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    @Override
    public List<AnswerDTO> findAll() {
        return answerMapper.toAnswerDTOs(answerRepository.findAll());
    }

    @Override
    public AnswerDTO findById(Long id) {
        return answerMapper.toAnswerDTO(answerRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }

    @Override
    public void deleteById(Long id) {
        answerRepository.deleteById(id);
    }

    @Override
    public AnswerDTO edit(AnswerDTO answer) {
        return answerMapper.toAnswerDTO(answerRepository.findById(answer.getId())
                .map(answerFromDb -> {
                    answerFromDb.setName(answer.getName());
                    answerFromDb.setCorrect(answer.isCorrect());
                    return answerRepository.save(answerFromDb);
                }).orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }

}
