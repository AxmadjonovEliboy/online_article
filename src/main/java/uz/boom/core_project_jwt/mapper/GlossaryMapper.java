package uz.boom.core_project_jwt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.core_project_jwt.dto.glossary.GlossaryCreateDTO;
import uz.boom.core_project_jwt.dto.glossary.GlossaryDTO;
import uz.boom.core_project_jwt.entity.Glossary;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;

import java.util.List;

/**
 * @author Jarvis on Tue 04:16. 18/04/23
 */
@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GlossaryMapper extends BaseMapper {

    List<GlossaryDTO> toDTO(List<Glossary> glossaries);

    GlossaryDTO toDTO(Glossary glossary);

    Glossary fromCreateDTO(GlossaryCreateDTO createDTO);

    Glossary fromUpdateDTO(GlossaryDTO updateDTO, @MappingTarget Glossary target);

}
