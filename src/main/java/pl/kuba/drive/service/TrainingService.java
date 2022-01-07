package pl.kuba.drive.service;

import pl.kuba.drive.dto.model.TrainingDTO;

import java.util.List;

public interface TrainingService {

    List<TrainingDTO> findAll();

    TrainingDTO findById(Long id);

    TrainingDTO create(TrainingDTO training);

    void deleteById(Long id);

    TrainingDTO edit(TrainingDTO trainingDTO);
}
