package uz.boom.core_project_jwt.service.base;

import uz.boom.core_project_jwt.dto.article_title.LiteratureCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.LiteratureDTO;
import uz.boom.core_project_jwt.dto.glossary.GlossaryCreateDTO;
import uz.boom.core_project_jwt.dto.glossary.GlossaryDTO;

import java.util.List;

/**
 * @author Jarvis on Tue 04:17. 18/04/23
 */
public interface GlossaryService extends BaseService {

    Long create(GlossaryCreateDTO glossaryCreateDTO);

    List<GlossaryDTO> getAll();

    GlossaryDTO get(Long id);

    Long update(GlossaryDTO dto);

    Long delete(Long id);

}
