package uz.boom.core_project_jwt.entity;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.Where;
import uz.boom.core_project_jwt.entity.base.Auditable;

/**
 * @author Jarvis on Tue 20:53. 18/04/23
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Where(clause = "deleted='FALSE'")
public class GlossaryType extends Auditable {

    private String name;
}
