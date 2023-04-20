package uz.boom.core_project_jwt.dto.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jarvis on Sat 16:50. 15/04/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerCreateDTO {

    private String answer;

    private Boolean isRight;

}
