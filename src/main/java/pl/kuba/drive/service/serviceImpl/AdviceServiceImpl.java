package pl.kuba.drive.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.drive.dto.mapper.AdviceMapper;
import pl.kuba.drive.dto.mapper.QuestionMapper;
import pl.kuba.drive.dto.mapper.TagMapper;
import pl.kuba.drive.dto.model.AdviceDTO;
import pl.kuba.drive.dto.model.TagDTO;
import pl.kuba.drive.exception.ControllerException;
import pl.kuba.drive.exception.ErrorMessage;
import pl.kuba.drive.repository.AdviceRepository;
import pl.kuba.drive.service.AdviceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdviceServiceImpl implements AdviceService {

    private final AdviceRepository adviceRepository;
    private final AdviceMapper adviceMapper;
    private final TagMapper tagMapper;
    private final QuestionMapper questionMapper;

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

    @Override
    public AdviceDTO edit(AdviceDTO advice) {
        return adviceMapper.toAdviceDTO(adviceRepository.findById(advice.getId())
        .map(adviceFromDb -> {
            adviceFromDb.setTitle(advice.getTitle());
            adviceFromDb.setContent(advice.getContent());
            adviceFromDb.setQuestions(questionMapper.toQuestions(advice.getQuestions()));
            return adviceRepository.save(adviceFromDb);
        }).orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }

    @Override
    public AdviceDTO editTagsByAdviceId(Long id, List<TagDTO> tags) {
        return adviceMapper.toAdviceDTO(adviceRepository.findById(id)
                .map(adviceFromDb -> {
                    adviceFromDb.setTags(tagMapper.toTags(tags));
                    return adviceRepository.save(adviceFromDb);
                }).orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));

    }

}
