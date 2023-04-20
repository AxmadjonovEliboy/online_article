package uz.boom.core_project_jwt.dto.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jarvis on Tue 23:51. 18/04/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizTypeCreateDTO {

    private String name;

    private String description;
}
