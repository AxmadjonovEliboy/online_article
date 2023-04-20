package uz.boom.core_project_jwt.service.base;

import uz.boom.core_project_jwt.dto.quiz.QuizTypeCreateDTO;
import uz.boom.core_project_jwt.dto.quiz.QuizTypeDTO;

import java.util.List;

/**
 * @author Jarvis on Tue 23:47. 18/04/23
 */
public interface QuizTypeService extends BaseService {

    Long create(QuizTypeCreateDTO creteDTO);

    List<QuizTypeDTO> getAll();

    QuizTypeDTO get(Long id);

    Long update(QuizTypeDTO dto);

    Long delete(Long id);

}
