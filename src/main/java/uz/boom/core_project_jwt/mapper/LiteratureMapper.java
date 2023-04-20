package uz.boom.core_project_jwt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.core_project_jwt.dto.article_title.LiteratureCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.LiteratureDTO;
import uz.boom.core_project_jwt.entity.Literature;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;

import java.util.List;

/**
 * @author Jarvis on Tue 03:24. 18/04/23
 */
@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LiteratureMapper extends BaseMapper {

    List<LiteratureDTO> toDTO(List<Literature> literatures);

    LiteratureDTO toDTO(Literature literature);

    Literature fromCreateDTO(LiteratureCreateDTO createDTO);

    Literature fromUpdateDTO(LiteratureDTO updateDTO, @MappingTarget Literature target);

}
