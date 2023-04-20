package uz.boom.core_project_jwt.entity;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.Where;
import uz.boom.core_project_jwt.entity.base.Auditable;

/**
 * @author Jarvis on Mon 16:20. 17/04/23
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Where(clause = "deleted='FALSE'")
public class ArticleType extends Auditable {

    private String name;

}
