package uz.boom.core_project_jwt.dto.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Jarvis on Sun 01:29. 16/04/23
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizCreateDTO {

    private Integer size;
    private String level;
    private String language;
    private Long quizTypeId;

}
