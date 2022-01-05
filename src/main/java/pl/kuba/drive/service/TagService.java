package pl.kuba.drive.service;

import org.springframework.stereotype.Service;
import pl.kuba.drive.dto.model.TagDTO;

import java.util.List;

@Service
public interface TagService {

    List<TagDTO> findAll();

    TagDTO findById(Long id);

    TagDTO create(TagDTO advice);

    void deleteById(Long id);
    
}
