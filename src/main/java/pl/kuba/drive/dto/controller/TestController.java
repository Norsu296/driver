package pl.kuba.drive.dto.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kuba.drive.dto.mapper.AdviceMapper;
import pl.kuba.drive.dto.model.AdviceDTO;

import pl.kuba.drive.entity.Advice;
import pl.kuba.drive.repository.AdviceRepository;
import pl.kuba.drive.repository.QuestionRepository;
import pl.kuba.drive.repository.TagRepository;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final AdviceRepository adviceRepository;
    private final AdviceMapper adviceMapper;
    private final TagRepository tagRepository;


    @GetMapping("/advice")
    List<AdviceDTO> findAdvices(){
        return adviceMapper.toAdviceDTOs(adviceRepository.findAll());
    }

}
