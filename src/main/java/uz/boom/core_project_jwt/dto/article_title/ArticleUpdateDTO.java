package uz.boom.core_project_jwt.dto.article_title;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.base.GenericDTO;

/**
 * @author Jarvis on Sat 02:06. 15/04/23
 */

@Getter
@Setter
public class ArticleUpdateDTO extends GenericDTO {

    private String content;

    public ArticleUpdateDTO(@NotBlank Long id, String content) {
        super(id);
        this.content = content;
    }
}
