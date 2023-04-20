package uz.boom.core_project_jwt.dto.glossary;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.boom.core_project_jwt.dto.base.GenericDTO;

/**
 * @author Jarvis on Tue 21:00. 18/04/23
 */
@Getter
@Setter
public class GlossaryTypeDTO extends GenericDTO {

    private String name;

    public GlossaryTypeDTO(@NotBlank Long id, String name) {
        super(id);
        this.name = name;
    }
}
