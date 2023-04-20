package uz.boom.core_project_jwt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.Where;
import uz.boom.core_project_jwt.entity.base.Auditable;

/**
 * @author Jarvis on Fri 17:03. 14/04/23
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Where(clause = "deleted='FALSE'")
public class Article extends Auditable {

    //article content with style
    @Column(name = "article_content")
    private String articleContent;

    @OneToOne
    private ArticleTitle articleTitle;

}
