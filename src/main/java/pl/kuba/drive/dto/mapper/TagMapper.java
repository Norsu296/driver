package pl.kuba.drive.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import pl.kuba.drive.dto.model.TagDTO;
import pl.kuba.drive.dto.model.TagToAdviceDTO;
import pl.kuba.drive.entity.Tag;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AdviceMapper.class, QuestionMapper.class})
public interface TagMapper {

    TagDTO toTagDTO(Tag tag);

    List<TagDTO> toTagDTOs(List<Tag> tag);

    @InheritInverseConfiguration
    Tag toTag(TagDTO tagDTO);

    @InheritInverseConfiguration
    List<Tag> toTags(List<TagDTO> tagDTOs);

    List<Tag> toTagsFromAdvice(List<TagToAdviceDTO> tagToAdviceDTOs);
  
    
}
