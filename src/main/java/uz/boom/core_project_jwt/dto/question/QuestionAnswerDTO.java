package uz.boom.core_project_jwt.dto.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jarvis on Sun 16:38. 16/04/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerDTO {

    private Long questionId;

    private Long answerId;

}
