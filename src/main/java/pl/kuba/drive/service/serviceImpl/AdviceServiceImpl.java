package pl.kuba.drive.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import pl.kuba.drive.dto.mapper.AdviceMapper;
import pl.kuba.drive.dto.model.AdviceDTO;
import pl.kuba.drive.exception.ControllerException;
import pl.kuba.drive.exception.ErrorMessage;
import pl.kuba.drive.repository.AdviceRepository;
import pl.kuba.drive.service.AdviceService;

import java.util.List;

@RequiredArgsConstructor
public class AdviceServiceImpl implements AdviceService {

    private final AdviceRepository adviceRepository;
    private final AdviceMapper adviceMapper;

    @Override
    public List<AdviceDTO> findAll() {
        return adviceMapper.toAdviceDTOs(adviceRepository.findAll());
    }

    @Override
    public AdviceDTO findById(Long id) {
        return adviceMapper.toAdviceDTO(adviceRepository.findById(id)
        .orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }

    @Override
    public AdviceDTO create(AdviceDTO advice) {
        return adviceMapper.toAdviceDTO(adviceRepository.save(adviceMapper.toAdvice(advice)));
    }

    @Override
    public void deleteById(Long id) {
        adviceRepository.deleteById(id);
    }
}
