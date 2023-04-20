package uz.boom.core_project_jwt.service.base;

import uz.boom.core_project_jwt.dto.article_title.ArticleTypeCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTypeDTO;
import uz.boom.core_project_jwt.dto.glossary.GlossaryTypeCreateDTO;
import uz.boom.core_project_jwt.dto.glossary.GlossaryTypeDTO;

import java.util.List;

/**
 * @author Jarvis on Tue 21:03. 18/04/23
 */
public interface GlossaryTypeService extends BaseService {

    Long create(GlossaryTypeCreateDTO creteDTO);

    List<GlossaryTypeDTO> getAll();

    GlossaryTypeDTO get(Long id);

    Long update(GlossaryTypeDTO dto);

    Long delete(Long id);

}
