package uz.boom.core_project_jwt.dto.article_title;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.base.GenericDTO;

/**
 * @author Jarvis on Mon 16:46. 17/04/23
 */
@Getter
@Setter
public class ArticleTypeDTO extends GenericDTO {

    private String name;

    public ArticleTypeDTO(@NotBlank Long id, String name) {
        super(id);
        this.name = name;
    }
}
