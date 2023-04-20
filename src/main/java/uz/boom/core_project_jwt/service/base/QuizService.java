package uz.boom.core_project_jwt.service.base;

import uz.boom.core_project_jwt.dto.quiz.QuizCreateDTO;
import uz.boom.core_project_jwt.dto.quiz.QuizDTO;

import java.util.List;

/**
 * @author Jarvis on Sun 01:10. 16/04/23
 */
public interface QuizService extends BaseService{

    QuizDTO create(QuizCreateDTO dto);
}
