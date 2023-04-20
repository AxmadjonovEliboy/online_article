package uz.boom.core_project_jwt.dto.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.question.QuestionDTO;

import java.util.List;

/**
 * @author Jarvis on Sun 01:23. 16/04/23
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {

    private Long id;

    private List<QuestionDTO> questions;

}
