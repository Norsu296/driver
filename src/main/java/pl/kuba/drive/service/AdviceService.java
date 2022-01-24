package pl.kuba.drive.service;

import org.springframework.stereotype.Service;
import pl.kuba.drive.dto.model.AdviceDTO;
import pl.kuba.drive.dto.model.AdviceShortDTO;

import java.util.List;

@Service
public interface AdviceService {

    List<AdviceShortDTO> findAll();

    AdviceDTO findById(Long id);

    AdviceDTO create(AdviceDTO advice);

    void deleteById(Long id);

    AdviceDTO edit(AdviceDTO advice);

    AdviceDTO like(Long id, String action);


}
