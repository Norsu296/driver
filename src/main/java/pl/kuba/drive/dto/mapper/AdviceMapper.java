package pl.kuba.drive.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kuba.drive.dto.model.AdviceDTO;
import pl.kuba.drive.dto.model.AdviceToTagDTO;
import pl.kuba.drive.entity.Advice;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AdviceMapper {

    @Mapping(target = "photos", ignore = true)
    AdviceDTO toAdviceDTO(Advice advice);


    List<AdviceDTO> toAdviceDTOs(List<Advice> advice);

    @Mapping(target = "photos", ignore = true)
    @InheritInverseConfiguration
    Advice toAdvice(AdviceDTO adviceDTO);

    @InheritInverseConfiguration
    List<Advice> toAdvices(List<AdviceDTO> adviceDTOs);

    List<Advice> toAdvicesFromTag(List<AdviceToTagDTO> adviceToTagDTOs);

}
