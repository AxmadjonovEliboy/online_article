package uz.boom.core_project_jwt.service.base;

import uz.boom.core_project_jwt.dto.article_title.*;

import java.util.List;

/**
 * @author Jarvis on Tue 03:24. 18/04/23
 */
public interface LiteratureService extends BaseService {
    Long create(LiteratureCreateDTO literatureCreateDTO);

    List<LiteratureDTO> getAllByType(String type);

    LiteratureDTO get(Long id);

    Long update(LiteratureDTO dto);

    Long delete(Long id);
}
