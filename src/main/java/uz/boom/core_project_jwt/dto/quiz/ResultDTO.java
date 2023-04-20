package uz.boom.core_project_jwt.dto.quiz;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.base.GenericDTO;

/**
 * @author Jarvis on Wed 16:46. 19/04/23
 */

@Getter
@Setter
public class ResultDTO extends GenericDTO {

    private String result;

    private Long quizId;

    private String optional;

    public ResultDTO(@NotBlank Long id, String result, Long quizId, String optional) {
        super(id);
        this.result = result;
        this.quizId = quizId;
        this.optional = optional;
    }


}
