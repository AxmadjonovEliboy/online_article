package uz.boom.core_project_jwt.dto.quiz;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.base.GenericDTO;

/**
 * @author Jarvis on Tue 23:50. 18/04/23
 */
@Getter
@Setter
public class QuizTypeDTO extends GenericDTO {

    private String name;

    private String description;

    public QuizTypeDTO(@NotBlank Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
