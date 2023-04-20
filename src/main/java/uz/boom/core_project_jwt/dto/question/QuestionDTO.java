package uz.boom.core_project_jwt.dto.question;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.base.GenericDTO;
import uz.boom.core_project_jwt.enums.Language;

import java.util.List;

/**
 * @author Jarvis on Sun 00:17. 16/04/23
 */
@Getter
@Setter
public class QuestionDTO extends GenericDTO {

    private String title;
    private Language language;
    private List<AnswerDTO> answers;


    public QuestionDTO(@NotBlank Long id, String title, Language language, List<AnswerDTO> answers) {
        super(id);
        this.title = title;
        this.language = language;
        this.answers = answers;
    }

}
