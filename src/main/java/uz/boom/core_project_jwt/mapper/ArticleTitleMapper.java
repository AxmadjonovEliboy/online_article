package uz.boom.core_project_jwt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.core_project_jwt.dto.article_title.ArticleTitleCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTitleDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTitleUpdateDTO;
import uz.boom.core_project_jwt.entity.ArticleTitle;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;

import java.util.List;

/**
 * @author Jarvis on Sat 01:08. 15/04/23
 */
@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArticleTitleMapper extends BaseMapper {

    List<ArticleTitleDTO> toDTO(List<ArticleTitle> articleTitles);

    ArticleTitleDTO toDTO(ArticleTitle articleTitle);

    ArticleTitle fromCreateDTO(ArticleTitleCreateDTO createDTO);

    ArticleTitle fromUpdateDTO(ArticleTitleUpdateDTO updateDTO, @MappingTarget ArticleTitle target);


}
