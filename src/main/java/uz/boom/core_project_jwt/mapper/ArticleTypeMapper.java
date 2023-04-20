package uz.boom.core_project_jwt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.core_project_jwt.dto.article_title.ArticleTypeDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTypeCreateDTO;
import uz.boom.core_project_jwt.entity.ArticleType;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;

import java.util.List;

/**
 * @author Jarvis on Mon 16:29. 17/04/23
 */

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArticleTypeMapper extends BaseMapper {

    List<ArticleTypeDTO> toDTO(List<ArticleType> articleTypes);

    ArticleTypeDTO toDTO(ArticleType articleType);

    ArticleType fromCreateDTO(ArticleTypeCreateDTO createDTO);

    ArticleType fromUpdateDTO(ArticleTypeDTO updateDTO, @MappingTarget ArticleType target);
}
