package pl.kuba.drive.service;

import org.springframework.stereotype.Service;
import pl.kuba.drive.dto.model.AnswerDTO;
import pl.kuba.drive.dto.model.QuestionDTO;

import java.util.List;

@Service
public interface QuestionService {

    List<QuestionDTO> findAll();

    QuestionDTO findById(Long id);

    QuestionDTO create(QuestionDTO question);

    void deleteById(Long id);

    
}
