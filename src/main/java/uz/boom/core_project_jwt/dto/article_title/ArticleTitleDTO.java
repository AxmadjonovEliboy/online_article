package uz.boom.core_project_jwt.dto.article_title;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Jarvis on Sat 01:47. 15/04/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTitleDTO {

    private Long id;

    private String name;

    private String description;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;
}
