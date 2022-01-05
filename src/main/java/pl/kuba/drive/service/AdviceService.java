package pl.kuba.drive.service;

import org.springframework.stereotype.Service;
import pl.kuba.drive.dto.model.AdviceDTO;

import java.util.List;

@Service
public interface AdviceService {

    List<AdviceDTO> findAll();

    AdviceDTO findById(Long id);

    AdviceDTO create(AdviceDTO advice);

    void deleteById(Long id);

}