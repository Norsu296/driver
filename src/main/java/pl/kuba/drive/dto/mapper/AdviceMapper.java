package pl.kuba.drive.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import pl.kuba.drive.dto.model.AdviceDTO;
import pl.kuba.drive.entity.Advice;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {TagMapper.class})
public interface AdviceMapper {

    AdviceDTO toAdviceDTO(Advice advice);

    List<AdviceDTO> toAdviceDTOs(List<Advice> advice);

    @InheritInverseConfiguration
    Advice toAdvice(AdviceDTO adviceDTO);

    @InheritInverseConfiguration
    List<Advice> toAdvices(List<AdviceDTO> adviceDTOs);

}
