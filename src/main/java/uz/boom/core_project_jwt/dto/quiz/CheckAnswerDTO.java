package uz.boom.core_project_jwt.dto.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.boom.core_project_jwt.dto.base.BaseDTO;

/**
 * @author Jarvis on Sun 10:39. 16/04/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckAnswerDTO implements BaseDTO {

    private Long quizId;
    private Long answerId;
    private Long questionId;

}
