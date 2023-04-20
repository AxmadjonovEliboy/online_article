package uz.boom.core_project_jwt.dto.question;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.base.GenericDTO;

import java.util.List;

/**
 * @author Jarvis on Sun 00:17. 16/04/23
 */
@Getter
@Setter
public class QuestionUpdateDTO extends GenericDTO {

    private String title;

    private List<AnswerDTO> answers;


    public QuestionUpdateDTO(@NotBlank Long id, List<AnswerDTO> answers) {
        super(id);
        this.answers = answers;
    }
}
