package uz.boom.core_project_jwt.dto.glossary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jarvis on Tue 04:19. 18/04/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlossaryCreateDTO {

    private String title;
    private String definition;
    private Long glossaryTypeId;

}
