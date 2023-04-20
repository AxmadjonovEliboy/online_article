package uz.boom.core_project_jwt.dto.question;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.base.GenericDTO;

/**
 * @author Jarvis on Sun 17:13. 16/04/23
 */
@Getter
@Setter
public class QuestionTitleAnswerDTO extends GenericDTO {

    private String title;
    private Boolean isRight;

    public QuestionTitleAnswerDTO(@NotBlank Long id, String title, Boolean isRight) {
        super(id);
        this.title = title;
        this.isRight = isRight;
    }
}
