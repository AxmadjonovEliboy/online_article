package uz.boom.core_project_jwt.dto.article_title;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jarvis on Sat 01:42. 15/04/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleCreateDTO {

    private String articleContent;

}
