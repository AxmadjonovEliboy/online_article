package uz.boom.core_project_jwt.service.base;

import uz.boom.core_project_jwt.dto.article_title.*;

import java.util.List;

/**
 * @author Jarvis on Sat 02:12. 15/04/23
 */
public interface ArticleService extends BaseService {
    Long create(ArticleCreateDTO articleCreateDTO);

    List<ArticleDTO> getAll();

    ArticleDTO get(Long id);

    Long update(ArticleUpdateDTO dto);

    Long delete(Long id);
}
