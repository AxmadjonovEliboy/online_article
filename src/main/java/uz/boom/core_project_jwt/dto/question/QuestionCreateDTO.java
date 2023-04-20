package uz.boom.core_project_jwt.dto.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jarvis on Sat 16:48. 15/04/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCreateDTO {

    private String title;

    private Long quizTypeId;

    private List<AnswerCreateDTO> answers;

}
