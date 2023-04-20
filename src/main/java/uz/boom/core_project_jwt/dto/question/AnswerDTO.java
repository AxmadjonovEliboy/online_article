package uz.boom.core_project_jwt.dto.question;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.base.GenericDTO;

/**
 * @author Jarvis on Sun 00:27. 16/04/23
 */
@Getter
@Setter
public class AnswerDTO extends GenericDTO {

    private String answer;

    private Boolean isRight;


    public AnswerDTO(@NotBlank Long id, String answer) {
        super(id);
        this.answer = answer;
    }
}
