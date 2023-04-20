package uz.boom.core_project_jwt.service.base;

import uz.boom.core_project_jwt.dto.article_title.ArticleCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTypeDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTypeCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleUpdateDTO;

import java.util.List;

/**
 * @author Jarvis on Mon 16:27. 17/04/23
 */
public interface ArticleTypeService extends BaseService {
    Long create(ArticleTypeCreateDTO creteDTO);

    List<ArticleTypeDTO> getAll();

    ArticleTypeDTO get(Long id);

    Long update(ArticleTypeDTO dto);

    Long delete(Long id);
}
