package pl.kuba.drive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kuba.drive.dto.model.AnswerDTO;
import pl.kuba.drive.dto.model.QuestionDTO;
import pl.kuba.drive.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping()
    public List<QuestionDTO> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public QuestionDTO findById(@PathVariable Long id) {
        return questionService.findById(id);
    }

    @PostMapping
    public QuestionDTO create(@RequestBody QuestionDTO questionDTO) {
        return questionService.create(questionDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        questionService.deleteById(id);
    }

    @PutMapping
    public QuestionDTO edit(@RequestBody QuestionDTO questionDTO){
        return questionService.edit(questionDTO);
    }
    
    
}
