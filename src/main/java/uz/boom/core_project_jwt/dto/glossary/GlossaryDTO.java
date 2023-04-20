package uz.boom.core_project_jwt.dto.glossary;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.base.GenericDTO;

/**
 * @author Jarvis on Tue 04:20. 18/04/23
 */
@Getter
@Setter
public class GlossaryDTO extends GenericDTO {

    private String title;
    private String definition;

    public GlossaryDTO(@NotBlank Long id, String title, String definition) {
        super(id);
        this.title = title;
        this.definition = definition;
    }
}
