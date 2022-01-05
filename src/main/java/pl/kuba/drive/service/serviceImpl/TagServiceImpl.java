package pl.kuba.drive.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import pl.kuba.drive.dto.mapper.TagMapper;
import pl.kuba.drive.dto.model.TagDTO;
import pl.kuba.drive.exception.ControllerException;
import pl.kuba.drive.exception.ErrorMessage;
import pl.kuba.drive.repository.TagRepository;
import pl.kuba.drive.service.TagService;

import java.util.List;

@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

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
        return tagMapper.toTagDTO(tagRepository.save(tagMapper.toTag(tag)));
    }

    @Override
    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }
    
}
