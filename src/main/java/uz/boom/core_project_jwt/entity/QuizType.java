package uz.boom.core_project_jwt.entity;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.Where;
import uz.boom.core_project_jwt.entity.base.Auditable;

/**
 * @author Jarvis on Tue 23:44. 18/04/23
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Where(clause = "deleted='FALSE'")
public class QuizType extends Auditable {

    private String name;

    private String description;

}
