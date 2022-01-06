package pl.kuba.drive.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import pl.kuba.drive.dto.model.TagDTO;
import pl.kuba.drive.dto.model.TagDTO;
import pl.kuba.drive.dto.model.TagToAdviceDTO;
import pl.kuba.drive.entity.Tag;
import pl.kuba.drive.entity.Tag;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {AdviceMapper.class})
public interface TagMapper {

    TagDTO toTagDTO(Tag tag);

    List<TagDTO> toTagDTOs(List<Tag> tag);

    @InheritInverseConfiguration
    Tag toTag(TagDTO tagDTO);

    @InheritInverseConfiguration
    List<Tag> toTags(List<TagDTO> tagDTOs);

    List<Tag> toTagsFromAdvice(List<TagToAdviceDTO> tagToAdviceDTOs);
  
    
}
