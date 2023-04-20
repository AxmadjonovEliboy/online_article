package uz.boom.core_project_jwt.service.base;

import uz.boom.core_project_jwt.dto.article_title.ArticleTitleArticleDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTitleCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTitleDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTitleUpdateDTO;

import java.util.List;

/**
 * @author Jarvis on Sat 01:45. 15/04/23
 */
public interface ArticleTitleService extends BaseService {


    Long create(ArticleTitleCreateDTO dto);

    List<ArticleTitleDTO> getAll(Long articleTypeId);

    ArticleTitleArticleDTO get(Long id);

    Long update(ArticleTitleUpdateDTO dto);

    Long delete(Long id);

}
