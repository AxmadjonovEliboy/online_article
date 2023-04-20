package uz.boom.core_project_jwt.service.base;

import uz.boom.core_project_jwt.dto.question.QuestionCreateDTO;
import uz.boom.core_project_jwt.dto.question.QuestionDTO;
import uz.boom.core_project_jwt.dto.question.QuestionUpdateDTO;

import java.util.List;

/**
 * @author Jarvis on Sat 16:58. 15/04/23
 */
public interface QuestionService extends BaseService {

    Long create(QuestionCreateDTO dto);

    QuestionDTO get(Long id);

    List<QuestionDTO> getAll();

    Long update(QuestionUpdateDTO dto);

    Long delete(Long id);
}
