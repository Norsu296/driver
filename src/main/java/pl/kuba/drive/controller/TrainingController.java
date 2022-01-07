package pl.kuba.drive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kuba.drive.dto.model.TrainingDTO;
import pl.kuba.drive.service.TrainingService;

import java.util.List;

@RestController
@RequestMapping("/trainings")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping
    public List<TrainingDTO> findAll() {
        return trainingService.findAll();
    }

    @GetMapping("/{id}")
    public TrainingDTO findById(@PathVariable Long id) {
        return trainingService.findById(id);
    }

    @PostMapping
    public TrainingDTO create(@RequestBody TrainingDTO trainingDTO) {
        return trainingService.create(trainingDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        trainingService.deleteById(id);
    }

    @PutMapping
    public TrainingDTO edit(@RequestBody TrainingDTO trainingDTO){
        return trainingService.edit(trainingDTO);
    }


}
