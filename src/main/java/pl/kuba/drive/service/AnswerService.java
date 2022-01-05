package pl.kuba.drive.service;

import org.springframework.stereotype.Service;
import pl.kuba.drive.dto.model.AnswerDTO;

import java.util.List;

@Service
public interface AnswerService {

    List<AnswerDTO> findAll();

    AnswerDTO findById(Long id);

    void deleteById(Long id);

    AnswerDTO edit(AnswerDTO answerDTO);
}
