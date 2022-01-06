package pl.kuba.drive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kuba.drive.dto.model.QuestionDTO;
import pl.kuba.drive.entity.Question;
import pl.kuba.drive.repository.QuestionRepository;

import java.util.List;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {

    private final QuestionRepository questionRepository;

    @GetMapping
    public List<Question> findTrainingQuestions(@RequestParam String tag){
        return questionRepository.findTrainingQuestions(tag);
    }

}
