package uz.boom.core_project_jwt.dto.article_title;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.base.GenericDTO;
import uz.boom.core_project_jwt.enums.LiteratureType;

/**
 * @author Jarvis on Tue 03:26. 18/04/23
 */
@Getter
@Setter
public class LiteratureDTO extends GenericDTO {

    private String title;
    private LiteratureType literatureType;

    public LiteratureDTO(@NotBlank Long id, String title, LiteratureType literatureType) {
        super(id);
        this.title = title;
        this.literatureType = literatureType;
    }
}
