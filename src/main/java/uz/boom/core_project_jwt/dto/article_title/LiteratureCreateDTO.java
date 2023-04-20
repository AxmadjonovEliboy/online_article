package uz.boom.core_project_jwt.dto.article_title;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.boom.core_project_jwt.enums.LiteratureType;

/**
 * @author Jarvis on Tue 03:26. 18/04/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiteratureCreateDTO {

    private String title;
    private LiteratureType literatureType;

}
