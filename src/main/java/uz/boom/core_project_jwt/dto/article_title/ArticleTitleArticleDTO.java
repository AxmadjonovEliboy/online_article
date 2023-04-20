package uz.boom.core_project_jwt.dto.article_title;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jarvis on Sat 02:36. 15/04/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTitleArticleDTO {

    private ArticleTitleDTO articleTitleDTO;

    private ArticleDTO articleDTO;
}
