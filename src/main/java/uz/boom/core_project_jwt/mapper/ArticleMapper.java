package uz.boom.core_project_jwt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.core_project_jwt.dto.article_title.ArticleCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleUpdateDTO;
import uz.boom.core_project_jwt.entity.Article;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;

import java.util.List;

/**
 * @author Jarvis on Sat 01:09. 15/04/23
 */
@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArticleMapper extends BaseMapper {

    List<ArticleDTO> toDTO(List<Article> articles);

    ArticleDTO toDTO(Article article);

    Article fromCreateDTO(ArticleCreateDTO createDTO);

    Article fromUpdateDTO(ArticleUpdateDTO updateDTO, @MappingTarget Article target);


}
