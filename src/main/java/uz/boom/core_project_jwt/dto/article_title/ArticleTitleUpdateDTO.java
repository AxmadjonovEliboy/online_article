package uz.boom.core_project_jwt.dto.article_title;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jarvis on Sat 01:51. 15/04/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTitleUpdateDTO {

    private Long id;

    private String name;

    private String description;

    private String articleContent;

}
