package pl.kuba.drive.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.drive.dto.mapper.AdviceMapper;
import pl.kuba.drive.dto.mapper.TagMapper;
import pl.kuba.drive.dto.model.TagDTO;
import pl.kuba.drive.exception.ControllerException;
import pl.kuba.drive.exception.ErrorMessage;
import pl.kuba.drive.repository.TagRepository;
import pl.kuba.drive.service.TagService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;
    private final AdviceMapper adviceMapper;

    @Override
    public List<TagDTO> findAll() {
        return tagMapper.toTagDTOs(tagRepository.findAll());
    }

    @Override
    public TagDTO findById(Long id) {
        return tagMapper.toTagDTO(tagRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }

    @Override
    public TagDTO create(TagDTO tag) {
        validateTagExists(tag);
        return tagMapper.toTagDTO(tagRepository.save(tagMapper.toTag(tag)));
    }

    @Override
    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public TagDTO edit(TagDTO tagDTO) {
        return tagMapper.toTagDTO(tagRepository.findById(tagDTO.getId())
            .map(tagFromDb -> {
                tagFromDb.setName(tagDTO.getName());
                tagFromDb.setAdvices(adviceMapper.toAdviceShorts(tagDTO.getAdvices()));
                return tagRepository.save(tagFromDb);
        }).orElseThrow(() -> new ControllerException(ErrorMessage.NOT_FOUND)));
    }


    private void validateTagExists(TagDTO tag){
        if(tagRepository.findByName(tag.getName()).isPresent()) {
            throw new ControllerException(ErrorMessage.RESOURCE_EXISTS);
        }
    }
    
}
