package uz.boom.core_project_jwt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.core_project_jwt.dto.article_title.ArticleTypeCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTypeDTO;
import uz.boom.core_project_jwt.dto.glossary.GlossaryTypeCreateDTO;
import uz.boom.core_project_jwt.dto.glossary.GlossaryTypeDTO;
import uz.boom.core_project_jwt.entity.ArticleType;
import uz.boom.core_project_jwt.entity.GlossaryType;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;

import java.util.List;

/**
 * @author Jarvis on Tue 20:57. 18/04/23
 */
@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GlossaryTypeMapper extends BaseMapper {


    List<GlossaryTypeDTO> toDTO(List<GlossaryType> glossaryTypes);

    GlossaryTypeDTO toDTO(GlossaryType glossaryType);

    GlossaryType fromCreateDTO(GlossaryTypeCreateDTO createDTO);

    GlossaryType fromUpdateDTO(GlossaryTypeDTO updateDTO, @MappingTarget GlossaryType target);

}
